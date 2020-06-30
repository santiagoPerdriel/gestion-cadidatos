/**
 * 
 */
package ar.com.possumus.gestionempleado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.possumus.gestionempleado.entity.Rol;

/**
 * @author santiago
 *
 */
public interface RolRepository extends JpaRepository <Rol, Long> {

}
