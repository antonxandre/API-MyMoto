package br.edu.ifal.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value = "/feedback", method = RequestMethod.GET, produces = "application/json")
	@GetMapping
	public Iterable<ReceberFeedback> findAll() {
		return repoFeedback.findAll();
	}
	
	@GetMapping("/feedback/{id}")
	public Optional<ReceberFeedback> buscarFeedbackId(@PathVariable(value = "id") long id) {
		return repoFeedback.findById(id);
	}
	
//    @RequestMapping(value = "/feedback", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
//    	public ResponseEntity<ReceberFeedback> enviarFeedback(@RequestBody ReceberFeedback feedback) {
//    	repoFeedback.save(feedback);
//		return new ResponseEntity<ReceberFeedback>(feedback, HttpStatus.CREATED);
//    }
    
}
