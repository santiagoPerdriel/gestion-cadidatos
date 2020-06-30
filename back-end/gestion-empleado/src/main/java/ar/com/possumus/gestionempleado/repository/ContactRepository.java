/**
 * 
 */
package ar.com.possumus.gestionempleado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.possumus.gestionempleado.entity.Contact;

/**
 * @author santiago
 *
 */
public interface ContactRepository extends JpaRepository <Contact, Long> {

}
