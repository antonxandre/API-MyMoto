package br.edu.ifal.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LembreteRepositorio extends CrudRepository<Lembrete, Integer>{

}