package com.kathomau.webclientrickandmortyapi.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CharacterResponse {

	private String id;
	private String name;
	private String status;
	private String species;
	private String image;
	List<String> episode;
}
