package com.prueba.biblioteca.Controller;

import com.prueba.biblioteca.Model.LibroDTO;
import com.prueba.biblioteca.Model.Persona;
import com.prueba.biblioteca.Model.PrestamoDTO;
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

    @PostMapping("/crear-libro")
    public String crearLibro(@RequestBody LibroDTO libroDTO){
        return bibliotecaServices.crearLibro(libroDTO);
    }

    @PostMapping("/crear-persona")
    public String crearPersona(@RequestBody Persona persona){
        return bibliotecaServices.crearPersona(persona);
    }
    @PostMapping("/crear-prestamo")
    public String crearPrestamo(@RequestBody PrestamoDTO prestamoDTO){
        return bibliotecaServices.crearPrestamo(prestamoDTO);
    }

    @PutMapping("/editar-libro/{id}")
    public String editarLibro(
            @PathVariable("id") long id,
            @RequestBody LibroDTO libroDTO){
        return bibliotecaServices.editarLibro(id,libroDTO);
    }

    @PutMapping("/editar-persona/{id}")
    public String editarPersona(
            @PathVariable("id") long id,
            @RequestBody Persona persona){
        return bibliotecaServices.editarPersona(id,persona);
    }
    @PutMapping("/editar-prestamo/{id}")
    public String editarPrestamo(
            @PathVariable("id") long id,
            @RequestBody PrestamoDTO prestamoDTO){
        return bibliotecaServices.editarPrestamo(id,prestamoDTO);
    }

    @DeleteMapping("/eliminar-libro/{id}")
    public String eliminarLibro(
            @PathVariable("id") long id){
        return bibliotecaServices.eliminarLibro(id);
    }

    @DeleteMapping("/eliminar-persona/{id}")
    public String eliminarPersona(
            @PathVariable("id") long id){
        return bibliotecaServices.eliminarPersona(id);
    }
    @DeleteMapping("/eliminar-prestamo/{id}")
    public String eliminarPrestamo(
            @PathVariable("id") long id){
        return bibliotecaServices.eliminarPrestamo(id);
    }


}
