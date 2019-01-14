package com.example.springbootexceptionhandling;

import org.springframework.http.HttpStatus;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class BirdNotFoundException extends BaseRuntimeException {

	private static final long serialVersionUID = 52179329021799480L;

	public BirdNotFoundException (String debugMessage) {
		super (debugMessage);
		log.error ("debugMessage: {} ", debugMessage);
	}
	
	public BirdNotFoundException (String debugMessage, Throwable t) {
		super (debugMessage, t);
		log.error ("debugMessage: {}, exception: {}", debugMessage, t);
	}
	
	
	public BirdNotFoundException(Class clazz, String... searchParamsMap) {
		super(clazz, ErrorType.BIRD_NOT_FOUND, (Object[]) searchParamsMap);
		this.setHttpStatus(HttpStatus.NOT_FOUND);
	}
}
