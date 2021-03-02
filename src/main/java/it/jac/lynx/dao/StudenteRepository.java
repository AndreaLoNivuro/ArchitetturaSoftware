package it.jac.lynx.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.jac.lynx.entity.Studente;

@Repository
public interface StudenteRepository extends CrudRepository<Studente, Integer> {
	
}