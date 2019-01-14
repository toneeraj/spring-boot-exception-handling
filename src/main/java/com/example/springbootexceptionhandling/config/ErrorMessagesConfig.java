package com.example.springbootexceptionhandling.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import lombok.extern.slf4j.Slf4j;

/**
 * Loads the exception messages and validation messages properties
 *
 */
@Slf4j
@Configuration
public class ErrorMessagesConfig {

    @Bean("exceptionErrorMessageSource")
    public MessageSource exceptionErrorMessageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:exception_error_messages");
        return messageSource;
    }
    
    @Bean("validationErrorMessageSource")
    public MessageSource validatoinErrorMessageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:validation_error_messages");
        return messageSource;
    }
}
