package br.edu.ifal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifal.model.ReceberFeedback;
import br.edu.ifal.model.ReceberFeedbackRepositorio;

@RestController
public class ControladorReceberFeedback {
	
	@Autowired
	ReceberFeedbackRepositorio repoFeedback;
	
	@GetMapping
	public void receberFeedback() {
		repoFeedback.findAll();
	}
	@RequestMapping(value = "/feedback", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@PostMapping("/feedback")
	public void enviarFeedback(@RequestBody ReceberFeedback feedback) {
		repoFeedback.save(feedback);
	}
}
