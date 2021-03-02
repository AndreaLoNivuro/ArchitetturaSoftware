package it.jac.lynx.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "studente")
@Data
public class Studente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "cognome")
	private String cognome;
	
	@Column(name = "email")
	private String email;
	
	@ManyToMany(fetch = FetchType.LAZY, targetEntity = Corso.class)
	private List<Corso> corso;
	
	@ManyToMany(fetch = FetchType.LAZY, targetEntity = Aula.class)
	private List<Aula> aula;
	
	@Override
	public String toString() {
		return "Studente [id=" + id + ", name=" + nome + ", cognome=" + cognome + ", email=" + email + "]";
	}
 
}
