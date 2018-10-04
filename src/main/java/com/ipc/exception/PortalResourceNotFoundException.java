package com.ipc.exception;

import org.apache.commons.lang3.exception.ContextedRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PortalResourceNotFoundException extends ContextedRuntimeException
{

    private static final long serialVersionUID = 1L;
    private String errorCode = "";

    public PortalResourceNotFoundException()
    {
        super();
    }

    public PortalResourceNotFoundException(String error)
    {
        super(error);
    }

    public String getErrorCode()
    {
        return errorCode;
    }

    public void setErrorCode(String errorCode)
    {
        this.errorCode = errorCode;
    }

}
