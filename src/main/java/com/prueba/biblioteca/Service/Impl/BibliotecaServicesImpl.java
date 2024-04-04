package com.prueba.biblioteca.Service.Impl;

import com.prueba.biblioteca.Exception.ApiException;
import com.prueba.biblioteca.Exception.DataNotFoundException;
import com.prueba.biblioteca.Exception.ErrorDTO;
import com.prueba.biblioteca.Model.*;
import com.prueba.biblioteca.Repository.LibroRepository;
import com.prueba.biblioteca.Repository.PersonaRepository;
import com.prueba.biblioteca.Repository.PrestamosRepository;
import com.prueba.biblioteca.Service.BibliotecaServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public List<LibroRs> listaLibro() {
        return libroRepository.listarLibros();
    }

    @Override
    public List<PersonaDTO> listaPersonas() {
        return personaRepository.listarPersonas();
    }

    @Override
    public List<Prestamos> listaPrestamos() {
        return prestamosRepository.findAll();
    }

    @Override
    public Optional<Libro> listaLibroId(long id) throws ApiException {
        Optional<Libro> libro = libroRepository.findById(id);
        if(libro.isEmpty()){
            throw new DataNotFoundException(ErrorDTO.builder().code("P-404").nombre("NOT FOUND")
                    .message("No existe el libro").build());
        } else {
            return libro;
        }
    }

    @Override
    public String crearLibro(LibroRq libroRq) {
        Libro libroCreate = Libro.builder().autor(libroRq.getAutor()).titulo(libroRq.getTitulo())
                .cantidad(libroRq.getCantidad()).build();
        libroRepository.save(libroCreate);
        String msg = "Se crea el libro "+ libroCreate.getTitulo();
        log.info(msg);
        return msg;
    }

    @Override
    public String crearPersona(PersonaDTO persona) throws ApiException {
        Persona pers = Persona.builder().nombre(persona.getNombre()).apellido(persona.getApellido())
                .direccion(persona.getDireccion()).identificacion(persona.getIdentificacion()).build();
        personaRepository.save(pers);
        String msg = "Se crea la persona "+ persona.getNombre();
        log.info(msg);
        return msg;
    }

    @Override
    public String crearPrestamo(PrestamoRq prestamoRq) throws ApiException {
        Persona personaPrestamoCreate = personaRepository.findById(prestamoRq.getIdPersona()).get();
        List<Libro> listaLibros = new ArrayList<>();
        prestamoRq.getIdLibros().forEach(data -> {
            Libro libroList = libroRepository.findById(data).get();
            listaLibros.add(libroList);
        });
        Prestamos prestamosCreate = Prestamos.builder().persona(personaPrestamoCreate)
                .fechaPrestamo(LocalDateTime.now()).libros(listaLibros).build();
        prestamosRepository.save(prestamosCreate);
        String msg = "Se crea prestamo para "+ prestamosCreate.getPersona().getNombre();
        log.info(msg);
        return msg;
    }

    @Override
    public String editarLibro(long id, LibroRq libro) throws ApiException{
        Libro libroEdit = libroRepository.findById(id).get();
        libroEdit.setTitulo(libro.getTitulo());
        libroEdit.setAutor(libro.getAutor());
        libroEdit.setCantidad(libro.getCantidad());
        libroRepository.save(libroEdit);
        String msg = "Libro " + libroEdit.getTitulo() + " editado";
        log.info(msg);
        return msg;
    }

    @Override
    public String editarPersona(long id , PersonaDTO persona) throws ApiException{
        Persona personaEdit = personaRepository.findById(id).get();
        personaEdit.setNombre(persona.getNombre());
        personaEdit.setApellido(persona.getApellido());
        personaEdit.setIdentificacion(persona.getIdentificacion());
        personaEdit.setDireccion(persona.getDireccion());
        personaRepository.save(personaEdit);
        String msg = "Persona: " + personaEdit.getNombre() + " editada";
        log.info(msg);
        return msg;
    }

    @Override
    public String editarPrestamo(long id, PrestamoRq prestamoRq) throws ApiException{
        Persona personaPrestamo = personaRepository.findById(prestamoRq.getIdPersona()).get();
        List<Libro> listaLibros = null;
        prestamoRq.getIdLibros().forEach(data -> {
            Libro libroList = libroRepository.findById(data).get();
            listaLibros.add(libroList);
        });
        Prestamos prestamoEdit = prestamosRepository.findById(id).get();
        prestamoEdit.setPersona(personaPrestamo);
        prestamoEdit.setFechaPrestamo(LocalDateTime.now());
        prestamoEdit.setLibros(listaLibros);
        prestamosRepository.save(prestamoEdit);

        String msg = "Pestamo de  " + personaPrestamo.getNombre() + " se editó";
        log.info(msg);
        return msg;
    }

    @Override
    public String eliminarLibro(long id) throws ApiException{
        Libro libroEli = libroRepository.findById(id).get();
        String msg = "Se eliminó el libro "+ libroEli.getTitulo();
        log.info(msg);
        libroRepository.delete(libroEli);

        return msg;
    }

    @Override
    public String eliminarPersona(long id) throws ApiException {
        Persona personaEli = personaRepository.findById(id).get();
        String msg = "Se eliminó el persona "+ personaEli.getNombre();
        log.info(msg);
        personaRepository.delete(personaEli);
        return msg;
    }

    @Override
    public String eliminarPrestamo(long id) throws ApiException {
        Prestamos prestamoEli = prestamosRepository.findById(id).get();
        String msg = "Se eliminó el prestamo de la persona "+ prestamoEli.getPersona().getNombre();
        log.info(msg);
        prestamosRepository.delete(prestamoEli);
        return msg;
    }


}
