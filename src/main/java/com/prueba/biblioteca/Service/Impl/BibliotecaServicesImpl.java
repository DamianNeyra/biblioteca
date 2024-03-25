package com.prueba.biblioteca.Service.Impl;

import com.prueba.biblioteca.Model.Libro;
import com.prueba.biblioteca.Model.Persona;
import com.prueba.biblioteca.Model.Prestamos;
import com.prueba.biblioteca.Repository.LibroRepository;
import com.prueba.biblioteca.Repository.PersonaRepository;
import com.prueba.biblioteca.Repository.PrestamosRepository;
import com.prueba.biblioteca.Service.BibliotecaServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BibliotecaServicesImpl implements BibliotecaServices {

    private final LibroRepository libroRepository;

    private final PersonaRepository personaRepository;

    private final PrestamosRepository prestamosRepository;

    public BibliotecaServicesImpl(LibroRepository libroRepository, PersonaRepository personaRepository, PrestamosRepository prestamosRepository) {
        this.libroRepository = libroRepository;
        this.personaRepository = personaRepository;
        this.prestamosRepository = prestamosRepository;
    }

    @Override
    public List<Libro> listaLibro() {
        return libroRepository.findAll();
    }

    @Override
    public List<Persona> listaPersonas() {
        return personaRepository.findAll();
    }

    @Override
    public List<Prestamos> listaPrestamos() {
        return prestamosRepository.findAll();
    }

    @Override
    public String crearLibro(Libro libro) {
        libroRepository.save(libro);
        return "Se creó el libro";
    }

    @Override
    public String crearPersona(Persona persona) {
        personaRepository.save(persona);
        return "Se crea la Persona";
    }

    @Override
    public String crearPrestamo(Prestamos prestamos) {
        prestamosRepository.save(prestamos);
        return "Se crea el prestamo a "+prestamos.getPersona().getNombre();
    }

    @Override
    public String editarLibro(long id, Libro libro) {
        Libro libroEdit = libroRepository.findById(id).get();
        libroEdit.setTitulo(libro.getTitulo());
        libroEdit.setAutor(libro.getAutor());
        libroEdit.setCantidad(libro.getCantidad());
        libroRepository.save(libroEdit);
        return "Libro "+ libroEdit.getTitulo() + " editado";
    }

    @Override
    public String editarPersona(long id ,Persona persona) {
        return null;
    }

    @Override
    public String editarPrestamo(long id, Prestamos prestamos) {
        return null;
    }
}
