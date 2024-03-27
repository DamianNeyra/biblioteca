package com.prueba.biblioteca.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PrestamoRs {
    private Persona persona;
    private LocalDateTime fechaPrestamo;
}
