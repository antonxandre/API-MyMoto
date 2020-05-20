package br.edu.ifal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.ifal.model.ReceberFeedback;
import br.edu.ifal.model.ReceberFeedbackRepositorio;

public class ControladorReceberFeedback {
	
	@Autowired
	ReceberFeedbackRepositorio repoFeedback;
	
	@RequestMapping(value= "/feedback", method = RequestMethod.GET)
	@GetMapping
	public void receberFeedback() {
		repoFeedback.findAll();
	}
	
	@RequestMapping(value = "/feedback", method = RequestMethod.POST)
	@PostMapping("/feedback")
	public void enviarFeedback() {
		ReceberFeedback feedback = new ReceberFeedback();
		 
//		feedback.setId(id);
//		feedback.setMensagemDoUsuario(mensagemDoUsuario);
//		feedback.setDataDeEnvio(dataDeEnvio);
		repoFeedback.save(feedback);
	}
}
