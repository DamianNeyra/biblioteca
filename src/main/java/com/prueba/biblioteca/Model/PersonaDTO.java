package com.prueba.biblioteca.Model;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDTO {
    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido;

    @NotBlank
    private String direccion;

    @NotBlank
    private String identificacion;
}
