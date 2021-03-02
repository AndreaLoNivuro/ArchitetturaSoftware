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
import it.jac.lynx.entity.Aula;
import it.jac.lynx.service.AulaService;


@RestController
@RequestMapping("/aula")

public class AulaController {

	private static Logger log = LoggerFactory.getLogger(AulaController.class);

	@Autowired
	private AulaService aulaService;


	@PostMapping("/create")
	public Response<?> createAula(
			@RequestBody Aula aula) {

		log.info("Ricevuta richiesta di creazione/modifica aula.");

		return aulaService.createAula(aula);

	}
	
	@PostMapping(path = "/delete")
	public Response<?> deleteAula(
			@RequestBody Aula aula) {

		log.info("Richiesta delete aula.");

		return aulaService.deleteAula(aula);
	}
	
	@GetMapping(path="/findAll")
	public Response<?> findAllAule() {
		
		log.info("Richiesta di find all aule.");
		
		return aulaService.findAllAule();
	}

}
