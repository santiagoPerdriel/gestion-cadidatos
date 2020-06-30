/**
 * 
 */
package ar.com.possumus.gestionempleado.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.possumus.gestionempleado.repository.UserRepository;

/**
 * @author santiago
 *
 */
@Service
public class UserService implements UserDetailsService{
	
	private final Logger serviceLog = LoggerFactory.getLogger(UserService.class);	  
	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		ar.com.possumus.gestionempleado.entity.User user = userRepository.findByUsername(username);
		
		if(user == null) {
			serviceLog.error("Error en el login: no existe el usuario '"+username+"' en el sistema!");
			throw new UsernameNotFoundException("Error en el login: no existe el usuario '"+username+"' en el sistema!");
		}
		
		List<GrantedAuthority> authorities = user.getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getNombre()))
				.peek(authority -> serviceLog.info("Role: " + authority.getAuthority()))
				.collect(Collectors.toList());
		
		return new User(user.getUsername(), user.getPassword(), user.getEnabled(), true, true, true, authorities);
	}


	public ar.com.possumus.gestionempleado.entity.User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
