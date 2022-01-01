package com.facchinil.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.facchinil.es.PersonaES;

public interface PersonaRepositoryES extends ElasticsearchRepository<PersonaES, String> {
	
	List<PersonaES> findAllByNome(String nome);
}