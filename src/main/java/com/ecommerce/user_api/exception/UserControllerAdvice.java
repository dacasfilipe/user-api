package com.ecommerce.user_api.exception;

import com.ecommerce.shopping_client.dto.ErrorDTO;
import com.ecommerce.shopping_client.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice(basePackages = "com.ecommerce.user_api.controller")
public class UserControllerAdvice {
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handleUserNotFound(UserNotFoundException ex) {
        return new ErrorDTO(HttpStatus.NOT_FOUND.value(),
                ex.getMessage(), LocalDateTime.now());
    }
}
