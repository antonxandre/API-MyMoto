package br.edu.ifal.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.Entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifal.model.Lembrete;
import br.edu.ifal.model.LembreteRepositorio;

@RestController
public class ControladorLembrete {
	@Autowired
	LembreteRepositorio repo;

	@RequestMapping("/")
	public String index() {

		return "Hello World";
	}

	@RequestMapping(value = "/usuarios", method = RequestMethod.GET, produces = "application/json")
	@GetMapping
	public Iterable<Lembrete> findAll() {
		return repo.findAll();
	}
	
	@GetMapping("/usuarios/{id}")
	public Lembrete buscarUsuarioId(@PathVariable(value="id") long id) {
		return repo.findById(id);
	}

	@RequestMapping(value = "/usuarios", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Lembrete salvarUsuario(@RequestBody final String json) {
		final ObjectMapper mapper = new ObjectMapper();
		Lembrete lembrete = new Lembrete();

		try {
			lembrete = mapper.readValue(json, Lembrete.class);
			System.out.println("ResultingJSONstring = " + json);
			// System.out.println(json);
		} catch (final JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return repo.save(lembrete);
	}
	


}
