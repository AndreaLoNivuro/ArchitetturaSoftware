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

import it.jac.lynx.dao.CorsoRepository;
import it.jac.lynx.dto.CorsoDTO;
import it.jac.lynx.dto.Response;
import it.jac.lynx.entity.Corso;

@Service
public class CorsoService {

	private static Logger log = LoggerFactory.getLogger(CorsoService.class);

	@Autowired
	private CorsoRepository corsoRepository;

	public Response<CorsoDTO> createCorso(Corso corso) {

		Response<CorsoDTO> response = new Response<CorsoDTO>();

		try {

			response.setResult(CorsoDTO.build(this.corsoRepository.save(corso)));

		}catch(Exception e) {

			response.setError("Corso non creato.");

		}

		return response;

	}


	public Response<String> deleteCorso(Corso corso) {

		Response<String> response = new Response<String>();

		try {
			
			this.corsoRepository.delete(corso);			

			response.setResult("Corso eliminato.");

		}catch(Exception e){

			response.setError("Corso non eliminato.");

		}

		return response;

	}


	public Response<List<CorsoDTO>> findAllCorsi() {

		Response<List<CorsoDTO>> response = new Response<List<CorsoDTO>>();

		List<CorsoDTO> result = new ArrayList<>();

		try {

			Iterator<Corso> iterator = this.corsoRepository.findAll().iterator();

			while(iterator.hasNext()) {

				Corso corso = iterator.next();
				result.add(CorsoDTO.build(corso));

			}

			response.setResult(result);

		} catch (Exception e) {

			response.setError("Nessun elemento trovato.");

		}

		return response;

	}

}
