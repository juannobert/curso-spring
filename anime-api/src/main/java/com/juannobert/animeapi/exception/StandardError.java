package com.juannobert.animeapi.exception;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class StandardError {
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd 'T' HH:mm:ss'Z'",timezone = "GMT") // Formatando data para o formato UTC(Universal)
	protected Instant instant;
	protected Integer status;
	protected String error;
	protected String mensage;
	protected String path;
}
