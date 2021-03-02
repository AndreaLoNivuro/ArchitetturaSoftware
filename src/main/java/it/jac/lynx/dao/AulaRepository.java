package it.jac.lynx.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.jac.lynx.entity.Aula;

@Repository
public interface AulaRepository extends CrudRepository<Aula, Integer> {
	
}