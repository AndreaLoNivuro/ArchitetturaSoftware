package it.jac.lynx.dto;
import java.util.List;
import org.springframework.beans.BeanUtils;

import it.jac.lynx.entity.Aula;
import it.jac.lynx.entity.Corso;
import it.jac.lynx.entity.Studente;
import lombok.Data;

@Data
public class StudenteDTO {

	private int id;

	private String nome;

	private String cognome;
	
	private String email;
	
	private List<Corso> corso;
	
	private List<Aula> aula;

	public static StudenteDTO build(Studente studente) {

		StudenteDTO result = new StudenteDTO();
		BeanUtils.copyProperties(studente, result);

		return result;
	}

}
