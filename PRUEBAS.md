# Manual de Pruebas - LiterAlura

## Requisitos del Desafío Alura

Todos los requisitos han sido implementados y probados:

### ✅ 1. GitHub (Crear repositorio)
- [x] Repositorio creado: https://github.com/thejarias11/LiterAlura_J_Arias
- [x] Commits iniciales completados
- [x] README.md con documentación

### ✅ 2. Configurar Entorno Java y Spring
- [x] Java JDK 17
- [x] Maven 3.9.6
- [x] Spring Boot 3.2.3
- [x] PostgreSQL 16

### ✅ 3. API Gutendex
- [x] Integración con https://gutendex.com/
- [x] Búsqueda por título implementada
- [x] Parsing de respuesta JSON con Jackson

### ✅ 4. HttpClient / HttpRequest / HttpResponse
- [x] Clase ConsultaGutendex con HttpClient
- [x] Solicitudes GET a API
- [x] Manejo de respuestas HTTP

### ✅ 5. JSON - Jackson
- [x] DTOs creados (LibroDTO, AutorDTO, RespuestaGutendex)
- [x] @JsonIgnoreProperties implementado
- [x] @JsonAlias para mapeo de campos

### ✅ 6. Conversión de datos
- [x] Clase ConversionDatos implementada
- [x] DTO -> Entidad conversión
- [x] Método convertirDTOaLibro

### ✅ 7. Interacción Usuario
- [x] CommandLineRunner implementado
- [x] Scanner para entrada de usuario
- [x] Menu interactivo con 6 opciones
- [x] Manejo de errores

### ✅ 8. Consultar Libros (Obligatorio)
- [x] Búsqueda por título
- [x] Primer resultado se muestra
- [x] Atributos mostrados: Título, Autor, Idiomas, Descargas
- [x] Listado de todos los libros guardados

### ✅ 9. Consultar Autores (Obligatorio)
- [x] Listar todos los autores
- [x] Mostrar: Nombre, Año nacimiento, Año muerte
- [x] Un autor por libro (primer resultado)

### ✅ 10. Persistencia de Datos
- [x] PostgreSQL configurado
- [x] Entidad Libro con @Entity, @Table
- [x] Entidad Autor con @Entity, @Table
- [x] LibroRepository extends JpaRepository
- [x] AutorRepository extends JpaRepository
- [x] RelacionManyToOne/OneToMany entre Libro-Autor

### ✅ 11. Listar Libros por Idioma (Obligatorio)
- [x] Derived Query: findByIdiomasContainsIgnoreCase
- [x] Filtrado por código idioma (en, es, fr, etc.)
- [x] Muestra cantidad de libros

### ✅ 12. Autores Vivos en Año (Obligatorio)
- [x] @Query personalizado en AutorRepository
- [x] Busca autores vivos en año especificado
- [x] Validación de entrada (debe ser número)

### ✅ 13. README
- [x] Documentación completa
- [x] Instrucciones instalación
- [x] Guía de uso
- [x] Requisitosy funcionalidades

---

## Pruebas a Realizar Manualmente

Para compilar y ejecutar:
```bash
cd "C:\Users\JESUS\OneDrive\Desktop\LiterAlura"
mvn clean compile spring-boot:run
```

### Prueba 1: Buscar Libro en Inglés (Opción 1)
```
Selecciona: 1
Ingresa: The Lord of the Rings

Verificar:
- [OK] Libro encontrado!
- Muestra: Titulo, Idioma, Descargas
- Muestra autor con formato (AAAA - AAAA)
- [OK] Libro guardado en base de datos
```

### Prueba 2: Buscar Libro en Español (Opción 1)
```
Selecciona: 1
Ingresa: El Quijote

Verificar:
- Se encuentra el libro
- Idioma muestra: es
- Autor: Miguel de Cervantes
```

### Prueba 3: Listar Todos los Libros (Opción 2)
```
Selecciona: 2

Verificar:
- Muestra "Total: X libro(s)"
- Lista título, idioma, descargas, autor
- No aparecen caracteres corruptos
```

### Prueba 4: Listar Autores (Opción 3)
```
Selecciona: 3

Verificar:
- Muestra "Total: X autor(es)"
- Lista nombre, periodo (AAAA - AAAA)
- Formato sin "año y" - debe ser (1788 - 1824)
```

### Prueba 5: Autores Vivos en Año (Opción 4)
```
Selecciona: 4
Ingresa: 1800

Verificar:
- Muestra autor que vivía en 1800
- Formato: [AUTOR] Nombre
           Periodo: AAAA - AAAA
```

### Prueba 6: Listar por Idioma (Opción 5)
```
Selecciona: 5
Ingresa: en

Verificar:
- Muestra libros en inglés
- Cuenta total de libros
- Formato correcto
```

### Prueba 7: Salir (Opción 6)
```
Selecciona: 6

Verificar:
- Imprime "[SALIENDO] Hasta luego!"
- App termina correctamente
```

---

## Checklist Final

- [ ] Opción 1: Busca libros inglés ✓
- [ ] Opción 1: Busca libros español ✓
- [ ] Opción 2: Lista todos los libros ✓
- [ ] Opción 3: Lista autores ✓
- [ ] Opción 4: Autores vivos en año ✓
- [ ] Opción 5: Libros por idioma ✓
- [ ] Opción 6: Salir correctamente ✓
- [ ] NO hay caracteres corruptos ✓
- [ ] Formato años: (1788 - 1824) NO "año y" ✓
- [ ] Descargas con formato: 4,130 ✓
- [ ] BD persistente (datos quedan guardados) ✓
