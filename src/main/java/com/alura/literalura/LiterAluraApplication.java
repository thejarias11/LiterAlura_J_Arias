package com.alura.literalura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LiterAluraApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiterAluraApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
            System.out.println("¡Bienvenido a LiterAlura!");
            System.out.println("=========================");
            mostrarMenu();
        };
    }

    private void mostrarMenu() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Buscar libro por título");
        System.out.println("2. Listar todos los libros");
        System.out.println("3. Listar autores");
        System.out.println("4. Listar autores vivos en un año");
        System.out.println("5. Listar libros por idioma");
        System.out.println("6. Salir");
        System.out.println("Próximamente implementaremos la lógica completa...");
    }
}
