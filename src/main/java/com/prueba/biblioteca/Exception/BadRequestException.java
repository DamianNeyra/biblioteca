package com.prueba.biblioteca.Exception;

public class BadRequestException extends ApiException {
    private static final long serialVersionUID = 1L;

    public BadRequestException() {
        super();
    }

    public BadRequestException(ErrorDTO errorDto) {
        super(errorDto);
    }
    public BadRequestException(String msg) {
        super(msg);
    }
}

