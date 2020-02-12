package com.ApiStarWars.api.reposytory;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ApiStarWars.api.documents.Planeta;

public interface PlanetaRepository extends MongoRepository<Planeta, String>{	
	
	 @Query("{ 'nome' : ?0 }")
	  List<Planeta> findPlanetaPorNome(String nome);

	
	

}
