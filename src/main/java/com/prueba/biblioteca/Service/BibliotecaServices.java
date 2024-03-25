package com.prueba.biblioteca.Service;

import com.prueba.biblioteca.Model.Libro;
import com.prueba.biblioteca.Model.Persona;
import com.prueba.biblioteca.Model.Prestamos;

import java.util.List;

public interface BibliotecaServices {

    List<Libro> listaLibro();
    List<Persona> listaPersonas();
    List<Prestamos> listaPrestamos();
    String crearLibro(Libro libro);
    String crearPersona(Persona persona);
    String crearPrestamo(Prestamos prestamos);

    String editarLibro(long id, Libro libro);
    String editarPersona(long id, Persona persona);
    String editarPrestamo(long id, Prestamos prestamos);

}
