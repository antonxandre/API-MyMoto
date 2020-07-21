package br.edu.ifal.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifal.model.Moto;
import br.edu.ifal.model.MotoModelo;
import br.edu.ifal.model.MotoModeloRepositorio;
import br.edu.ifal.model.MotoRepositorio;
import br.edu.ifal.model.Usuario;
import br.edu.ifal.model.UsuarioRepositorio;

@RestController
public class ControladorMoto {

    @Autowired
    MotoRepositorio repo;
    @Autowired
    MotoModeloRepositorio repositorioModelosMotos;
    @Autowired
    UsuarioRepositorio repositorioUsuario;

    @RequestMapping(value = "/motos", method = RequestMethod.GET)
    @GetMapping
    public Iterable<MotoModelo> buscarTodasMotos() {
        return repositorioModelosMotos.findAll();
    }

    @RequestMapping(value = "/usuarios/motos", method = RequestMethod.GET, produces = "application/json")
    @GetMapping
    public Iterable<Moto> buscarMotosDosUsuarios() {
        return repo.findAll();
    }

    @GetMapping("/usuarios/{id}/moto")
    public Moto buscarMotoPorId(@PathVariable(value = "id") long id) {
        // passa o id do usuário como parametro
        // e não o id da moto;
        Optional<Usuario> usuario;
        usuario = repositorioUsuario.findById(id);
        return usuario.get().getMoto();
    }

    @PutMapping("/usuarios/{id}/moto")
    public ResponseEntity<Moto> renovarAtributosDaMoto(@PathVariable(value = "id") long id, @Valid @RequestBody Moto atributoDaMotoRenovado) {
        Optional<Usuario> usuario;
        usuario = repositorioUsuario.findById(id);
        Moto atributosAntigosDaMoto = usuario.get().getMoto();
        if (atributosAntigosDaMoto != null) {
           // oldMoto.setMedia_diaria_km(atributoDaMotoRenovado.getMedia_diaria_km());
           atributosAntigosDaMoto.setContador_dias(atributoDaMotoRenovado.getContador_dias());
           atributosAntigosDaMoto.setKm_atual_acelerador(atributoDaMotoRenovado.getKm_atual_acelerador());
           atributosAntigosDaMoto.setKm_atual_embreagem(atributoDaMotoRenovado.getKm_atual_embreagem());
           atributosAntigosDaMoto.setKm_atual_freio(atributoDaMotoRenovado.getKm_atual_freio());
           atributosAntigosDaMoto.setKm_atual_pneus(atributoDaMotoRenovado.getKm_atual_pneus());
           atributosAntigosDaMoto.setKm_atual_suspensao(atributoDaMotoRenovado.getKm_atual_suspensao());
           atributosAntigosDaMoto.setKm_atual_troca_oleo(atributoDaMotoRenovado.getKm_atual_troca_oleo());
           atributosAntigosDaMoto.setKm_atual_vela(atributoDaMotoRenovado.getKm_atual_vela());
            repo.save(atributosAntigosDaMoto);
            return new ResponseEntity<Moto>(atributosAntigosDaMoto, HttpStatus.OK.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}