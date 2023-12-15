package com.setfernet.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.setfernet.model.dao.PedidoDao;

@Controller
@RequestMapping("/pedido")
public class PedidosController {

	@Autowired
	private PedidoDao pdao;
	
	@GetMapping({"", "/", "/home"})
	String home(Model model) {
		model.addAttribute("pedidos", pdao.findAll());
		return ("pedidos");
	}
	@InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
