package com.prueba.biblioteca.Model;

import org.antlr.v4.runtime.misc.NotNull;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

public class PrestamoDTO {
    @NotBlank(message = "Id persona es Obligatorio")
    private long idPersona;
    @NotBlank(message = "Minimo un libro")
    private List<Long> idLibros;

    public PrestamoDTO() {
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
