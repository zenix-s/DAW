package zenixs.eventos.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class PasswordRestController {

	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * Método que encripta una contraseña con Bcrypt.
	 * 
	 * @param password
	 * @return String
	 */
	@GetMapping("/encriptar/{pass}")
	public String pruebaBcrypt(@PathVariable("pass") String password) {
		String encriptado = passwordEncoder.encode(password);
		return encriptado;
	}
}
