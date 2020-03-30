package br.edu.ifal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifal.model.Lembrete;
import br.edu.ifal.model.LembreteRepositorio;

@Controller
@RestController
public class ControladorLembrete {
	@Autowired
	LembreteRepositorio repo;


	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("lembrete", new Lembrete());
		return mv;
	}

	@RequestMapping(value = "/usuario", method = RequestMethod.GET, produces = "application/json")
	@GetMapping
	public Iterable<Lembrete> findAll() {
		return repo.findAll();
	}

	

	@RequestMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView mv = new ModelAndView("cadastrar.html");
		mv.addObject("lembrete", new Lembrete());
		return mv;
	}
}
