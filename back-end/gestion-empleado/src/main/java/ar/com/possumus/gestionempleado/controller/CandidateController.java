/**
 * 
 */
package ar.com.possumus.gestionempleado.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ar.com.possumus.gestionempleado.dto.CandidateDTO;
import ar.com.possumus.gestionempleado.dto.CandidateLigthDTO;
import ar.com.possumus.gestionempleado.service.CandidateService;

/**
 * @author santiago
 *
 */
@RestController
@RequestMapping("/api/candidate")
public class CandidateController {

	@Autowired
	private CandidateService service;

	@GetMapping
	public ResponseEntity<?> getAllCandidate() {

		return new ResponseEntity<List<CandidateLigthDTO>>(service.getAllCandidate(), HttpStatus.OK);

	}

	@PostMapping
	public CandidateDTO saveCandidate(@RequestBody CandidateDTO candite) {

		return service.save(null, candite);

	}

	@PutMapping
	public CandidateDTO updateCandidate(Long id, @RequestBody CandidateDTO candite) {

		return service.save(id, candite);

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getCandidate(@PathVariable Long id) throws Exception {
		return new ResponseEntity<CandidateDTO>(service.getCandidate(id), HttpStatus.OK);

	}

	@PostMapping("/file/{idCandidato}")
	public ResponseEntity<String> handleFileUpload(@PathVariable("idCandidato") Long idCandidato,
			@RequestParam("file") MultipartFile file) {

		return ResponseEntity.status(HttpStatus.OK).body(service.savePDF(idCandidato, file));
	}
	
	@GetMapping("/file/{idCandidato}")
	public ResponseEntity<byte[]> handleFileDowload(@PathVariable("idCandidato") Long idCandidato) throws UnsupportedEncodingException {

		byte[] bytes =service.dowload(idCandidato);
		return ResponseEntity.ok().header("Content-Type", "application/pdf; charset=UTF-8")
				.header("Content-Disposition", "inline; filename=" + "previsualizar").body(bytes);
	}
	
	
			
	
	

}
