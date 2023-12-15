package com.setfernet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.setfernet.model.dao.ClienteDao;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
	private ClienteDao cdao;
	
	@GetMapping({"","/","/home"})
	public String home(Model model) {
		model.addAttribute("clientes", cdao.findAll());
		return ("clientes");
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarCliente(@PathVariable("id") int idCliente, Model model) {
		if(cdao.delteCliente(idCliente) == 1) {
			model.addAttribute("mensaje", "Cliente eliminado");
			return ("forward:/");
		}
		return ("forward:/");
	}
}
