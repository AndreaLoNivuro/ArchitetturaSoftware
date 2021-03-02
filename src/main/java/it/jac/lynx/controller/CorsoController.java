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
import it.jac.lynx.entity.Corso;
import it.jac.lynx.service.CorsoService;


@RestController
@RequestMapping("/corso")

public class CorsoController {

	private static Logger log = LoggerFactory.getLogger(CorsoController.class);

	@Autowired
	private CorsoService corsoService;


	@PostMapping("/create")
	public Response<?> createCorso(
			@RequestBody Corso corso) {

		log.info("Ricevuta richiesta di creazione/modifica corso.");

		return corsoService.createCorso(corso);

	}
	
	@PostMapping(path = "/delete")
	public Response<?> deleteStudenteCorso(
			@RequestBody Corso corso) {

		log.info("Richiesta delete corso.");

		return corsoService.deleteCorso(corso);
	}
	
	@GetMapping(path="/findAll")
	public Response<?> findAllCorsi() {
		
		log.info("Richiesta di find all corsi.");
		
		return corsoService.findAllCorsi();
	}

}
