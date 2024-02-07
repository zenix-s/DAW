package zenixs.eventos.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import zenixs.eventos.model.dao.EventoDao;
import zenixs.eventos.model.dao.PerfilDao;
import zenixs.eventos.model.dao.TipoDao;
import zenixs.eventos.model.dao.UsuarioDao;
import zenixs.eventos.model.entity.Usuario;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private EventoDao edao;
	@Autowired
	private PerfilDao pdao;
	@Autowired
	private UsuarioDao udao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private TipoDao tdao;

	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("eventos", edao.findAllMainEvento());
		model.addAttribute("tipos", tdao.findAllTipo());
		System.out.println("Eventos: " + edao.findAllMainEvento());
		
		return "mainEventos";
	}

	@GetMapping("/registro")
	public String signup(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "registro";
	}

	@PostMapping("/registro")
	public String signupProcess(Usuario usuario, Model model, RedirectAttributes ratt) {

		usuario.setEnabled(1);
		usuario.setFechaRegistro(new Date());
		usuario.addPerfil(pdao.findPerfilById(3));
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

		System.out.println("Usuario: " + usuario);

		if (udao.registerUsuario(usuario) != null) {
			ratt.addFlashAttribute("success", "Usuario registrado con éxito");
			return "redirect:/";
		} else {
			model.addAttribute("error", "Error al registrar usuario");
			return "registro";
		}
		
	}

	@GetMapping("/index")
	public String procesarLogin(Authentication aut, Model model, HttpSession misesion) {
		
		System.out.println("usuario : " + aut.getName());
		Usuario usuario = udao.findUsuarioById(aut.getName());
		
		if (misesion.getAttribute("usuario") == null)
			misesion.setAttribute("usuario", usuario);
		
		System.out.println();
		
		for (GrantedAuthority ele: aut.getAuthorities())
			System.out.println("ROL : " + ele.getAuthority());
		
		model.addAttribute("mensaje", aut.getAuthorities());
		
		
		return "redirect:/";
	}

}
