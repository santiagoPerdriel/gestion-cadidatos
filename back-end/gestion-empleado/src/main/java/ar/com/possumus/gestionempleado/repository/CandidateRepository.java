package ar.com.possumus.gestionempleado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.possumus.gestionempleado.entity.Candidate;

public interface CandidateRepository extends JpaRepository <Candidate, Long>  {

}
