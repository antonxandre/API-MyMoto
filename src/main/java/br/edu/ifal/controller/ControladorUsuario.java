package br.edu.ifal.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import br.edu.ifal.error.ResourceNotFoundException;
import br.edu.ifal.model.Usuario;
import br.edu.ifal.model.UsuarioRepositorio;

@RestController
public class ControladorUsuario {
	@Autowired
	UsuarioRepositorio repo;

	@RequestMapping("/")
	public String index() {

		return "Hello World!";
	}

	@RequestMapping(value = "/usuarios", method = RequestMethod.GET, produces = "application/json")
	@GetMapping
	public Iterable<Usuario> findAll() {
		return repo.findAll();
	}

	@GetMapping("/usuarios/{id}")
	public Optional<Usuario> buscarUsuarioId(@PathVariable(value = "id") long id) {
		verificarSeUsuarioExiste(id);
		return repo.findById(id);
	}
	@GetMapping("/usuarios/social/{uid}")
	public ResponseEntity<Usuario> buscarUsuarioSocial(@PathVariable(value = "uid") String uid) {
		Iterable<Usuario> usuarios = repo.findAll();
		
		
		for (Usuario usuario : usuarios) {
			if(usuario.getTokenUid() != null) {
			if(usuario.getTokenUid().equals(uid)) {
				System.out.println(usuario);
				return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
			}
		}
				
		}
		return new ResponseEntity<Usuario>(new Usuario(), HttpStatus.NOT_FOUND);
		
		
		

		 
		
	}

	@RequestMapping(value = "/usuarios", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Usuario> salvarUsuario(@RequestBody @Valid Usuario usuario) {
		repo.save(usuario);
		usuario.getMoto().setId_usuario(usuario.getId());
		return new ResponseEntity<Usuario>(usuario, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/usuarios/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Usuario> Put(@PathVariable(value = "id") long id,  @RequestBody Usuario newUsuario) {
		verificarSeUsuarioExiste(id);

		Optional<Usuario> oldUsuario = repo.findById(id);
		if (oldUsuario.isPresent()) {
			Usuario usuario = oldUsuario.get();
			usuario.setNome(newUsuario.getNome());
			usuario.setLogin(newUsuario.getLogin());
			usuario.setEmail(newUsuario.getEmail());
			usuario.setMoto(newUsuario.getMoto());
			usuario.setTokenUid(newUsuario.getTokenUid());
			repo.save(usuario);
			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK.CREATED);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	private void verificarSeUsuarioExiste(long id) {
		Optional<Usuario> usuario = repo.findById(id);
		if (!usuario.isPresent()) {
			throw new ResourceNotFoundException("Usuário não encontrado com ID: " + id);
		}
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	@RequestMapping(value = "/autenticar", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Usuario> autenticar(@RequestBody String json) {
		final ObjectMapper mapper = new ObjectMapper();
		Iterable<Usuario> usuarios = repo.findAll();
		try {
			final Usuario usuarioAuth = mapper.readValue(json, Usuario.class);
			for (Usuario usuario : usuarios) {
				if (usuario.getEmail().equals(usuarioAuth.getEmail())
						&& usuario.getSenha().equals(usuarioAuth.getSenha())) {
					return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
				}
			}
		} catch (final JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Usuario>(new Usuario(), HttpStatus.NOT_FOUND);
	}

}
