/**
 * 
 */
package ar.com.possumus.gestionempleado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.possumus.gestionempleado.entity.Skill;

/**
 * @author santiago
 *
 */
public interface SkillRepository extends JpaRepository <Skill, Long>{

}
