package com.prueba.biblioteca.Controller;

import com.prueba.biblioteca.Exception.ApiException;
import com.prueba.biblioteca.Exception.BadRequestException;
import com.prueba.biblioteca.Exception.DataNotFoundException;
import com.prueba.biblioteca.Model.*;
import com.prueba.biblioteca.Service.BibliotecaServices;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class BibliotecaController {

    private final BibliotecaServices bibliotecaServices;

    public BibliotecaController(BibliotecaServices bibliotecaServices) {
        this.bibliotecaServices = bibliotecaServices;
    }

    @GetMapping("/")
    public String probando(){
        return "Bienvenidos a Biblioteca";
    }

    @GetMapping("/listar-libros")
    public ResponseEntity<?> listarLibros(){
        try {
            return ResponseEntity.ok(bibliotecaServices.listaLibro());
        } catch (Exception ex) {
            throw new DataNotFoundException(getClass(), Libro.class);
        }

    }
    @GetMapping("/listar-personas")
    public ResponseEntity<?> listarPersonas(){
        try {
            return ResponseEntity.ok(bibliotecaServices.listaPersonas());
        } catch (Exception ex) {
            throw new DataNotFoundException(getClass(), Persona.class);
        }

    }
    @GetMapping("/listar-prestamos")
    public ResponseEntity<?> listarPrestamos(){
        try {
            return ResponseEntity.ok(bibliotecaServices.listaPrestamos());
        }catch (Exception ex) {
            throw new DataNotFoundException(getClass(), Prestamos.class);
        }

    }

    @PostMapping("/crear-libro")
    public ResponseEntity<?> crearLibro(@Valid @RequestBody LibroRq libroRq) throws ApiException {
        try{
            return ResponseEntity.ok(bibliotecaServices.crearLibro(libroRq));
        } catch (ApiException bex){
        throw new BadRequestException(bex.getErrorDto());
        }
    }

    @PostMapping("/crear-persona")
    public ResponseEntity<?> crearPersona(@Valid @RequestBody Persona persona) throws ApiException {
        try{
            return ResponseEntity.ok(bibliotecaServices.crearPersona(persona));
        } catch (ApiException bex){
            throw new BadRequestException(bex.getErrorDto());
        }
    }
    @PostMapping("/crear-prestamo")
    public ResponseEntity<?> crearPrestamo(@Valid @RequestBody PrestamoRq prestamoRq) throws ApiException {
        try{
            return ResponseEntity.ok(bibliotecaServices.crearPrestamo(prestamoRq));
        }catch (Exception bex){
            throw new BadRequestException(bex.getMessage());
        }
    }

    @PutMapping("/editar-libro/{id}")
    public ResponseEntity<?> editarLibro(
            @PathVariable("id") long id,
            @Valid @RequestBody LibroRq libroRq) throws ApiException{

        try{
            return ResponseEntity.ok(bibliotecaServices.editarLibro(id, libroRq));
        }catch (Exception bex){
            throw new BadRequestException(bex.getMessage());
        }
    }

    @PutMapping("/editar-persona/{id}")
    public ResponseEntity<?> editarPersona(
            @PathVariable("id") long id,
            @Valid @RequestBody Persona persona) throws ApiException{
        try{
            return ResponseEntity.ok(bibliotecaServices.editarPersona(id,persona));
        }catch (Exception bex){
            throw new BadRequestException(bex.getMessage());
        }
    }
    @PutMapping("/editar-prestamo/{id}")
    public ResponseEntity<?> editarPrestamo(
            @PathVariable("id") long id,
            @Valid @RequestBody PrestamoRq prestamoRq) throws ApiException{
        try{
            return ResponseEntity.ok(bibliotecaServices.editarPrestamo(id, prestamoRq));
        }catch (Exception bex){
            throw new BadRequestException(bex.getMessage());
        }
    }

    @DeleteMapping("/eliminar-libro/{id}")
    public String eliminarLibro(
            @PathVariable("id") long id){
        try{
            return bibliotecaServices.eliminarLibro(id);
        } catch (Exception ex) {
            throw new DataNotFoundException(getClass(), Libro.class);
        }
    }

    @DeleteMapping("/eliminar-persona/{id}")
    public String eliminarPersona(
            @PathVariable("id") long id){
        try{
            return bibliotecaServices.eliminarPersona(id);
        } catch (Exception ex) {
            throw new DataNotFoundException(getClass(), Persona.class);
        }
    }
    @DeleteMapping("/eliminar-prestamo/{id}")
    public String eliminarPrestamo(
            @PathVariable("id") long id){

        try {
            return bibliotecaServices.eliminarPrestamo(id);
        } catch (Exception ex) {
            throw new DataNotFoundException(getClass(), Prestamos.class);
        }
    }


}
