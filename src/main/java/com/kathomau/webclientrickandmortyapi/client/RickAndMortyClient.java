package com.kathomau.webclientrickandmortyapi.client;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.kathomau.webclientrickandmortyapi.response.CharacterResponse;
import com.kathomau.webclientrickandmortyapi.response.EpisodeResponse;
import com.kathomau.webclientrickandmortyapi.response.ListOfEpisodesResponse;
import com.kathomau.webclientrickandmortyapi.response.LocationResponse;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class RickAndMortyClient {

	private final WebClient webClient;
	
	public RickAndMortyClient(WebClient.Builder builder) {
		webClient = builder.baseUrl("https://rickandmortyapi.com/api").build();
	}
	
	public Mono<CharacterResponse> findAndCharacterById(String id) {
		log.info("Buscando o personagem com o id [{}]", id);
		return webClient
				.get()
				.uri("/character/" + id)
				.accept(APPLICATION_JSON)
				.retrieve()
				.onStatus(HttpStatus::is4xxClientError,
						error -> Mono.error(new RuntimeException("Verifique os parâmetros informados")))
				.bodyToMono(CharacterResponse.class);			
	}
	
	public Mono<LocationResponse> findAnLocationById(String id) {
		log.info("Buscando a localização com o id [{}]", id);
		return webClient
				.get()
				.uri("/location/" + id)
				.accept(APPLICATION_JSON)
				.retrieve()
				.onStatus(HttpStatus::is4xxClientError,
						error -> Mono.error(new RuntimeException("Verifique os parâmetros informados")))
				.bodyToMono(LocationResponse.class);			
	}
	
	public Mono<EpisodeResponse> findAnEpisodeById(String id) {
		log.info("Buscando a localização com o id [{}]", id);
		return webClient
				.get()
				.uri("/location/" + id)
				.accept(APPLICATION_JSON)
				.retrieve()
				.onStatus(HttpStatus::is4xxClientError,
						error -> Mono.error(new RuntimeException("Verifique os parâmetros informados")))
				.bodyToMono(EpisodeResponse.class);			
	}
	
	public Flux<ListOfEpisodesResponse> getAllEpisodes() {
		log.info("Buscando todos os episodios");
		return webClient
				.get()
				.uri("/episode/")
				.accept(APPLICATION_JSON)
				.retrieve()
				.onStatus(HttpStatus::is4xxClientError,
						error -> Mono.error(new RuntimeException("Verifique os parâmetros informados")))
				.bodyToFlux(ListOfEpisodesResponse.class);			
	}
	
}
