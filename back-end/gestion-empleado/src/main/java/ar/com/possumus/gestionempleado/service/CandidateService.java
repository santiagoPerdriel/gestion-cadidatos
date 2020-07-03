/**
 * 
 */
package ar.com.possumus.gestionempleado.service;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ar.com.possumus.gestionempleado.dto.CandidateDTO;
import ar.com.possumus.gestionempleado.dto.CandidateLigthDTO;
import ar.com.possumus.gestionempleado.entity.Candidate;
import ar.com.possumus.gestionempleado.mapper.CandidateMapper;
import ar.com.possumus.gestionempleado.repository.CandidateRepository;

/**
 * @author santiago
 *
 */
@Service
public class CandidateService {

	@Autowired
	CandidateRepository candidateRepository;

	public List<CandidateLigthDTO> getAllCandidate() {
		List<CandidateLigthDTO> response = null;

		response = CandidateMapper.INSTANCE.toListLigthDTO(candidateRepository.findAll());
		response.forEach(candi -> {
			Random r = new Random();
			int valorDado = r.nextInt(3);
			candi.setRandom(valorDado);
		});
		return response;

	}

	public CandidateDTO save(Long id, CandidateDTO canditedto) {
		CandidateDTO response = null;
		Candidate candidate = CandidateMapper.INSTANCE.toEntity(canditedto);
		candidate.setIscv(false);
		candidate = candidateRepository.save(candidate);
		response = CandidateMapper.INSTANCE.toDTO(candidate);
		return response;
	}

	public CandidateDTO getCandidate(Long id) throws Exception {
		CandidateDTO response = null;
		try {
			Candidate candidate = null;
			candidate = candidateRepository.findById(id).get();
			response = CandidateMapper.INSTANCE.toDTO(candidate);

		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	public String savePDF(Long idCandidato, MultipartFile file) {
		// TODO Auto-generated method stub
		String message;
		Candidate candidate = candidateRepository.findById(idCandidato).get();

		try {

			String docu = Base64.getEncoder().encodeToString(file.getBytes());
			candidate.setCv(docu);
			candidate.setIscv(true);
			candidateRepository.save(candidate);

			message = "Successfully uploaded!";
			return (message);
		} catch (Exception e) {
			message = "Failed to upload!";
			return (message);
		}

	}

	public byte[] dowload(Long idCandidato) throws UnsupportedEncodingException {
		Candidate candidate = candidateRepository.findById(idCandidato).get();
		
		byte[] decodedString = Base64.getDecoder().decode(new String(candidate.getCv()).getBytes());

		return decodedString;

	}

	public String savePDFALL(CandidateDTO candite, MultipartFile file) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		try {
		candidateRepository.deleteById(id);
		}catch (Exception e) {
			e.getCause();
		}
		
	}

}
