package com.prueba.biblioteca.Service;

import com.prueba.biblioteca.Exception.ApiException;
import com.prueba.biblioteca.Model.*;

import java.util.List;
import java.util.Optional;

public interface BibliotecaServices {

    List<LibroRs> listaLibro() throws ApiException;
    List<PersonaDTO> listaPersonas() throws ApiException;
    List<Prestamos> listaPrestamos() throws ApiException;

    Optional<Libro> listaLibroId(long id) throws ApiException;
    String crearLibro(LibroRq libroRq)throws ApiException;
    String crearPersona(PersonaDTO persona) throws ApiException;
    String crearPrestamo(PrestamoRq prestamoRq)throws ApiException;

    String editarLibro(long id, LibroRq libroRq)throws ApiException;
    String editarPersona(long id, PersonaDTO persona)throws ApiException;
    String editarPrestamo(long id, PrestamoRq prestamoRq)throws ApiException;

    String eliminarLibro(long id)throws ApiException;
    String eliminarPersona(long id)throws ApiException;
    String eliminarPrestamo(long id)throws ApiException;

}
