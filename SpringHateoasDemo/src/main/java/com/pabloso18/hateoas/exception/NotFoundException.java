package com.pabloso18.hateoas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Jose_Solano
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Object could not be found")
public class NotFoundException extends Exception {

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
