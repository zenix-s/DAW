package zenixs.eventos.configuration;

// import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class DataUserConfiguration {

	@Bean
	public UserDetailsManager usersCustom(DataSource dataSource) {

		JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
		users.setUsersByUsernameQuery("select USERNAME, PASSWORD ,enabled from USUARIOS u where USERNAME=?");
		users.setAuthoritiesByUsernameQuery("select u.username,p.nombre from USUARIO_PERFILES up " +
				"inner join USUARIOS u on u.USERNAME = up.USERNAME " +
				"inner join PERFILES p on p.ID_PERFIL = up.ID_PERFIL " +
				"where u.USERNAME = ?");

		return users;

	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// Deshabilitar CSRF
		http.csrf(csrf -> csrf.disable());
		// Los recursos estáticos no requieren autenticación
		http.authorizeHttpRequests(authorize -> authorize
				.requestMatchers("/static/**", "/styles/**").permitAll()
				// Las vistas públicas no requieren autenticación
				.requestMatchers("/registro", "/", "/login", "/logout", "/eventos/verUno/**").permitAll()
				.requestMatchers("/eventos/activos", "/eventos/destacados").permitAll()
				.requestMatchers("/rest/encriptar/**").permitAll()
				// Todas las demás URLs de la Aplicación requieren autenticación
				// Asignar permisos a URLs por ROLES
				// .requestMatchers("/eventos/**").hasAnyAuthority("ROLE_CLIENTE")
				.requestMatchers("/reservas/**").hasAnyAuthority("ROLE_CLIENTE")
				.anyRequest().authenticated())
				// El formulario de Login no requiere autenticacion
				.formLogin(form -> form.permitAll());
		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
