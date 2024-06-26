package com.prueba.biblioteca.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.antlr.v4.runtime.misc.NotNull;

@Builder
public class LibroRq {
    @NotBlank(message = "El titulo es Obligatorio")
    private String titulo;
    @NotNull
    @Min(value = 1,message = "Se registra minimo un libro")
    private int cantidad;
    @NotBlank(message = "El autor es Obligatorio")
    private String autor;

    public LibroRq() {
    }

    public LibroRq(String titulo, int cantidad, String autor) {
        this.titulo = titulo;
        this.cantidad = cantidad;
        this.autor = autor;
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
