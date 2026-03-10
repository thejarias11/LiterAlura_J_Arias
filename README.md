# LiterAlura 📚

**Desafío Alura + Oracle: Catálogo de Libros con Spring Boot**

## Descripción

LiterAlura es una aplicación Java/Spring Boot que consume la API Gutendex para obtener información de libros y autores. La aplicación permite buscar libros, consultar autores, y filtrar por idioma y año de vida.

## 📹 Video Demo

**[Añade tu video aquí](https://youtu.be/)** - Instrucciones en `GUIA_POSTGRESQL.md`

El video debería demostrar:
- ✅ Búsqueda de libros en tiempo real (consumiendo Gutendex)
- ✅ Persistencia automática en PostgreSQL
- ✅ Listado de todos los libros guardados
- ✅ Listado de autores con sus años
- ✅ Filtrado de autores vivos en año específico
- ✅ Filtrado de libros por idioma
- ✅ Manejo de caracteres especiales (UTF-8 correcto)

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

Al ejecutar la aplicación con `mvn spring-boot:run`, se mostrará un menú interactivo:

```
╔════════════════════════════════════╗
║     📚 LITERALURA - MENÚ PRINCIPAL 📚    ║
╠════════════════════════════════════╣
║ 1. Buscar libro por título         ║
║ 2. Listar todos los libros         ║
║ 3. Listar autores                  ║
║ 4. Listar autores vivos en año     ║
║ 5. Listar libros por idioma        ║
║ 6. Salir                           ║
╚════════════════════════════════════╝
```

### Ejemplos de uso:

**Opción 1 - Buscar libro:**
```
Ingrese el título del libro: Don Quixote
```
La aplicación busca en Gutendex y guarda en la BD si no existe.

**Opción 2 - Listar libros:**
Muestra todos los libros almacenados con título, autores e idioma.

**Opción 3 - Listar autores:**
Muestra todos los autores registrados con sus años de nacimiento/muerte.

**Opción 4 - Autores vivos en año:**
```
Ingrese el año para obtener autores: 1800
```

**Opción 5 - Filtrar por idioma:**
```
Ingrese el código de idioma (en, es, fr, etc.): en
```
Soporta cualquier idioma disponible en Gutendex.

## ✅ Verificación de Funcionalidades

Para verificar que todo funciona correctamente:

1. **Compilar y ejecutar:**
   ```bash
   mvn clean compile
   mvn spring-boot:run
   ```

2. **Probar cada opción del menú:**
   - **Opción 1:** Busca un libro (ej: "Pride and Prejudice") → Debe aparecer en BD
   - **Opción 2:** Verifica que aparezca el libro buscado
   - **Opción 3:** Verifica que aparezca el/los autores
   - **Opción 4:** Busca autores vivos en 1800 → Debe mostrar Jane Austen
   - **Opción 5:** Filtra por idioma "en" → Debe mostrar libros en inglés
   - **Opción 6:** Salir de la aplicación

3. **Verificar UTF-8:**
   - Busca un libro con caracteres especiales
   - Verifica que NO aparezcan "?????" en la salida
   - Ejemplo: "Les Misérables" debe verse correctamente

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
