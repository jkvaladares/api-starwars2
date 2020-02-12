package com.ApiStarWars.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ApiStarWars.api.documents.Planeta;
import com.ApiStarWars.api.reposytory.PlanetaRepository;
import com.ApiStarWars.api.response.Response;
import com.ApiStarWars.api.service.PlanetaService;

@RestController
@RequestMapping(path = "/api/planetas")
public class PlanetaController {
	
	@Autowired
	private PlanetaService planetaService;
	

	@GetMapping
	public ResponseEntity<List<Planeta>> listarTodos(){
		return ResponseEntity.ok(this.planetaService.listarPlanetas());
	}
	
	@GetMapping(path = "/id/{id}")
	public ResponseEntity<Optional<Planeta>> listarPorId(@PathVariable(name = "id")String id){
		return ResponseEntity.ok(this.planetaService.listarPorId(id));	
	}
	
	@GetMapping(path = "/nome/{nome}")
	public ResponseEntity<List<Planeta>> listarPlanetaPorNome(@PathVariable(name = "nome")String nome){
		return ResponseEntity.ok(this.planetaService.listarPlanetaPorNome(nome));	
	}
	
	@PostMapping
	public ResponseEntity<Response<Planeta>> cadastrar(@RequestBody Planeta planeta, BindingResult result){
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Planeta>(erros));
		}
		
		return ResponseEntity.ok(new Response<Planeta>(this.planetaService.cadastrarPlaneta(planeta)));
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Integer> remover(@PathVariable(name = "id") String id){
		this.planetaService.removerPlaneta(id);
		return ResponseEntity.ok(1);
	}
	
	
}
