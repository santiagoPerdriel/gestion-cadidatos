/**
 * 
 */
package ar.com.possumus.gestionempleado.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ar.com.possumus.gestionempleado.dto.CandidateDTO;
import ar.com.possumus.gestionempleado.dto.CandidateLigthDTO;
import ar.com.possumus.gestionempleado.entity.Candidate;

/**
 * @author santiago
 *
 */
@Mapper
public interface CandidateMapper {
	
	CandidateMapper INSTANCE = Mappers.getMapper(CandidateMapper.class);
	
	@InheritInverseConfiguration
	CandidateDTO toDTO (Candidate candidate);
	
	List<CandidateDTO> toListDTO(List<Candidate> candidaties);
	
	@InheritInverseConfiguration
	CandidateLigthDTO toLigthDTO (Candidate candidate);
	
	List<CandidateLigthDTO> toListLigthDTO(List<Candidate> candidaties);
	
	
	Candidate toEntity (CandidateDTO candidate);
	

}
