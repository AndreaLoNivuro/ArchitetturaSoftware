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

import it.jac.lynx.dao.StudenteRepository;
import it.jac.lynx.dto.StudenteDTO;
import it.jac.lynx.dto.Response;
import it.jac.lynx.entity.Studente;

@Service
public class StudenteService {

	private static Logger log = LoggerFactory.getLogger(StudenteService.class);

	@Autowired
	private StudenteRepository studenteRepository;

	public Response<StudenteDTO> createStudente(Studente studente) {

		Response<StudenteDTO> response = new Response<StudenteDTO>();

		try {

			response.setResult(StudenteDTO.build(this.studenteRepository.save(studente)));

		}catch(Exception e) {

			response.setError("Studente non creato.");

		}

		return response;

	}


	public Response<String> deleteStudente(Studente studente) {

		Response<String> response = new Response<String>();

		try {
			
			this.studenteRepository.delete(studente);			

			response.setResult("Studente eliminato.");

		}catch(Exception e){

			response.setError("Studente non eliminata.");

		}

		return response;

	}


	public Response<List<StudenteDTO>> findAllStudenti() {

		Response<List<StudenteDTO>> response = new Response<List<StudenteDTO>>();

		List<StudenteDTO> result = new ArrayList<>();

		try {

			Iterator<Studente> iterator = this.studenteRepository.findAll().iterator();

			while(iterator.hasNext()) {

				Studente studente = iterator.next();
				result.add(StudenteDTO.build(studente));

			}

			response.setResult(result);

		} catch (Exception e) {

			response.setError("Nessun elemento trovato.");

		}

		return response;

	}

}
