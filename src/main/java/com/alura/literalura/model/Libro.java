package com.alura.literalura.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonAlias;
import java.util.List;

@Entity
@Table(name = "libros")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonAlias("title")
    @Column(unique = true, nullable = false)
    private String titulo;

    @JsonAlias("authors")
    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Autor> autores;

    @JsonAlias("languages")
    private String idiomas;

    @JsonAlias("download_count")
    private Integer numeroDescargas;

    // Constructores
    public Libro() {
    }

    public Libro(String titulo, String idiomas, Integer numeroDescargas) {
        this.titulo = titulo;
        this.idiomas = idiomas;
        this.numeroDescargas = numeroDescargas;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public Integer getNumeroDescargas() {
        return numeroDescargas;
    }

    public void setNumeroDescargas(Integer numeroDescargas) {
        this.numeroDescargas = numeroDescargas;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", idiomas='" + idiomas + '\'' +
                ", numeroDescargas=" + numeroDescargas +
                ", autores=" + (autores != null ? autores.size() : 0) +
                '}';
    }
}
