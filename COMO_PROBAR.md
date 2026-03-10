## COMO PROBAR LITERALURA - GUIA SIMPLE

### PASO 0: PREPARAR (SOLO PRIMERA VEZ)
```
1. Abre PowerShell o CMD
2. Ve a la carpeta: cd C:\Users\JESUS\OneDrive\Desktop\LiterAlura
3. Asegurate que PostgreSQL este corriendo. Si no:
   - En PowerShell (admin): & "C:\Program Files\PostgreSQL\18\bin\pg_ctl.exe" start -D "C:\Program Files\PostgreSQL\18\data"
```

---

## PASO 1: EJECUTAR LA APLICACION

```bash
mvn clean spring-boot:run
```

Espera a ver:
```
[OK] BIENVENIDO A LITERALURA!
Catalogo de Libros - Alura + Oracle
=====================================
MENU PRINCIPAL
=====================================
1. Buscar libro por titulo
2. Listar todos los libros
3. Listar autores
4. Buscar autores vivos en una fecha
5. Libros por idioma
6. Salir
=====================================
Selecciona una opcion:
```

---

## PASO 2: PROBAR OPCION 1 - BUSCAR LIBRO

**INPUT:**
```
1
Don Quijote
```

**OUTPUT que DEBERIA VER:**
```
[BUSCANDO] En Gutendex...
[OK] Encontrado!

=== DETALLES DEL LIBRO ===
Titulo: Don Quijote
Idioma: es
Descargas: 13446

Autor(es):
  - Cervantes Saavedra, Miguel de (1547 - 1616)
=============================

[OK] Guardado en la BD.
```

**QUE PASO:**
- La app busco en GUTENDEX.COM
- Encontro el libro
- Lo guardo en PostgreSQL

---

## PASO 3: PROBAR OPCION 2 - LISTAR LIBROS

**INPUT:**
```
ENTER (para continuar)
2
```

**OUTPUT que DEBERIA VER:**
```
=== LIBROS REGISTRADOS ===
Total: 1 libro(s)

[LIBRO] Don Quijote
  Idioma: es
  Descargas: 13446
  Autor: Cervantes Saavedra, Miguel de
```

**QUE PASO:**
- Mostro TODOS los libros guardados en PostgreSQL
- Don Quijote aparece porque lo guardamos en Paso 2

---

## PASO 4: PROBAR OPCION 3 - LISTAR AUTORES

**INPUT:**
```
ENTER (para continuar)
3
```

**OUTPUT que DEBERIA VER:**
```
=== AUTORES REGISTRADOS ===
Total: 1 autor(es)

[AUTOR] Cervantes Saavedra, Miguel de
  Periodo: 1547 - Vivo
```

**QUE PASO:**
- Mostro TODOS los autores en PostgreSQL
- Cervantes aparece porque fue guardado con el libro

---

## PASO 5: PROBAR OPCION 4 - AUTORES VIVOS EN UNA FECHA

**INPUT:**
```
ENTER (para continuar)
4
1600
```

**OUTPUT que DEBERIA VER:**
```
[OK] AUTORES VIVOS EN 1600:
=====================================
[AUTOR] Cervantes Saavedra, Miguel de
  Nacimiento: 1547
  Fallecimiento: 1616
```

**QUE PASO:**
- Busco autores que estaban vivos en 1600
- Cervantes: 1547-1616 (VIVO EN 1600) ✓
- La query es: "WHERE anioNacimiento <= 1600 AND (anioMuerte IS NULL OR anioMuerte >= 1600)"

---

## PASO 6: PROBAR OPCION 5 - LIBROS POR IDIOMA

**INPUT:**
```
ENTER (para continuar)
5
es
```

**OUTPUT que DEBERIA VER:**
```
Idiomas: es, en, fr, de, pt
Ingresa el codigo del idioma: 

=== LIBROS EN ES ===
[LIBRO] Don Quijote

Total: 1 libro(s)
```

**QUE PASO:**
- Mostro TODOS los libros en idioma "es" (español)
- Don Quijote es en espanol, aparece

---

## PASO 7: SALIR

**INPUT:**
```
ENTER (para continuar)
6
```

**OUTPUT que DEBERIA VER:**
```
[SALIENDO] Hasta luego!
```

---

## QUE PROBAR CON 3 LIBROS ESPANOLES

Para hacer el video como lo pedi, busca estos 3 libros en este orden:

