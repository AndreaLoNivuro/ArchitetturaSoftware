package it.jac.lynx.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.jac.lynx.dao.AulaRepository;
import it.jac.lynx.dto.AulaDTO;
import it.jac.lynx.dto.Response;
import it.jac.lynx.entity.Aula;

@Service
public class AulaService {

	private static Logger log = LoggerFactory.getLogger(AulaService.class);

	@Autowired
	private AulaRepository aulaRepository;

	public Response<AulaDTO> createAula(Aula aula) {

		Response<AulaDTO> response = new Response<AulaDTO>();

		try {

			response.setResult(AulaDTO.build(this.aulaRepository.save(aula)));

		}catch(Exception e) {

			response.setError("Aula non creata.");

		}

		return response;

	}


	public Response<String> deleteAula(Aula aula) {

		Response<String> response = new Response<String>();

		try {
			
			this.aulaRepository.delete(aula);			

			response.setResult("Aula eliminata.");

		}catch(Exception e){

			response.setError("Aula non eliminata.");

		}

		return response;

	}


	public Response<List<AulaDTO>> findAllAule() {

		Response<List<AulaDTO>> response = new Response<List<AulaDTO>>();

		List<AulaDTO> result = new ArrayList<>();

		try {

			Iterator<Aula> iterator = this.aulaRepository.findAll().iterator();

			while(iterator.hasNext()) {

				Aula aula = iterator.next();
				result.add(AulaDTO.build(aula));

			}

			response.setResult(result);

		} catch (Exception e) {

			response.setError("Nessun elemento trovato.");

		}

		return response;

	}

}
