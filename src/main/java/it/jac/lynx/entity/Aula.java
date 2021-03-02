package it.jac.lynx.entity;

import java.util.Date;
import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "aula")
@Data
public class Aula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "nome")
	private String nome;

	@Column(name = "max_studenti")
	private int maxStudenti;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Corso.class)
	private Corso corso;
	
	@Override
	public String toString() {
		return "Aula [id=" + id + ", nome=" + nome + ", maxStudenti=" + maxStudenti + "]";
	}

}
