package com.prueba.biblioteca.Exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDTO {
    private String code;
    private String nombre;
    private String message;
}
