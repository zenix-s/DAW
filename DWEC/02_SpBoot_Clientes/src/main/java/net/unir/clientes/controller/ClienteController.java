package net.unir.clientes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.unir.clientes.modelo.dao.ClienteDao;
import net.unir.clientes.modelo.javabean.Cliente;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteDao cdao;
	
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
	public String procesarFormAlta(Cliente cliente) {
		
		if (cdao.insert(cliente) == 1) {
			
		}
		
		return "formAltaCliente";
	}
	
}
