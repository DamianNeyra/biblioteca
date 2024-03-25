package com.prueba.biblioteca.Repository;

import com.prueba.biblioteca.Model.Prestamos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestamosRepository extends JpaRepository<Prestamos, Long>{
}
