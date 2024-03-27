package com.prueba.biblioteca.Service;

import com.prueba.biblioteca.Exception.ApiException;
import com.prueba.biblioteca.Model.*;

import java.util.List;

public interface BibliotecaServices {

    List<LibroRs> listaLibro()throws ApiException;
    List<Persona> listaPersonas();
    List<Prestamos> listaPrestamos();

    String crearLibro(LibroRq libroRq)throws ApiException;
    String crearPersona(Persona persona) throws ApiException;
    String crearPrestamo(PrestamoRq prestamoRq)throws ApiException;

    String editarLibro(long id, LibroRq libroRq);
    String editarPersona(long id, Persona persona);
    String editarPrestamo(long id, PrestamoRq prestamoRq);

    String eliminarLibro(long id);
    String eliminarPersona(long id);
    String eliminarPrestamo(long id);

}
