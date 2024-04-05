package com.prueba.biblioteca.Repository;

import com.prueba.biblioteca.Model.LibroRs;
import com.prueba.biblioteca.Model.PrestamoRs;
import com.prueba.biblioteca.Model.Prestamos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrestamosRepository extends JpaRepository<Prestamos, Long>{
}
