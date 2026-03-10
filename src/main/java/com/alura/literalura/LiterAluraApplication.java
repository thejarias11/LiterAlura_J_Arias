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
            Scanner scanner = new Scanner(System.in);
            ConsultaGutendex consulta = new ConsultaGutendex();
            boolean salir = false;

            System.out.println("\n╔════════════════════════════════════╗");
            System.out.println("║   ¡BIENVENIDO A LITERALURA!         ║");
            System.out.println("║  Catálogo de Libros - Alura + Oracle ║");
            System.out.println("╚════════════════════════════════════╝\n");

            while (!salir) {
                mostrarMenu();
                System.out.print("\nSelecciona una opción: ");
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
                        System.out.println("\n¡Hasta luego! 👋");
                        salir = true;
                        break;
                    default:
                        System.out.println("❌ Opción no válida. Intenta de nuevo.");
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
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║        --- MENÚ PRINCIPAL ---       ║");
        System.out.println("╠════════════════════════════════════╣");
        System.out.println("║ 1. 🔍 Buscar libro por título      ║");
        System.out.println("║ 2. 📚 Listar todos los libros      ║");
        System.out.println("║ 3. 👤 Listar autores               ║");
        System.out.println("║ 4. 📅 Autores vivos en un año      ║");
        System.out.println("║ 5. 🌐 Libros por idioma            ║");
        System.out.println("║ 6. 🚪 Salir                        ║");
        System.out.println("╚════════════════════════════════════╝");
    }

    private void buscarLibro(Scanner scanner, ConsultaGutendex consulta, 
                            LibroRepository libroRepository, AutorRepository autorRepository) {
        System.out.print("\nEscribe el título del libro a buscar: ");
        String titulo = scanner.nextLine().trim();

        RespuestaGutendex respuesta = consulta.buscarLibros(titulo);
        
        if (respuesta != null && respuesta.getResults() != null && !respuesta.getResults().isEmpty()) {
            LibroDTO libroDTO = respuesta.getResults().get(0);
            System.out.println("\n✅ Libro encontrado:");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            mostrarDetallesLibroDTO(libroDTO);
            
            // Verificar si ya existe en la BD
            Optional<Libro> libroExistente = libroRepository.findByTituloIgnoreCase(libroDTO.getTitulo());
            if (libroExistente.isPresent()) {
                System.out.println("⚠️  Este libro ya estaba en la base de datos.");
            } else {
                Libro libroGuardado = ConversionDatos.convertirDTOaLibro(libroDTO);
                libroRepository.save(libroGuardado);
                System.out.println("💾 Libro guardado en la base de datos.");
            }
        } else {
            System.out.println("❌ No se encontraron libros con ese título.");
        }
    }

    private void listarTodosLibros(LibroRepository libroRepository) {
        List<Libro> libros = libroRepository.findAll();
        
        if (libros.isEmpty()) {
            System.out.println("\n❌ No hay libros en la base de datos.");
            return;
        }
        
        System.out.println("\n📚 LIBROS EN LA BASE DE DATOS:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        libros.forEach(libro -> {
            System.out.println("\n📖 " + libro.getTitulo());
            System.out.println("   Idioma: " + libro.getIdiomas());
            System.out.println("   Descargas: " + libro.getNumeroDescargas());
            if (libro.getAutores() != null && !libro.getAutores().isEmpty()) {
                System.out.println("   Autores: ");
                libro.getAutores().forEach(a -> 
                    System.out.println("      - " + a.getNombre() + 
                                     " (" + a.getAnioNacimiento() + 
                                     (a.getAnioMuerte() != null ? "-" + a.getAnioMuerte() : "") + ")")
                );
            }
        });
    }

    private void listarTodosAutores(AutorRepository autorRepository) {
        List<Autor> autores = autorRepository.findAll();
        
        if (autores.isEmpty()) {
            System.out.println("\n❌ No hay autores en la base de datos.");
            return;
        }
        
        System.out.println("\n👥 AUTORES REGISTRADOS:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        autores.forEach(autor -> {
            System.out.println("\n👤 " + autor.getNombre());
            System.out.println("   Nacimiento: " + autor.getAnioNacimiento());
            System.out.println("   Fallecimiento: " + 
                             (autor.getAnioMuerte() != null ? autor.getAnioMuerte() : "Desconocido"));
        });
    }

    private void listarAutoresVivos(Scanner scanner, AutorRepository autorRepository) {
        System.out.print("\nIngresa el año para consultar: ");
        try {
            Integer anio = Integer.parseInt(scanner.nextLine().trim());
            List<Autor> autores = autorRepository.buscarAutoresVivosPorAnio(anio);
            
            if (autores.isEmpty()) {
                System.out.println("\n❌ No hay autores vivos en el año " + anio);
                return;
            }
            
            System.out.println("\n✅ AUTORES VIVOS EN " + anio + ":");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            autores.forEach(autor -> {
                System.out.println("\n👤 " + autor.getNombre());
                System.out.println("   Nacimiento: " + autor.getAnioNacimiento());
                System.out.println("   Fallecimiento: " + 
                                 (autor.getAnioMuerte() != null ? autor.getAnioMuerte() : "Vivo"));
            });
        } catch (NumberFormatException e) {
            System.out.println("❌ Por favor ingresa un año válido (número).");
        }
    }

    private void listarLibrosPorIdioma(Scanner scanner, LibroRepository libroRepository) {
        System.out.println("\nIdiomas disponibles: es (español), en (inglés), fr (francés), de (alemán), pt (portugués)");
        System.out.print("Ingresa el código del idioma: ");
        String idioma = scanner.nextLine().trim().toLowerCase();
        
        List<Libro> libros = libroRepository.findByIdiomasContainsIgnoreCase(idioma);
        
        if (libros.isEmpty()) {
            System.out.println("\n❌ No hay libros en ese idioma.");
            return;
        }
        
        System.out.println("\n📚 LIBROS EN " + idioma.toUpperCase() + ":");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        libros.forEach(libro -> {
            System.out.println("\n📖 " + libro.getTitulo());
            System.out.println("   Descargas: " + libro.getNumeroDescargas());
        });
        
        System.out.println("\n\n📊 Total de libros: " + libros.size());
    }

    private void mostrarDetallesLibroDTO(LibroDTO libro) {
        System.out.println("📖 Título: " + libro.getTitulo());
        System.out.println("   Idioma(s): " + libro.getIdiomas());
        System.out.println("   Descargas: " + libro.getNumeroDescargas());
        if (libro.getAutores() != null && !libro.getAutores().isEmpty()) {
            System.out.println("   Autores: ");
            libro.getAutores().forEach(a -> 
                System.out.println("      - " + a.getNombre() + 
                                 " (" + a.getAnioNacimiento() + 
                                 (a.getAnioMuerte() != null ? "-" + a.getAnioMuerte() : "") + ")")
            );
        }
    }
}
