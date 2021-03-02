package it.jac.lynx.dto;

import java.util.Date;
import java.util.HashMap;

import javax.persistence.Column;

import org.springframework.beans.BeanUtils;

import it.jac.lynx.entity.Aula;
import it.jac.lynx.entity.Corso;
import lombok.Data;

@Data
public class CorsoDTO {

	private int id;

	private String nome;

	public static CorsoDTO build(Corso corso) {

		CorsoDTO result = new CorsoDTO();
		BeanUtils.copyProperties(corso, result);

		return result;
	}

}
