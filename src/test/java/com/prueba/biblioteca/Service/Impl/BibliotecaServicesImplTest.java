package com.prueba.biblioteca.Service.Impl;

import com.prueba.biblioteca.Controller.BibliotecaController;
import com.prueba.biblioteca.Exception.ApiException;
import com.prueba.biblioteca.Model.Libro;
import com.prueba.biblioteca.Model.LibroRq;
import com.prueba.biblioteca.Repository.LibroRepository;
import com.prueba.biblioteca.Service.BibliotecaServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static java.nio.file.Paths.get;

@WebMvcTest(BibliotecaController.class)
class BibliotecaServicesImplTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BibliotecaServices bibliotecaServices;
    @Test
    void crearLibro() throws ApiException {
        LibroRq libroRq = LibroRq.builder().autor("Gabo").titulo("Cien Años").cantidad(10).build();
        String msg = "Se crea el libro "+ libroRq.getTitulo();
        Mockito.when(bibliotecaServices.crearLibro(libroRq)).thenReturn(msg);
        Assertions.assertEquals(msg,bibliotecaServices.crearLibro(libroRq));
    }
    @Test
    void eliminarLibro() throws ApiException {
        String msg = "Se eliminó el libro Manuel";
        Mockito.when(bibliotecaServices.eliminarLibro(21)).thenReturn(msg);
        Assertions.assertEquals(msg,bibliotecaServices.eliminarLibro(21));
    }
}