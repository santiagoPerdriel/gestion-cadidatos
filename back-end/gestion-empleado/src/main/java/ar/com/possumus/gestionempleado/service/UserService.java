/**
 * 
 */
package ar.com.possumus.gestionempleado.service;

import java.util.ArrayList;
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

import ar.com.possumus.gestionempleado.entity.Rol;
import ar.com.possumus.gestionempleado.repository.RolRepository;
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
	@Autowired
	private RolRepository rolrepo;
	
	
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


	public List<ar.com.possumus.gestionempleado.entity.User> findALL() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}


	public void delete(Long idUsuario) {
		userRepository.deleteById(idUsuario);
		
	}


	public void save(ar.com.possumus.gestionempleado.entity.User user) {
		
		user.setEnabled(true);
		List<Rol> roles= rolrepo.findAll();
		user.setRoles(roles);
		userRepository.save(user);
		
	}


	public void enable(Long idUsuario) {
		ar.com.possumus.gestionempleado.entity.User user = userRepository.findById(idUsuario).get();
		user.setEnabled(true);
		userRepository.save(user);
		
	}


	public void disable(Long idUsuario) {
		ar.com.possumus.gestionempleado.entity.User user = userRepository.findById(idUsuario).get();
		user.setEnabled(false);
		userRepository.save(user);
		
	}





}