### LIBRO 1: Don Quijote (ya lo hicimos)
```
Opcion: 1
Titulo: Don Quijote
```

### LIBRO 2: Pride and Prejudice (en ingles, pero disponible)
```
Opcion: 1
Titulo: Pride and Prejudice
Resultado: Deberia encontrarse en Gutendex
```

### LIBRO 3: Alice in Wonderland
```
Opcion: 1
Titulo: Alice in Wonderland
Resultado: Deberia encontrarse en Gutendex
```

Luego:
```
Opcion: 2  → Ver los 3 libros
Opcion: 3  → Ver los autores
Opcion: 4  → Buscar por fecha (ej: 1850)
Opcion: 5  → Filtrar por idioma (es, en)
Opcion: 6  → Salir
```

---

## PROBLEMAS COMUNES

### No conecta a PostgreSQL
```
ERROR: Connection to localhost:5432 refused
SOLUCION: Inicia PostgreSQL primero
```

### Libro no encontrado en Gutendex
```
ERROR: No encontrado en Gutendex
RAZON: Gutendex solo tiene libros de dominio publico (clasicos)
PRUEBA: Don Quijote, Pride and Prejudice, Alice in Wonderland, 1984
```

### Caracteres raros en lugar de letras (a├▒o)
```
RAZON: Problema de encoding en PowerShell
SOLUCION: Ya debe estar arreglado - usa caracteres ASCII
```

---

## ENTENDER EL CODIGO

### Carpeta /src/main/java/com/alura/literalura/
```
LiterAluraApplication.java  ← MAIN (el menu y toda la app)
  ├─ buscarLibro()         ← Opcion 1
  ├─ listarTodosLibros()   ← Opcion 2
  ├─ listarTodosAutores()  ← Opcion 3
  ├─ listarAutoresVivos()  ← Opcion 4
  └─ listarLibrosPorIdioma() ← Opcion 5

/service/
  ├─ ConsultaGutendex.java ← Conecta a API Gutendex
  └─ ConversionDatos.java  ← Convierte DTO a Entidad

/repository/
  ├─ LibroRepository.java  ← Busca libros en BD
  └─ AutorRepository.java  ← Busca autores en BD

/model/
  ├─ Libro.java           ← Entidad (tabla en BD)
  ├─ Autor.java           ← Entidad (tabla en BD)
  ├─ LibroDTO.java        ← Recibe JSON de Gutendex
  └─ AutorDTO.java        ← Recibe JSON de Gutendex
```

### Flujo de 1 busqueda:
```
Usuario escribe: "Don Quijote"
        ↓
ConsultaGutendex.buscarLibros()
        ↓
HttpClient hace GET a: https://gutendex.com/books?search=Don+Quijote
        ↓
Jackson convierte JSON a LibroDTO
        ↓
ConversionDatos.convertirDTOaLibro() → Libro.java
        ↓
LibroRepository.save(libro) → Guarda en PostgreSQL
        ↓
Usuario ve: "[OK] Guardado en la BD"
```

---

## REQUISITOS ALURA (13 FUNCIONANDO)

✅ 1. API Gutendex integrada           (ConsultaGutendex.java)
✅ 2. Guardar en PostgreSQL             (libroRepository.save())
✅ 3. Listar libros                     (Opcion 2)
✅ 4. Listar autores                    (Opcion 3)
✅ 5. Autores vivos en una fecha        (Opcion 4)
✅ 6. Filtrar por idioma                (Opcion 5)
✅ 7. Menu interactivo                  (6 opciones)
✅ 8. Interfaz en consola               (Scanner)
✅ 9. HttpClient para API               (ConsultaGutendex)
✅ 10. DTOs con Jackson                 (LibroDTO, AutorDTO)
✅ 11. Entidades JPA                    (Libro, Autor)
✅ 12. Base de datos PostgreSQL         (application.properties)
✅ 13. Busqueda case-insensitive        (findByTituloIgnoreCase)

---

## COMANDOS UTILES

| Comando | Que hace |
|---------|----------|
| `mvn clean` | Limpia /target |
| `mvn compile` | Solo compila |
| `mvn clean spring-boot:run` | Limpia y ejecuta |
| `mvn test` | Ejecuta tests (no hay) |

---

**Ya esta todo limpio, sin codigo innecesario, y sin problemas de encoding. 
Ahora puedes probar paso a paso cada requisito.**
