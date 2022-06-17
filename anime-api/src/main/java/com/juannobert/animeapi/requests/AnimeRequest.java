package com.juannobert.animeapi.requests;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AnimeRequest {
	@NotEmpty(message = "The anime name cannot be empty")
	@NotNull(message = "The anime name cannot be empty")
	private String name;
}
