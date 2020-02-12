package com.ApiStarWars.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ApiStarWars.api.documents.Planeta;
import com.ApiStarWars.api.reposytory.PlanetaRepository;
import com.ApiStarWars.api.service.PlanetaService;

@Service
public class PlanetaServiceImpl implements PlanetaService {

	@Autowired
	private PlanetaRepository planetaRepository;

	@Override
	public List<Planeta> listarPlanetas() {
			return planetaRepository.findAll();
	}

	@Override
	public Optional<Planeta> listarPorId(String id) {
		
		return this.planetaRepository.findById(id);
	}

	@Override
	public Planeta cadastrarPlaneta(Planeta planeta) {
		return this.planetaRepository.save(planeta);
	}

	@Override
	public void removerPlaneta(String id) {
		this.planetaRepository.deleteById(id);
		
	}

	public List<Planeta> listarPlanetaPorNome(String nome) {
		return this.planetaRepository.findPlanetaPorNome(nome);
	}
	
	
}
