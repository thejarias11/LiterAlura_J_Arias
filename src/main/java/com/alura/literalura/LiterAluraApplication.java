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

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.alura.literalura.repository")
public class LiterAluraApplication {

    public static void main(String[] args) {
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
        System.out.println("4. Buscar autores vivos en una fecha");
        System.out.println("5. Libros por idioma");
        System.out.println("6. Salir");
        System.out.println("=====================================");
    }

    private void buscarLibro(Scanner scanner, ConsultaGutendex consulta, 
                            LibroRepository libroRepository, AutorRepository autorRepository) {
        System.out.print("\nTitulo del libro: ");
        String titulo = scanner.nextLine().trim();

        System.out.println("[BUSCANDO] En Gutendex...");
        RespuestaGutendex respuesta = consulta.buscarLibros(titulo);
        
        if (respuesta != null && respuesta.getResults() != null && !respuesta.getResults().isEmpty()) {
            LibroDTO libroDTO = respuesta.getResults().get(0);
            System.out.println("[OK] Encontrado!");
            mostrarDetallesLibroDTO(libroDTO);
            
            Optional<Libro> existe = libroRepository.findByTituloIgnoreCase(libroDTO.getTitulo());
            if (existe.isPresent()) {
                System.out.println("\n[ADVERTENCIA] Ya esta en la BD.");
            } else {
                Libro libro = ConversionDatos.convertirDTOaLibro(libroDTO);
                libroRepository.save(libro);
                System.out.println("\n[OK] Guardado en la BD.");
            }
        } else {
            System.out.println("[ERROR] No encontrado en Gutendex.");
        }
    }

    private void listarTodosLibros(LibroRepository libroRepository) {
        List<Libro> libros = libroRepository.findAll();
        
        if (libros.isEmpty()) {
            System.out.println("\n[ERROR] No hay libros en la base de datos.");
            return;
        }
        
        System.out.println("\n=== LIBROS REGISTRADOS ===");
        System.out.println("Total: " + libros.size() + " libro(s)\n");
        
        libros.forEach(libro -> {
            System.out.println("[LIBRO] " + libro.getTitulo());
            System.out.println("  Idioma: " + libro.getIdiomas());
            System.out.println("  Descargas: " + libro.getNumeroDescargas());
            if (libro.getAutores() != null && !libro.getAutores().isEmpty()) {
                System.out.print("  Autor: ");
                libro.getAutores().forEach(a -> System.out.print(a.getNombre() + " "));
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
            System.out.println("[AUTOR] " + autor.getNombre());
            System.out.println("  Periodo: " + autor.getAnioNacimiento() + " - " + 
                             (autor.getAnioMuerte() != null ? autor.getAnioMuerte() : "Vivo"));
            System.out.println();
        });
    }

    private void listarAutoresVivos(Scanner scanner, AutorRepository autorRepository) {
        System.out.print("\nIngresa la fecha (anio): ");
        try {
            Integer fecha = Integer.parseInt(scanner.nextLine().trim());
            List<Autor> autores = autorRepository.buscarAutoresVivosPorAnio(fecha);
            
            if (autores.isEmpty()) {
                System.out.println("\n[ERROR] No hay autores vivos en la fecha " + fecha);
                return;
            }
            
            System.out.println("\n[OK] AUTORES VIVOS EN " + fecha + ":");
            System.out.println("=====================================");
            autores.forEach(autor -> {
                System.out.println("[AUTOR] " + autor.getNombre());
                System.out.println("  Nacimiento: " + autor.getAnioNacimiento());
                System.out.println("  Fallecimiento: " + 
                                 (autor.getAnioMuerte() != null ? autor.getAnioMuerte() : "Vivo\n"));
            });
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] Ingresa un anio valido (numero).");
        }
    }

    private void listarLibrosPorIdioma(Scanner scanner, LibroRepository libroRepository) {
        System.out.println("\nIdiomas: es, en, fr, de, pt");
        System.out.print("Ingresa el codigo del idioma: ");
        String idioma = scanner.nextLine().trim().toLowerCase();
        
        List<Libro> libros = libroRepository.findByIdiomasContainsIgnoreCase(idioma);
        
        if (libros.isEmpty()) {
            System.out.println("\n[ERROR] No hay libros en ese idioma.");
            return;
        }
        
        System.out.println("\n=== LIBROS EN " + idioma.toUpperCase() + " ===");
        libros.forEach(libro -> System.out.println("[LIBRO] " + libro.getTitulo()));
        System.out.println("\nTotal: " + libros.size() + " libro(s)");
    }

    private void mostrarDetallesLibroDTO(LibroDTO libro) {
        System.out.println("\n=== DETALLES DEL LIBRO ===");
        System.out.println("Titulo: " + libro.getTitulo());
        System.out.println("Idioma: " + (libro.getIdiomas() != null && !libro.getIdiomas().isEmpty() 
                                        ? libro.getIdiomas().get(0) : "N/A"));
        System.out.println("Descargas: " + (libro.getNumeroDescargas() != null 
                                          ? libro.getNumeroDescargas() : "0"));
        
        if (libro.getAutores() != null && !libro.getAutores().isEmpty()) {
            System.out.println("\nAutor(es):");
            libro.getAutores().forEach(a -> {
                String nacimiento = a.getAnioNacimiento() != null ? a.getAnioNacimiento().toString() : "?";
                String muerte = a.getAnioMuerte() != null ? a.getAnioMuerte().toString() : "?";
                System.out.println("  - " + a.getNombre() + " (" + nacimiento + " - " + muerte + ")");
            });
        }
        System.out.println("=============================");
    }
}
