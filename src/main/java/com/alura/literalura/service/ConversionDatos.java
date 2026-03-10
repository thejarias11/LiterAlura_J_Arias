package com.alura.literalura.service;

import com.alura.literalura.model.Libro;
import com.alura.literalura.model.Autor;
import com.alura.literalura.model.LibroDTO;
import com.alura.literalura.model.AutorDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConversionDatos {

    /**
     * Convierte un LibroDTO a una entidad Libro
     * @param libroDTO El DTO obtenido de la API
     * @return Una entidad Libro con los datos convertidos
     */
    public static Libro convertirDTOaLibro(LibroDTO libroDTO) {
        Libro libro = new Libro();
        libro.setTitulo(libroDTO.getTitulo());
        libro.setNumeroDescargas(libroDTO.getNumeroDescargas());
        
        // Obtener solo el primer idioma
        String idioma = libroDTO.getIdiomas() != null && !libroDTO.getIdiomas().isEmpty() 
                ? libroDTO.getIdiomas().get(0) 
                : "Desconocido";
        libro.setIdiomas(idioma);
        
        // Convertir autores
        List<Autor> autores = new ArrayList<>();
        if (libroDTO.getAutores() != null && !libroDTO.getAutores().isEmpty()) {
            for (AutorDTO autorDTO : libroDTO.getAutores()) {
                Autor autor = new Autor();
                autor.setNombre(autorDTO.getNombre());
                autor.setAnioNacimiento(autorDTO.getAnioNacimiento());
                autor.setAnioMuerte(autorDTO.getAnioMuerte());
                autor.setLibro(libro);
                autores.add(autor);
            }
        }
        libro.setAutores(autores);
        
        return libro;
    }

    /**
     * Convierte un AutorDTO a una entidad Autor
     * @param autorDTO El DTO del autor
     * @return Una entidad Autor
     */
    public static Autor convertirDTOaAutor(AutorDTO autorDTO) {
        Autor autor = new Autor();
        autor.setNombre(autorDTO.getNombre());
        autor.setAnioNacimiento(autorDTO.getAnioNacimiento());
        autor.setAnioMuerte(autorDTO.getAnioMuerte());
        return autor;
    }
}
