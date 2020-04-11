package br.edu.ifal.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifal.model.Moto;
import br.edu.ifal.model.MotoRepositorio;

@RestController
public class ControladorMoto {

    @Autowired
    MotoRepositorio repo;

    @RequestMapping(value = "/usuarios/motos", method = RequestMethod.GET, produces = "application/json")
    @GetMapping
    public Iterable<Moto> findAll() {
        return repo.findAll();
    }

    @GetMapping("/usuarios/{id}/moto")
    public Optional<Moto> buscarMotoPorId(@PathVariable(value = "id") long id) {

        return repo.findById(id);
    }
}