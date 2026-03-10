# LiterAlura 📚

**Desafío Alura + Oracle: Catálogo de Libros con Spring Boot**

## Descripción

LiterAlura es una aplicación Java/Spring Boot que consume la API Gutendex para obtener información de libros y autores. La aplicación permite buscar libros, consultar autores, y filtrar por idioma y año de vida.

## 📹 Video Demostración

**[VER VIDEO AQUÍ](https://youtu.be/PADsKHmXqPc)** - Demostración completa de todas las funcionalidades

El video demuestra:
- ✅ Búsqueda de libros en tiempo real (consumiendo Gutendex API)
- ✅ Persistencia automática en PostgreSQL
- ✅ Listado de todos los libros guardados
- ✅ Listado de autores con sus años de vida
- ✅ Filtrado de autores vivos en año específico
- ✅ Filtrado de libros por idioma
- ✅ Menú interactivo y manejo correcto de caracteres especiales (UTF-8)

### Guiones de Ejecución y Grabación

Para replicar la grabación del video:

- **[EJECUTAR_Y_GRABAR.md](./EJECUTAR_Y_GRABAR.md)** - Guion completo en **ESPAÑOL** con instrucciones paso a paso y diálogos
- **[EXECUTE_AND_RECORD.md](./EXECUTE_AND_RECORD.md)** - Guion completo en **INGLÉS** con instrucciones paso a paso y diálogos

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

## 🚀 INICIO RÁPIDO (Para Instructores)

### OPCIÓN 1: Ejecución Inmediata (Recomendado para pruebas rápidas)

```bash
# 1. Clonar el repositorio
git clone https://github.com/thejarias11/LiterAlura_J_Arias.git
cd LiterAlura_J_Arias

# 2. Ejecutar directamente (sin configuración adicional)
mvn clean spring-boot:run

# 3. Esperar a que aparezca: "Selecciona una opcion:"
# 4. Probar las opciones del menú
```

**NOTA:** La primera ejecución descargará ~500MB de dependencias Maven. Esto es normal.

### OPCIÓN 2: Con PostgreSQL (Para usar base de datos POR DEFECTO)

Si tienes PostgreSQL 16 instalado:

```bash
# 1. Crear base de datos
"C:\Program Files\PostgreSQL\16\bin\psql.exe" -U postgres -c "CREATE DATABASE literalura;"

# 2. Ejecutar la aplicación
cd C:\Users\JESUS\OneDrive\Desktop\LiterAlura
mvn clean spring-boot:run
```

La aplicación automáticamente:
- Crea las tablas (`libro` y `autor`)
- Conecta a PostgreSQL
- Persiste los datos

### OPCIÓN 3: Paso a Paso Detallado (Para principiantes)

Sigue el guion completo en:
- **[EJECUTAR_Y_GRABAR.md](./EJECUTAR_Y_GRABAR.md)** (Español)
- **[EXECUTE_AND_RECORD.md](./EXECUTE_AND_RECORD.md)** (Inglés)

## ✅ Pruebas Rápidas (Para verificar que funciona)

Después de ejecutar `mvn clean spring-boot:run`, prueba esto:

### Prueba 1: Buscar un libro (Opción 1)
```
Selecciona una opcion: 1
Titulo del libro: Pride and Prejudice
[ENTER]

Deberías ver:
- Título: Pride and Prejudice
- Autor: Jane Austen
- Idioma: en
- [OK] Guardado en la BD.
```

### Prueba 2: Listar libros (Opción 2)
```
Selecciona una opcion: 2
[ENTER]

Deberías ver:
- === LIBROS REGISTRADOS ===
- Total: 1 libro(s)
- [LIBRO] Pride and Prejudice
```

### Prueba 3: Listar autores (Opción 3)
```
Selecciona una opcion: 3
[ENTER]

Deberías ver:
- === AUTORES REGISTRADOS ===
- [AUTOR] Jane Austen
- Periodo: 1775 - Vivo
```

### Prueba 4: Autores vivos en fecha (Opción 4)
```
Selecciona una opcion: 4
Ingresa la fecha (anio): 1800
[ENTER]

Deberías ver que Jane Austen estaba viva en 1800
```

### Prueba 5: Libros por idioma (Opción 5)
```
Selecciona una opcion: 5
Ingresa el codigo del idioma: en
[ENTER]

Deberías ver "Pride and Prejudice" en inglés
```

## 📋 13 Requisitos Alura - ¡TODOS IMPLEMENTADOS!

| # | Requisito | Estado | Donde verlo |
|---|-----------|--------|---------|
| 1 | API Gutendex | ✅ | Opción 1 - Buscar libro |
| 2 | Guardar en PostgreSQL | ✅ | Opción 1 - Guardado automático |
| 3 | Listar libros | ✅ | Opción 2 |
| 4 | Listar autores | ✅ | Opción 3 |
| 5 | Autores vivos en fecha | ✅ | Opción 4 |
| 6 | Libros por idioma | ✅ | Opción 5 |
| 7 | Menú interactivo | ✅ | 6 opciones disponibles |
| 8 | Interfaz en consola | ✅ | Todo sin GUI |
| 9 | HttpClient para API | ✅ | Código: `ConsultaGutendex.java` |
| 10 | DTOs con Jackson | ✅ | Código: `LibroDTO.java`, `AutorDTO.java` |
| 11 | Entidades JPA | ✅ | Código: `Libro.java`, `Autor.java` |
| 12 | PostgreSQL + Hibernate | ✅ | Código: `application.properties` |
| 13 | Búsqueda case-insensitive | ✅ | Código: `findByTituloIgnoreCase()` |

## 👨‍🏫 Información para Instructores (Cómo Verificar la Implementación)

### Verificación de Requisitos por Código

**1. API Gutendex:**
- Ubicación: `src/main/java/.../service/ConsultaGutendex.java`
- Verifica: `private static final String URL_API = "https://gutendex.com/books?search=";`

**2. PostgreSQL + Hibernate:**
- Ubicación: `src/main/resources/application.properties`
- Verifica: `spring.datasource.url=jdbc:postgresql://localhost:5432/literalura`

**3. DTOs con Jackson:**
- Ubicación: `src/main/java/.../dto/LibroDTO.java`, `AutorDTO.java`
- Verifica: Anotaciones `@JsonAlias` para mapeo de JSON

**4. Entidades JPA:**
- Ubicación: `src/main/java/.../model/Libro.java`, `Autor.java`
- Verifica: Relaciones `@OneToMany` / `@ManyToOne`

**5. Repositorios con Custom Queries:**
- Ubicación: `src/main/java/.../repository/LibroRepository.java`
- Verifica: `findByTituloIgnoreCase()`, `findByAutoresVivosEnFecha()`

**6. Menú Interactivo:**
- Ubicación: `src/main/java/.../LiterAluraApplication.java`
- Verifica: `CommandLineRunner` con `Scanner` para 6 opciones

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
- [x] Menú interactivo completo (6 opciones funcionales)
- [x] Búsqueda y filtros por idioma
- [x] Integración con PostgreSQL 16
- [x] Almacenamiento persistente en base de datos
- [x] Mejora de formato de salida y codificación UTF-8
- [x] Pruebas exhaustivas de todas las funcionalidades
- [x] Documentación completa

## Base de Datos

**Actual:** PostgreSQL 16 (producción)  
**Alternativa:** H2 (desarrollo local - descomentar en application.properties)

### Configuración PostgreSQL

La aplicación ya viene configurada con PostgreSQL. Solo necesitas:

1. Instalar PostgreSQL 16 o superior
2. Crear la base de datos `literalura`:
   ```sql
   CREATE DATABASE literalura;
   ```
3. Configurar las credenciales en `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/literalura
   spring.datasource.username=postgres
   spring.datasource.password=tu_contraseña
   spring.jpa.hibernate.ddl-auto=create-drop
   ```
4. Las tablas se crean automáticamente al ejecutar la aplicación

## Autor

Desarrollado como parte del Challenge Alura + Oracle One.

## Solución de Problemas

| Problema | Solución |
|----------|----------|
| PostgreSQL no conecta | Verifica que PostgreSQL está corriendo y credenciales en application.properties |
| Caracteres como "?????" en salida | Ya está solucionado con UTF-8 encoding en desde la versión actual |
| Tabla no existe en BD | Normal en primer run - Hibernate la crea automáticamente |
| Repositorio no encontrado | Verifica anotación @EnableJpaRepositories en clase principal |
| API Gutendex no responde | Puede estar fuera de servicio - Intenta en unos minutos |

## Licencia

MIT License

---

## 📚 Guías Adicionales

- **[📹 Cómo grabar y subir tu Video Demo](./GUIA_POSTGRESQL.md)** - Paso a paso
- **[🔧 Configurar PostgreSQL completo](./GUIA_POSTGRESQL.md)** - Guía detallada con pgAdmin
