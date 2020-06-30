/**
 * 
 */
package ar.com.possumus.gestionempleado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.possumus.gestionempleado.entity.User;

/**
 * @author santiago
 *
 */
public interface UserRepository extends JpaRepository <User, Long> {
	
	public User findByUsername(String username);

}
