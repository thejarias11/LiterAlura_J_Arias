# LiterAlura 📚

**Desafío Alura + Oracle: Catálogo de Libros con Spring Boot**

## Descripción

LiterAlura es una aplicación Java/Spring Boot que consume la API Gutendex para obtener información de libros y autores. La aplicación permite buscar libros, consultar autores, y filtrar por idioma y año de vida.

## 📹 Video Demo

**[VER DEMOSTRACIÓN](https://youtu.be/ejemplo)** - Aquí va el enlace a tu video demo

En el video se muestra:
- ✅ Búsqueda de libros en tiempo real
- ✅ Persistencia en base de datos
- ✅ Listado de libros y autores
- ✅ Filtros por idioma y año de vida

## Características

✅ Búsqueda de libros por título  
✅ Listar todos los libros guardados  
✅ Listar autores  
✅ Consultar autores vivos en un año específico  
✅ Filtrar libros por idioma  
✅ Persistencia en base de datos (H2 / PostgreSQL)  

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
git clone https://github.com/thejarias11/LiterAlura_J_Arias.git
cd LiterAlura_J_Arias
```

### 2. Requisitos

- Java JDK 17 o superior
- Maven 3.9 o superior
- PostgreSQL 16 (opcional - por defecto usa H2)

### 3. Compilar el proyecto

```bash
mvn clean compile
```

### 4. Ejecutar la aplicación

**Con H2 (por defecto, desarrollo rápido):**
```bash
mvn spring-boot:run
```

**Con PostgreSQL (producción):**

#### Opción A: Usar pgAdmin (GUI)
1. Abre **pgAdmin** (buscalo en Windows)
2. Conecta con el servidor PostgreSQL
3. Crea una nueva base de datos llamada `literalura`
4. Abre SQL Query y ejecuta:
```sql
ALTER USER postgres WITH PASSWORD 'tu_nueva_contraseña';
```
5. Guarda la contraseña en `application.properties`

#### Opción B: Línea de comandos
```bash
"C:\Program Files\PostgreSQL\16\bin\psql.exe" -U postgres -c "ALTER USER postgres WITH PASSWORD 'tu_nueva_contraseña';"
"C:\Program Files\PostgreSQL\16\bin\psql.exe" -U postgres -c "CREATE DATABASE literalura;"
```

#### Opción C: Archivo de configuración
Edita `src/main/resources/application-postgresql.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/literalura
spring.datasource.username=postgres
spring.datasource.password=tu_contraseña
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=create-drop
```

Luego ejecuta con el perfil PostgreSQL:
```bash
mvn spring-boot:run -Dspring-boot.run.arguments="--spring.profiles.active=postgresql"
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
- [x] Implementar consumo de API Gutendex
- [x] Parsear respuestas JSON
- [x] Crear entidades (Libro, Autor)
- [x] Implementar repositorios JPA
- [x] Menú interactivo completo
- [x] Búsqueda y filtros básicos
- [ ] Integración con PostgreSQL real
- [ ] Pruebas exhaustivas
- [ ] Documentación final

## Base de Datos

**Actual:** H2 (BD en memoria - desarrollo)  
**Objetivo:** PostgreSQL 16 (producción)

### Cambiar a PostgreSQL

1. Edita `src/main/resources/application.properties`
2. Descomenta la sección PostgreSQL
3. Configura tu contraseña
4. Ejecuta `mvn spring-boot:run`

## Autor

Desarrollado como parte del Challenge Alura + Oracle One.

## Licencia

MIT License

---

## 📚 Guías Adicionales

- **[📹 Cómo grabar y subir tu Video Demo](./GUIA_POSTGRESQL.md)** - Paso a paso
- **[🔧 Configurar PostgreSQL completo](./GUIA_POSTGRESQL.md)** - Guía detallada con pgAdmin
