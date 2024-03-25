package com.prueba.biblioteca.Controller;

import com.prueba.biblioteca.Service.BibliotecaServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/listar-personas")
    public ResponseEntity<?> listarPersonas(){
        try {
            return ResponseEntity.ok(bibliotecaServices.listaPersonas());
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/listar-prestamos")
    public ResponseEntity<?> listarPrestamos(){
        try {
            return ResponseEntity.ok(bibliotecaServices.listaPrestamos());
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
