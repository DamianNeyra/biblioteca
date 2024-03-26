package com.prueba.biblioteca.Service;

import com.prueba.biblioteca.Model.*;

import java.util.List;

public interface BibliotecaServices {

    List<Libro> listaLibro();
    List<Persona> listaPersonas();
    List<Prestamos> listaPrestamos();

    String crearLibro(LibroDTO libroDTO);
    String crearPersona(Persona persona);
    String crearPrestamo(PrestamoDTO prestamoDTO);

    String editarLibro(long id, LibroDTO libroDTO);
    String editarPersona(long id, Persona persona);
    String editarPrestamo(long id, PrestamoDTO prestamoDTO);

    String eliminarLibro(long id);
    String eliminarPersona(long id);
    String eliminarPrestamo(long id);

}
