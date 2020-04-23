package br.edu.ifal.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotoModeloRepositorio extends CrudRepository<MotoModelo, Long> {

}