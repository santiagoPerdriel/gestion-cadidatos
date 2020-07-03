/**
 * 
 */
package ar.com.possumus.gestionempleado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.com.possumus.gestionempleado.repository.UserRepository;

/**
 * @author santiago
 *
 */
@Service
public class UserBackofficeService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	public void newUsser(ar.com.possumus.gestionempleado.entity.User user) {
		String pass = passwordEncoder.encode(user.getPassword());
		user.setPassword(pass);
		user.setEnabled(true);
		userRepository.save(user);
		
		
	}

}
