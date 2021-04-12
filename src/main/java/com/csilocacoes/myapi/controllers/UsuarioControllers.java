package com.csilocacoes.myapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csilocacoes.myapi.domain.Usuario;
import com.csilocacoes.myapi.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioControllers {

	@Autowired
	private UsuarioService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Integer id) {

		Usuario obj = this.service.findById(id);

		return ResponseEntity.ok().body(obj);

	}

	@GetMapping
	public ResponseEntity<List<Usuario>> findAll() {

		List<Usuario> list = service.findAll();
		return ResponseEntity.ok(list);
	}

}
