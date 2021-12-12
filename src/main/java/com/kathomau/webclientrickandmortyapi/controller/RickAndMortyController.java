package com.kathomau.webclientrickandmortyapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kathomau.webclientrickandmortyapi.client.RickAndMortyClient;
import com.kathomau.webclientrickandmortyapi.response.CharacterResponse;
import com.kathomau.webclientrickandmortyapi.response.ListOfEpisodesResponse;
import com.kathomau.webclientrickandmortyapi.response.LocationResponse;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/webclient")
public class RickAndMortyController {

	RickAndMortyClient rickAndMortyClient;
	
	@GetMapping("/character/{id}")
	public Mono<CharacterResponse> getCharacterById(@PathVariable String id) {
		return rickAndMortyClient.findAndCharacterById(id);
	}
	
	@GetMapping("/location/{id}")
	public Mono<LocationResponse> getLocationById(@PathVariable String id) {
		return rickAndMortyClient.findAnLocationById(id);
	}
	
	@GetMapping("/episodes")
	public Flux <ListOfEpisodesResponse> getAllEpisodes() {
		return rickAndMortyClient.getAllEpisodes();
	}
}
