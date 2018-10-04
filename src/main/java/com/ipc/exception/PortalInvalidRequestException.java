package com.ipc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
@SuppressWarnings("serial")
public class PortalInvalidRequestException extends RuntimeException
{

    private final Errors errors;

    public PortalInvalidRequestException(String message, Errors errors)
    {
        super(message);
        this.errors = errors;
    }

    public Errors getErrors()
    {
        return errors;
    }

}
