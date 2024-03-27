package com.prueba.biblioteca.Repository;

import com.prueba.biblioteca.Model.Libro;
import com.prueba.biblioteca.Model.LibroRs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro,Long> {

    @Query("SELECT new com.prueba.biblioteca.Model.LibroRs(l.titulo,l.autor,l.cantidad) " +
            "FROM Libro l ORDER BY l.titulo")
    List<LibroRs> listarLibros();
}
