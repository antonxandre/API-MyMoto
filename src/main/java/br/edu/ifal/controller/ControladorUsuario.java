package br.edu.ifal.controller;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifal.model.Usuario;
import br.edu.ifal.model.UsuarioRepositorio;

@RestController
public class ControladorUsuario {
	@Autowired
	UsuarioRepositorio repo;

	@RequestMapping("/")
	public String index() {

		return "Hello World";
	}

	@RequestMapping(value = "/usuarios", method = RequestMethod.GET, produces = "application/json")
	@GetMapping
	public Iterable<Usuario> findAll() {
		return repo.findAll();
	}

	@GetMapping("/usuarios/{id}")
	public Usuario buscarUsuarioId(@PathVariable(value = "id") long id) {
		return repo.findById(id);
	}

	@RequestMapping(value = "/usuarios", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Usuario salvarUsuario(@RequestBody final String json) {
		final ObjectMapper mapper = new ObjectMapper();
		Usuario usuario = new Usuario();

		try {
			usuario = mapper.readValue(json, Usuario.class);
			System.out.println("ResultingJSONstring = " + json);
			// System.out.println(json);
		} catch (final JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return repo.save(usuario);
	}

}
