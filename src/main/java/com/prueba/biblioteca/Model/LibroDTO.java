package com.prueba.biblioteca.Model;

import org.antlr.v4.runtime.misc.NotNull;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class LibroDTO {
    @NotBlank(message = "El titulo es Obligatorio")
    private String titulo;
    @NotBlank(message = "La cantidad es Obligatoria")
    @Min(1)
    private int cantidad;
    @NotBlank(message = "El autor es Obligatorio")
    private String autor;

    public LibroDTO() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
