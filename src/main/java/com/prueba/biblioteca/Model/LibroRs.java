package com.prueba.biblioteca.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LibroRs {
    private String titulo;
    private String autor;
    private int cantidad;
}
