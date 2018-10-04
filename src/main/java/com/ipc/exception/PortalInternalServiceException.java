package com.ipc.exception;

import org.apache.commons.lang3.exception.ContextedRuntimeException;

/**
 * Copyright (c) 2016 IPC Systems, Inc. Created by Ratnesh Srivastava
 */

public class PortalInternalServiceException extends ContextedRuntimeException
{

    private static final long serialVersionUID = 1L;
    private String errorCode = "";

    public PortalInternalServiceException()
    {
        super();
    }

    public PortalInternalServiceException(Throwable cause)
    {
        super(cause);
    }

    public PortalInternalServiceException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public PortalInternalServiceException(String error)
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
