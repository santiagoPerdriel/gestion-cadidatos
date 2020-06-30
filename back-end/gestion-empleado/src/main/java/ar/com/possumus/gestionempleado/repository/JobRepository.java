package ar.com.possumus.gestionempleado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.possumus.gestionempleado.entity.Job;

public interface JobRepository extends JpaRepository <Job, Long>{

}
