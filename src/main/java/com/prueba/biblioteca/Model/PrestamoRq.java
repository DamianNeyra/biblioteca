package com.prueba.biblioteca.Model;


import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class PrestamoRq {
    @NotBlank(message = "Id persona es Obligatorio")
    private long idPersona;
    @NotBlank(message = "Minimo un libro")
    private List<Long> idLibros;

    public PrestamoRq() {
    }


    public long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(long idPersona) {
        this.idPersona = idPersona;
    }

    public List<Long> getIdLibros() {
        return idLibros;
    }

    public void setIdLibros(List<Long> idLibros) {
        this.idLibros = idLibros;
    }
}
