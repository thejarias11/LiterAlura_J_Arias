package com.alura.literalura.service;

import com.alura.literalura.model.RespuestaGutendex;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaGutendex {

    private static final String API_BASE = "https://gutendex.com/books/";
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public ConsultaGutendex() {
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    /**
     * Busca libros por título en la API Gutendex
     * @param titulo El título del libro a buscar
     * @return RespuestaGutendex con los resultados
     */
    public RespuestaGutendex buscarLibros(String titulo) {
        try {
            String urlBusqueda = API_BASE + "?search=" + titulo.replace(" ", "%20");
            
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlBusqueda))
                    .header("Accept", "application/json")
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, 
                    HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return objectMapper.readValue(response.body(), RespuestaGutendex.class);
            } else {
                System.err.println("Error en la solicitud: " + response.statusCode());
                return null;
            }
        } catch (Exception e) {
            System.err.println("Error al conectar con la API: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Busca un libro específico por ID
     * @param id El ID del libro en Gutendex
     * @return LibroDTO si se encuentra, null en caso contrario
     */
    public com.alura.literalura.model.LibroDTO obtenerLibroPorId(Integer id) {
        try {
            String url = API_BASE + id;
            
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Accept", "application/json")
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, 
                    HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return objectMapper.readValue(response.body(), 
                        com.alura.literalura.model.LibroDTO.class);
            } else {
                System.err.println("Libro no encontrado: " + response.statusCode());
                return null;
            }
        } catch (Exception e) {
            System.err.println("Error al obtener el libro: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
