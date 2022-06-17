package com.juannobert.animeapi.exception;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class ValidationExceptionDetails extends StandardError{
	private String filds;
	private String fildsMessage;

}
