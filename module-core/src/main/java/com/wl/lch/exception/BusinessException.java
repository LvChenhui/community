package com.wl.lch.exception;

public class BusinessException extends RuntimeException{
    private static final long serialVersionUID = 4242190966564868911L;

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }
}
