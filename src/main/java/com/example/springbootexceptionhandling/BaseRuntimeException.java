package com.example.springbootexceptionhandling;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;

import lombok.Data;
@Data
public abstract class BaseRuntimeException extends RuntimeException {

	private Object[] args = null;
    private HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    private ErrorType errorType = ErrorType.APPLICATION;
    private Class clazz = null;
    private String errorMessage = null;
  
    
    public BaseRuntimeException() {
        super();
    }
    
    public BaseRuntimeException(String message) {
        super(message);
    }
    
    public BaseRuntimeException(String message, Throwable t) {
        super(message, t);
    }
    
    public BaseRuntimeException(Class clazz, ErrorType errorType, Object... args) {
        super();
        this.clazz = clazz;
        this.errorType = errorType;
        this.args = args;
        
    }
    
    public BaseRuntimeException(Class clazz, Throwable t, ErrorType errorType, Object... args) {
    	super(t);
    	 this.errorType = errorType;
    	this.args = args;
       
    }
    
    public BaseRuntimeException(Class clazz, Throwable t, HttpStatus httpStatus, ErrorType errorType, Object... args) {
    	super(t);
        this.httpStatus = httpStatus;
        this.errorType = errorType;
        this.args = args;
    }
}
