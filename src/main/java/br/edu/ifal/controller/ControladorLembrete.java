package br.edu.ifal.controller;

import java.util.List;
import java.util.Map;

import javax.persistence.Entity;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@RequestMapping(value = "/usuarios", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Lembrete salvarUsuario(@RequestBody Map<String, String> json) {
		Lembrete lembrete = new Lembrete();

		for (Map.Entry<String, String> entry : json.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue().toString());
			lembrete.setNome(entry.getValue());
		}
		System.out.println(json);

		return repo.save(lembrete);
	}

}
