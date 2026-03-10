package com.alura.literalura.repository;

import com.alura.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findByNombreIgnoreCase(String nombre);
    
    @Query("SELECT a FROM Autor a WHERE a.anioNacimiento <= :anio AND (a.anioMuerte IS NULL OR a.anioMuerte >= :anio)")
    List<Autor> buscarAutoresVivosPorAnio(Integer anio);
}
