package net.unir.clientes.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.unir.clientes.modelo.dao.ClienteDao;
import net.unir.clientes.modelo.javabean.Cliente;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteDao cdao;
	
	@GetMapping("/editar/{id}")
	public String editarCliente(@PathVariable("id") int idCliente, Model model) {
		
		Cliente cliente = cdao.findById(idCliente);
		if(cliente != null) {
			model.addAttribute("cliente", cliente);
			return "formModifCliente";
			
		}
		else {
			model.addAttribute("mensaje", "El cliente seleecionado no existe");
			return "forward:/";
		}
	}
	
	@PostMapping("/editar/{id}")
	public String procesarEditarCliente(@PathVariable("id") int idCliente, RedirectAttributes ratt, Cliente cliente) {
		/*
		 * cliente.setFechaAlta(new Date());
		 * 
		 * if (cdao.insert(cliente) == 1) { ratt.addFlashAttribute("mensaje",
		 * "Alta realizada"); }else { ratt.addFlashAttribute("mensaje",
		 * "Alta no realizada"); }
		 */
		cliente.setIdCliente(idCliente);
		if(cdao.updateOne(cliente) == 1) {
			ratt.addFlashAttribute("mensaje", "Update realizado");
		}else {
			ratt.addFlashAttribute("mensaje", "Update no realizado");
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarCliente(@PathVariable("id") int idCliente, Model model) {
		
		if (cdao.delete(idCliente) == 1) model.addAttribute("mensaje", "Cliente eliminado correctametne");
		else model.addAttribute(model.addAttribute("mensaje", "Cliente no eliminado"));
		
		return "forward:/";
	}
	@GetMapping("/detalle/{id}")
	public String detalleCliente(@PathVariable("id") int idCliente, Model model) {
		
		Cliente cliente = cdao.findById(idCliente);
		if(cliente != null) {
			model.addAttribute("cliente", cliente);
			return "verDetalle";
			
		}
		else {
			model.addAttribute("mensaje", "El cliente seleecionado no existe");
			return "forward:/";
		}
		
	}
	
	@GetMapping("/alta")
	public String mostrarFormAlta() {
		return "formAltaCliente";
	}
	
	@PostMapping("/alta")
	public String procesarFormAlta(Cliente cliente, RedirectAttributes ratt) {
		
		cliente.setFechaAlta(new Date());
		
		if (cdao.insert(cliente) == 1) {
			ratt.addFlashAttribute("mensaje", "Alta realizada");
		}else {
			ratt.addFlashAttribute("mensaje", "Alta no realizada");
		}
		
		return "redirect:/";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
}
