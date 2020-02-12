package com.ApiStarWars.api.service;

import java.util.List;
import java.util.Optional;

import com.ApiStarWars.api.documents.Planeta;

public interface PlanetaService {
	
	List<Planeta> listarPlanetas();
	
	Optional<Planeta> listarPorId(String id);
	
	List<Planeta> listarPlanetaPorNome(String nome);
	
	Planeta cadastrarPlaneta(Planeta planeta);
	
	void removerPlaneta(String id);

}
