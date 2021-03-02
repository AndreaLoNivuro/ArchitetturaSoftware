package it.jac.lynx.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.jac.lynx.entity.Corso;

@Repository
public interface CorsoRepository extends CrudRepository<Corso, Integer> {
	
}