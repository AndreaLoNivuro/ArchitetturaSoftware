package it.jac.lynx.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.jac.lynx.dto.Response;
import it.jac.lynx.entity.Studente;
import it.jac.lynx.service.StudenteService;


@RestController
@RequestMapping("/studente")

public class StudenteController {

	private static Logger log = LoggerFactory.getLogger(StudenteController.class);

	@Autowired
	private StudenteService studenteService;


	@PostMapping("/create")
	public Response<?> createStudente(
			@RequestBody Studente studente) {

		log.info("Ricevuta richiesta di creazione/modifica studente.");

		return studenteService.createStudente(studente);

	}
	
	@PostMapping(path = "/delete")
	public Response<?> deleteStudente(
			@RequestBody Studente studente) {

		log.info("Richiesta delete studente.");

		return studenteService.deleteStudente(studente);
	}
	
	@GetMapping(path="/findAll")
	public Response<?> findAllStudenti() {
		
		log.info("Richiesta di find all studenti.");
		
		return studenteService.findAllStudenti();
	}

}
