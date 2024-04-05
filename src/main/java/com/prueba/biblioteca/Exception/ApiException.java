package com.prueba.biblioteca.Exception;

import com.prueba.biblioteca.Exception.ErrorDTO;

public class ApiException extends Exception {
    private static final long serialVersionUID = 1L;
    private ErrorDTO errorDto;

    public ApiException() {
        super();
    }

    public ApiException(ErrorDTO errorDto) {
        super(errorDto.getMessage());
        this.errorDto = errorDto;
    }

    public ApiException(String msg) {
        super(msg);
    }

    public ApiException(String msg, Exception ex) {
        super(msg, ex);
    }

    /**
     * @return the errorDto
     */
    public ErrorDTO getErrorDto() {
        return errorDto;
    }

    /**
     * @param errorDto the errorDto to set
     */
    public void setErrorDto(ErrorDTO errorDto) {
        this.errorDto = errorDto;
    }
}
