package com.alura.literalura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.alura.literalura.repository.LibroRepository;
import com.alura.literalura.repository.AutorRepository;
import com.alura.literalura.service.ConsultaGutendex;
import com.alura.literalura.service.ConversionDatos;
import com.alura.literalura.model.*;
import java.util.Scanner;
import java.util.List;
import java.util.Optional;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.alura.literalura.repository")
public class LiterAluraApplication {

    public static void main(String[] args) {
        try {
            // Configurar UTF-8 para la salida
            System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        } catch (Exception e) {
            System.err.println("Error configurando UTF-8: " + e.getMessage());
        }
        SpringApplication.run(LiterAluraApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(LibroRepository libroRepository, AutorRepository autorRepository) {
        return args -> {
            Scanner scanner = new Scanner(System.in, "UTF-8");
            ConsultaGutendex consulta = new ConsultaGutendex();
            boolean salir = false;

            System.out.println("\n====================================");
            System.out.println("   BIENVENIDO A LITERALURA!");
            System.out.println("  Catalogo de Libros - Alura + Oracle");
            System.out.println("====================================\n");

            while (!salir) {
                mostrarMenu();
                System.out.print("\nSelecciona una opcion: ");
                String opcion = scanner.nextLine().trim();

                switch (opcion) {
                    case "1":
                        buscarLibro(scanner, consulta, libroRepository, autorRepository);
                        break;
                    case "2":
                        listarTodosLibros(libroRepository);
                        break;
                    case "3":
                        listarTodosAutores(autorRepository);
                        break;
                    case "4":
                        listarAutoresVivos(scanner, autorRepository);
                        break;
                    case "5":
                        listarLibrosPorIdioma(scanner, libroRepository);
                        break;
                    case "6":
                        System.out.println("\n[SALIENDO] Hasta luego!");
                        salir = true;
                        break;
                    default:
                        System.out.println("[ERROR] Opcion no valida. Intenta de nuevo.");
                }
                if (!salir) {
                    System.out.print("\nPresiona ENTER para continuar...");
                    scanner.nextLine();
                    System.out.println("\n");
                }
            }
            scanner.close();
        };
    }

    private void mostrarMenu() {
        System.out.println();
        System.out.println("=====================================");
        System.out.println("      MENU PRINCIPAL");
        System.out.println("=====================================");
        System.out.println("1. Buscar libro por titulo");
        System.out.println("2. Listar todos los libros");
        System.out.println("3. Listar autores");
        System.out.println("4. Buscar libros por fecha");
        System.out.println("5. Libros por idioma");
        System.out.println("6. Salir");
        System.out.println("=====================================");
    }

    private void buscarLibro(Scanner scanner, ConsultaGutendex consulta, 
                            LibroRepository libroRepository, AutorRepository autorRepository) {
        System.out.print("\nEscribe el titulo del libro a buscar: ");
        String titulo = scanner.nextLine().trim();

        System.out.println("\n[BUSCANDO] Buscando en Gutendex...");
        RespuestaGutendex respuesta = consulta.buscarLibros(titulo);
        
        if (respuesta != null && respuesta.getResults() != null && !respuesta.getResults().isEmpty()) {
            LibroDTO libroDTO = respuesta.getResults().get(0);
            System.out.println("\n[OK] Libro encontrado!");
            mostrarDetallesLibroDTO(libroDTO);
            
            // Verificar si ya existe en la BD
            Optional<Libro> libroExistente = libroRepository.findByTituloIgnoreCase(libroDTO.getTitulo());
            if (libroExistente.isPresent()) {
                System.out.println("[ADVERTENCIA] Este libro ya estaba en la base de datos.");
            } else {
                Libro libroGuardado = ConversionDatos.convertirDTOaLibro(libroDTO);
                libroRepository.save(libroGuardado);
                System.out.println("[OK] Libro guardado exitosamente en la base de datos.");
            }
        } else {
            System.out.println("\n[ERROR] No se encontraron libros con ese titulo en Gutendex.");
            System.out.println("[TIP] Intenta con otro titulo o verifica la ortografia.");
        }
    }

    private void listarTodosLibros(LibroRepository libroRepository) {
        List<Libro> libros = libroRepository.findAll();
        
        if (libros.isEmpty()) {
            System.out.println("\n[ERROR] No hay libros en la base de datos.");
            return;
        }
        
        System.out.println("\n=== LIBROS REGISTRADOS EN LA BASE DE DATOS ===");
        System.out.println("Total: " + libros.size() + " libro(s)\n");
        
        libros.forEach(libro -> {
            System.out.println("[LIBRO] " + (libro.getTitulo() != null ? libro.getTitulo() : "N/A"));
            System.out.println("        Idioma: " + (libro.getIdiomas() != null ? libro.getIdiomas() : "N/A"));
            System.out.println("        Descargas: " + (libro.getNumeroDescargas() != null ? libro.getNumeroDescargas() : "N/A"));
            
            if (libro.getAutores() != null && !libro.getAutores().isEmpty()) {
                System.out.print("        Autor: ");
                libro.getAutores().forEach(a -> 
                    System.out.print((a.getNombre() != null ? a.getNombre() : "N/A"))
                );
                System.out.println();
            }
            System.out.println();
        });
    }

    private void listarTodosAutores(AutorRepository autorRepository) {
        List<Autor> autores = autorRepository.findAll();
        
        if (autores.isEmpty()) {
            System.out.println("\n[ERROR] No hay autores en la base de datos.");
            return;
        }
        
        System.out.println("\n=== AUTORES REGISTRADOS ===");
        System.out.println("Total: " + autores.size() + " autor(es)\n");
        
        autores.forEach(autor -> {
            System.out.println("[AUTOR] " + (autor.getNombre() != null ? autor.getNombre() : "N/A"));
            String nacimiento = autor.getAnioNacimiento() != null ? autor.getAnioNacimiento().toString() : "?";
            String muerte = autor.getAnioMuerte() != null ? autor.getAnioMuerte().toString() : "Vivo";
            System.out.println("        Periodo: " + nacimiento + " - " + muerte);
            System.out.println();
        });
    }

    private void listarAutoresVivos(Scanner scanner, AutorRepository autorRepository) {
        System.out.print("\nIngresa la fecha para consultar: ");
        try {
            Integer anio = Integer.parseInt(scanner.nextLine().trim());
            List<Autor> autores = autorRepository.buscarAutoresVivosPorAnio(anio);
            
            if (autores.isEmpty()) {
                System.out.println("\n[ERROR] No hay autores vivos en la fecha " + anio);
                return;
            }
            
            System.out.println("\n[OK] AUTORES VIVOS EN " + anio + ":");
            System.out.println("=====================================");
            autores.forEach(autor -> {
                System.out.println("\n[AUTOR] " + autor.getNombre());
                System.out.println("        Nacimiento: " + autor.getAnioNacimiento());
                System.out.println("        Fallecimiento: " + 
                                 (autor.getAnioMuerte() != null ? autor.getAnioMuerte() : "Vivo"));
            });
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] Por favor ingresa un Fecha valido (numero).");
        }
    }

    private void listarLibrosPorIdioma(Scanner scanner, LibroRepository libroRepository) {
        System.out.println("\nIdiomas disponibles: es (espanol), en (ingles), fr (frances), de (aleman), pt (portugues)");
        System.out.print("Ingresa el codigo del idioma: ");
        String idioma = scanner.nextLine().trim().toLowerCase();
        
        List<Libro> libros = libroRepository.findByIdiomasContainsIgnoreCase(idioma);
        
        if (libros.isEmpty()) {
            System.out.println("\n[ERROR] No hay libros en ese idioma.");
            return;
        }
        
        System.out.println("\n=== LIBROS EN " + idioma.toUpperCase() + " ===");
        
        libros.forEach(libro -> {
            System.out.println("\n[LIBRO] " + libro.getTitulo());
            System.out.println("        Descargas: " + libro.getNumeroDescargas());
        });
        
        System.out.println("\n[RESUMEN] Total de libros: " + libros.size());
    }

    private void mostrarDetallesLibroDTO(LibroDTO libro) {
        System.out.println("\n=== DETALLES DEL LIBRO ===");
        System.out.println("Titulo: " + (libro.getTitulo() != null ? libro.getTitulo() : "N/A"));
        
        String idiomas = libro.getIdiomas() != null && !libro.getIdiomas().isEmpty() 
                        ? libro.getIdiomas().get(0) 
                        : "N/A";
        System.out.println("Idioma: " + idiomas);
        
        Integer descargas = libro.getNumeroDescargas() != null ? libro.getNumeroDescargas() : 0;
        System.out.println("Descargas: " + String.format("%,d", descargas));
        
        if (libro.getAutores() != null && !libro.getAutores().isEmpty()) {
            System.out.println("\nAutor(es):");
            libro.getAutores().forEach(a -> {
                String nacimiento = a.getAnioNacimiento() != null ? a.getAnioNacimiento().toString() : "?";
                String muerte = a.getAnioMuerte() != null ? a.getAnioMuerte().toString() : "Vivo";
                System.out.println("  - " + (a.getNombre() != null ? a.getNombre() : "N/A") + 
                                 " (" + nacimiento + " - " + muerte + ")");
            });
        }
        System.out.println("===========================");
    }
}
