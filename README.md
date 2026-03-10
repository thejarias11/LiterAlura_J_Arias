# LiterAlura 📚

**Desafío Alura + Oracle: Catálogo de Libros con Spring Boot**

## Descripción

LiterAlura es una aplicación Java/Spring Boot que consume la API Gutendex para obtener información de libros y autores. La aplicación permite buscar libros, consultar autores, y filtrar por idioma y año de vida.

## Características

✅ Búsqueda de libros por título  
✅ Listar todos los libros guardados  
✅ Listar autores  
✅ Consultar autores vivos en un año específico  
✅ Filtrar libros por idioma  
✅ Persistencia en PostgreSQL  

## Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3.2.3**
- **Spring Data JPA**
- **PostgreSQL 16**
- **Maven 3.9.6**
- **Jackson** (para parseo JSON)
- **API Gutendex** (https://gutendex.com/)

## Requisitos Previos

- Java JDK 17+
- Maven 3.9+
- PostgreSQL 16+
- VS Code o IntelliJ IDEA

## Instalación y Configuración

### 1. Clonar el repositorio

```bash
git clone https://github.com/tuusuario/literalura.git
cd literalura
```

### 2. Configurar PostgreSQL

Crea una base de datos llamada `literalura`:

```bash
psql -U postgres
CREATE DATABASE literalura;
```

### 3. Configurar archivo `application.properties`

Modifica `src/main/resources/application.properties` con tus credenciales de PostgreSQL:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/literalura
spring.datasource.username=postgres
spring.datasource.password=tu_contraseña
```

### 4. Compilar y ejecutar

```bash
mvn clean install
mvn spring-boot:run
```

## Uso

Al ejecutar la aplicación, se mostrará un menú interactivo con las siguientes opciones:

```
--- MENÚ PRINCIPAL ---
1. Buscar libro por título
2. Listar todos los libros
3. Listar autores
4. Listar autores vivos en un año
5. Listar libros por idioma
6. Salir
```

## Estructura del Proyecto

```
LiterAlura/
├── src/
│   ├── main/
│   │   ├── java/com/alura/literalura/
│   │   │   ├── LiterAluraApplication.java (Clase principal)
│   │   │   ├── model/                    (Entidades JPA)
│   │   │   ├── repository/               (Repositorios JPA)
│   │   │   └── service/                  (Lógica de negocio)
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── pom.xml (Dependencias Maven)
├── .gitignore
└── README.md
```

## API Gutendex

La API Gutendex proporciona información sobre más de 70,000 libros:

- **URL Base**: https://gutendex.com/
- **Endpoint Libros**: https://gutendex.com/books/?search=título
- **Documentación**: https://gutendex.com/

Ejemplo de consulta:
```
GET https://gutendex.com/books/?search=Harry%20Potter
```

## Progreso del Desafío

- [x] Configuración del entorno (Java, Maven, Spring, PostgreSQL)
- [x] Creación de proyecto base
- [ ] Implementar consumo de API Gutendex
- [ ] Parsear respuestas JSON
- [ ] Crear entidades (Libro, Autor)
- [ ] Implementar repositorios JPA
- [ ] Menú interactivo completo
- [ ] Búsqueda y filtros
- [ ] Pruebas finales

## Autor

Desarrollado como parte del Challenge Alura + Oracle One.

## Licencia

MIT License
