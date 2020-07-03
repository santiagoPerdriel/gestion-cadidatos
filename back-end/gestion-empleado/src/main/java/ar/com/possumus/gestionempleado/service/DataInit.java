/**
 * 
 */
package ar.com.possumus.gestionempleado.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import ar.com.possumus.gestionempleado.entity.Rol;
import ar.com.possumus.gestionempleado.entity.User;
import ar.com.possumus.gestionempleado.repository.RolRepository;
import ar.com.possumus.gestionempleado.repository.UserRepository;

/**
 * @author santiago
 *
 */
@Component
public class DataInit {

	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository repo;
	
	@Autowired 
	private	RolRepository rolrepo;
	
	@Value("${user-admin}")
	private  String userAdmin;

	@Value("${passwor-admin}")
	private String passworrAdmin;

	
	@PostConstruct
	public void dataInit() {
		
		if (repo.count()==0) {
			dataInitUser();
		}

	}


	private void dataInitUser() {
		User user = buildUserAdmin();
		Rol roladmin = new Rol();
		roladmin.setNombre("ROLE_ADMIN");
		Rol roluser = new Rol();
		roluser.setNombre("ROLE_USER");
		List<Rol> roles= new ArrayList<Rol>();
		roles.add(roluser);
		roles.add(roladmin);
		user.setRoles(roles);
		repo.save(user);
		
	}


	private User buildUserAdmin() {
		User user= new User();
		user.setUsername(userAdmin);
		user.setEnabled(true);
		user.setPassword(passwordEncoder.encode(passworrAdmin));
		user.setEmail("admin@admin.com");
		return user;
	}
	
}
