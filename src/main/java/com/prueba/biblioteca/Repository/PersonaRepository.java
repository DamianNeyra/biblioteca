package com.prueba.biblioteca.Repository;

import com.prueba.biblioteca.Model.LibroRs;
import com.prueba.biblioteca.Model.Persona;
import com.prueba.biblioteca.Model.PersonaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

    @Query("SELECT new com.prueba.biblioteca.Model.PersonaDTO(p.nombre,p.apellido,p.direccion,p.identificacion) " +
            "FROM Persona p ORDER BY p.nombre")
    List<PersonaDTO> listarPersonas();
}
