package com.prueba.biblioteca.Controller;

import com.prueba.biblioteca.Exception.ApiException;
import com.prueba.biblioteca.Exception.BadRequestException;
import com.prueba.biblioteca.Exception.DataNotFoundException;
import com.prueba.biblioteca.Exception.InternalServerErrorException;
import com.prueba.biblioteca.Model.*;
import com.prueba.biblioteca.Service.BibliotecaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class BibliotecaController {
    @Autowired
    private BibliotecaServices bibliotecaServices;

    @GetMapping("/")
    public String probando(){
        return "Bienvenidos a Biblioteca";
    }

    @GetMapping("/libros")
    public ResponseEntity<?> listarLibros() throws ApiException{
        try {
            return ResponseEntity.ok(bibliotecaServices.listaLibro());
        } catch (BadRequestException e) {
            throw new BadRequestException(e.getErrorDto());
        } catch (DataNotFoundException e) {
            throw new DataNotFoundException(e.getErrorDto());
        } catch (ApiException e) {
            throw new InternalServerErrorException(e.getErrorDto());
        }

    }
    @GetMapping("/personas")
    public ResponseEntity<?> listarPersonas() throws ApiException {
        try {
            return ResponseEntity.ok(bibliotecaServices.listaPersonas());
        } catch (BadRequestException e) {
            throw new BadRequestException(e.getErrorDto());
        } catch (DataNotFoundException e) {
            throw new DataNotFoundException(e.getErrorDto());
        } catch (ApiException e) {
            throw new InternalServerErrorException(e.getErrorDto());
        }

    }
    @GetMapping("/prestamos")
    public ResponseEntity<?> listarPrestamos() throws ApiException{
        try {
            return ResponseEntity.ok(bibliotecaServices.listaPrestamos());
        } catch (BadRequestException e) {
            throw new BadRequestException(e.getErrorDto());
        } catch (DataNotFoundException e) {
            throw new DataNotFoundException(e.getErrorDto());
        } catch (ApiException e) {
            throw new InternalServerErrorException(e.getErrorDto());
        }
    }

    @GetMapping("/libros/{id}")
    public ResponseEntity<?> listarLibrosId(@PathVariable("id") long id) throws ApiException{
        try {
            return ResponseEntity.ok(bibliotecaServices.listaLibroId(id));
        } catch (BadRequestException e) {
            throw new BadRequestException(e.getErrorDto());
        } catch (DataNotFoundException e) {
            throw new DataNotFoundException(e.getErrorDto());
        } catch (ApiException e) {
            throw new InternalServerErrorException(e.getErrorDto());
        }

    }

    @PostMapping("/libro")
    public ResponseEntity<?> crearLibro(@Valid @RequestBody LibroRq libroRq) throws ApiException {
        try{
            return ResponseEntity.ok(bibliotecaServices.crearLibro(libroRq));
        } catch (BadRequestException e) {
            throw new BadRequestException(e.getErrorDto());
        } catch (DataNotFoundException e) {
            throw new DataNotFoundException(e.getErrorDto());
        } catch (ApiException e) {
            throw new InternalServerErrorException(e.getErrorDto());
        }
    }

    @PostMapping("/persona")
    public ResponseEntity<?> crearPersona(@Valid @RequestBody PersonaDTO persona) throws ApiException {
        try{
            return ResponseEntity.ok(bibliotecaServices.crearPersona(persona));
        } catch (BadRequestException e) {
            throw new BadRequestException(e.getErrorDto());
        } catch (DataNotFoundException e) {
            throw new DataNotFoundException(e.getErrorDto());
        } catch (ApiException e) {
            throw new InternalServerErrorException(e.getErrorDto());
        }
    }
    @PostMapping("/prestamo")
    public ResponseEntity<?> crearPrestamo(@Valid @RequestBody PrestamoRq prestamoRq) throws ApiException {
        try{
            return ResponseEntity.ok(bibliotecaServices.crearPrestamo(prestamoRq));
        } catch (BadRequestException e) {
            throw new BadRequestException(e.getErrorDto());
        } catch (DataNotFoundException e) {
            throw new DataNotFoundException(e.getErrorDto());
        } catch (ApiException e) {
            throw new InternalServerErrorException(e.getErrorDto());
        }
    }

    @PutMapping("/libro/{id}")
    public ResponseEntity<?> editarLibro(
            @PathVariable("id") long id,
            @Valid @RequestBody LibroRq libroRq) throws ApiException{

        try{
            return ResponseEntity.ok(bibliotecaServices.editarLibro(id, libroRq));
        } catch (BadRequestException e) {
            throw new BadRequestException(e.getErrorDto());
        } catch (DataNotFoundException e) {
            throw new DataNotFoundException(e.getErrorDto());
        } catch (ApiException e) {
            throw new InternalServerErrorException(e.getErrorDto());
        }
    }

    @PutMapping("/persona/{id}")
    public ResponseEntity<?> editarPersona(
            @PathVariable("id") long id,
            @Valid @RequestBody PersonaDTO persona) throws ApiException{
        try{
            return ResponseEntity.ok(bibliotecaServices.editarPersona(id,persona));
        } catch (BadRequestException e) {
            throw new BadRequestException(e.getErrorDto());
        } catch (DataNotFoundException e) {
            throw new DataNotFoundException(e.getErrorDto());
        } catch (ApiException e) {
            throw new InternalServerErrorException(e.getErrorDto());
        }
    }
    @PutMapping("/prestamo/{id}")
    public ResponseEntity<?> editarPrestamo(
            @PathVariable("id") long id,
            @Valid @RequestBody PrestamoRq prestamoRq) throws ApiException{
        try{
            return ResponseEntity.ok(bibliotecaServices.editarPrestamo(id, prestamoRq));
        } catch (BadRequestException e) {
            throw new BadRequestException(e.getErrorDto());
        } catch (DataNotFoundException e) {
            throw new DataNotFoundException(e.getErrorDto());
        } catch (ApiException e) {
            throw new InternalServerErrorException(e.getErrorDto());
        }
    }

    @DeleteMapping("/libro/{id}")
    public String eliminarLibro(
            @PathVariable("id") long id) throws ApiException{
        try{
            return bibliotecaServices.eliminarLibro(id);
        } catch (BadRequestException e) {
            throw new BadRequestException(e.getErrorDto());
        } catch (DataNotFoundException e) {
            throw new DataNotFoundException(e.getErrorDto());
        } catch (ApiException e) {
            throw new InternalServerErrorException(e.getErrorDto());
        }
    }

    @DeleteMapping("/persona/{id}")
    public String eliminarPersona(
            @PathVariable("id") long id) throws ApiException{
        try{
            return bibliotecaServices.eliminarPersona(id);
        } catch (BadRequestException e) {
            throw new BadRequestException(e.getErrorDto());
        } catch (DataNotFoundException e) {
            throw new DataNotFoundException(e.getErrorDto());
        } catch (ApiException e) {
            throw new InternalServerErrorException(e.getErrorDto());
        }
    }
    @DeleteMapping("/prestamo/{id}")
    public String eliminarPrestamo(
            @PathVariable("id") long id) throws ApiException{

        try {
            return bibliotecaServices.eliminarPrestamo(id);
        } catch (BadRequestException e) {
            throw new BadRequestException(e.getErrorDto());
        } catch (DataNotFoundException e) {
            throw new DataNotFoundException(e.getErrorDto());
        } catch (ApiException e) {
            throw new InternalServerErrorException(e.getErrorDto());
        }
    }


}
