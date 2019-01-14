package com.example.springbootexceptionhandling;

/**
 * Defines the error types in the application.
 * When an application throws a custom exception, it sets one of the suitable error types
 * from here. These error type (or error code) acts as a key in message properties to fetch the detailed messages.
 * These error code and messages will be used in preparing the ApiError that will be sent back.
 * 
 * @author SinNe002
 *
 */
public enum ErrorType {
	APPLICATION,
	BIRD_NOT_FOUND
}
