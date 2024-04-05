package com.prueba.biblioteca.Exception;

public class DataNotFoundException extends ApiException {

    private static final long serialVersionUID = 1L;

    public DataNotFoundException() {
        super();
    }

    public DataNotFoundException(ErrorDTO errorDto) {
        super(errorDto);
    }

}
