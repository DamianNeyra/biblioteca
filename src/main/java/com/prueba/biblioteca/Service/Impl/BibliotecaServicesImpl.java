package com.prueba.biblioteca.Service.Impl;

import com.prueba.biblioteca.Model.*;
import com.prueba.biblioteca.Repository.LibroRepository;
import com.prueba.biblioteca.Repository.PersonaRepository;
import com.prueba.biblioteca.Repository.PrestamosRepository;
import com.prueba.biblioteca.Service.BibliotecaServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Slf4j
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
    public String crearLibro(LibroDTO libroDTO) {
        Libro libroCreate = Libro.builder().autor(libroDTO.getAutor()).titulo(libroDTO.getTitulo())
                .cantidad(libroDTO.getCantidad()).build();
        libroRepository.save(libroCreate);
        return "Se creó el libro";
    }

    @Override
    public String crearPersona(Persona persona) {
        personaRepository.save(persona);
        return "Se crea la Persona";
    }

    @Override
    public String crearPrestamo(PrestamoDTO prestamoDTO) {
        Persona personaPrestamoCreate = personaRepository.findById(prestamoDTO.getIdPersona()).get();
        List<Libro> listaLibros = new ArrayList<>();
        prestamoDTO.getIdLibros().forEach(data -> {
            Libro libroList = libroRepository.findById(data).get();
            listaLibros.add(libroList);
        });
        Prestamos prestamosCreate = Prestamos.builder().persona(personaPrestamoCreate)
                .fechaPrestamo(LocalDateTime.now()).libros(listaLibros).build();
        prestamosRepository.save(prestamosCreate);
        return "Se crea el prestamo a "+ prestamosCreate.getPersona().getNombre();
    }

    @Override
    public String editarLibro(long id, LibroDTO libro) {
        Libro libroEdit = libroRepository.findById(id).get();
        libroEdit.setTitulo(libro.getTitulo());
        libroEdit.setAutor(libro.getAutor());
        libroEdit.setCantidad(libro.getCantidad());
        libroRepository.save(libroEdit);
        return "Libro " + libroEdit.getTitulo() + " editado";
    }

    @Override
    public String editarPersona(long id ,Persona persona) {
        Persona personaEdit = personaRepository.findById(id).get();
        personaEdit.setNombre(persona.getNombre());
        personaEdit.setApellido(persona.getApellido());
        personaEdit.setIdentificacion(persona.getIdentificacion());
        personaEdit.setDireccion(persona.getDireccion());
        personaRepository.save(personaEdit);
        return "Persona: " + personaEdit.getNombre() + " editada";
    }

    @Override
    public String editarPrestamo(long id, PrestamoDTO prestamoDTO) {
        Persona personaPrestamo = personaRepository.findById(prestamoDTO.getIdPersona()).get();
        List<Libro> listaLibros = null;
        prestamoDTO.getIdLibros().forEach(data -> {
            Libro libroList = libroRepository.findById(data).get();
            listaLibros.add(libroList);
        });
        Prestamos prestamoEdit = prestamosRepository.findById(id).get();
        prestamoEdit.setPersona(personaPrestamo);
        prestamoEdit.setFechaPrestamo(LocalDateTime.now());
        prestamoEdit.setLibros(listaLibros);
        prestamosRepository.save(prestamoEdit);
        return "Pestamo de  " + personaPrestamo.getNombre() + " se editó";
    }

    @Override
    public String eliminarLibro(long id) {
        libroRepository.delete(libroRepository.findById(id).get());
        return "Se eliminó el libro";
    }

    @Override
    public String eliminarPersona(long id) {
        personaRepository.delete(personaRepository.findById(id).get());
        return "Se elimino la persona";
    }

    @Override
    public String eliminarPrestamo(long id) {
        prestamosRepository.delete(prestamosRepository.findById(id).get());
        return "Se elimino el Prestamo";
    }


}
