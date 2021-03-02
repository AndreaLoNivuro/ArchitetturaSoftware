package it.jac.lynx.dto;

import java.util.Date;
import java.util.HashMap;

import javax.persistence.Column;

import org.springframework.beans.BeanUtils;

import it.jac.lynx.entity.Aula;
import it.jac.lynx.entity.Corso;
import lombok.Data;

@Data
public class AulaDTO {

	private int id;

	private String nome;

	private int maxStudenti;

	private Corso corso;

	public static AulaDTO build(Aula aula) {

		AulaDTO result = new AulaDTO();
		BeanUtils.copyProperties(aula, result);

		return result;
	}

}
