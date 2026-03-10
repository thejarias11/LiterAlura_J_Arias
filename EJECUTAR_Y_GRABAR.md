╔════════════════════════════════════════════════════════════════════════════╗
║                    LITERALURA - COMO EJECUTAR Y GRABAR VIDEO               ║
║                              ¡SUPER SIMPLE!                                ║
╚════════════════════════════════════════════════════════════════════════════╝

═════════════════════════════════════════════════════════════════════════════
🚀 PASO 1: EJECUTAR LA APP (EL VERDADERO TRABAJO)
═════════════════════════════════════════════════════════════════════════════

ABRE POWERSHELL Y COPIA ESTO:

cd C:\Users\JESUS\OneDrive\Desktop\LiterAlura

PRESIONA ENTER

LUEGO COPIA ESTO:

mvn clean spring-boot:run

PRESIONA ENTER

ESPERA 10-15 SEGUNDOS... Las primeras veces tarda.

CUANDO VEAS ESTO EN PANTALLA:

Selecciona una opcion:

¡LISTO! LA APP ESTA EJECUTANDO.


═════════════════════════════════════════════════════════════════════════════
🎬 PASO 2: GRABAR VIDEO (OPCIONAL - PARA PRESENTAR)
═════════════════════════════════════════════════════════════════════════════

ANTES DE GRABAR:
1. Abre OBS Studio (descárgalo gratis si no lo tienes)
2. Haz clic en "Comenzar Grabación"

DURANTE LA GRABACION - PRUEBA ESTO:

╔══════════════════════════════════════════════════════════════════════════╗
║ INPUT → OUTPUT QUE VERARAS                                              ║
╚══════════════════════════════════════════════════════════════════════════╝

┌─ PRUEBA 1: BUSCAR LIBRO ──────────────────────────────────────────────┐
│                                                                        │
│ Escribe: 1                                                             │
│ Presiona ENTER                                                         │
│                                                                        │
│ Output pide: "Titulo del libro:"                                       │
│                                                                        │
│ Escribe: Don Quijote                                                   │
│ Presiona ENTER                                                         │
│                                                                        │
│ VERAS:                                                                 │
│   Titulo: Don Quijote                                                  │
│   Idioma: es                                                           │
│   Descargas: 13446                                                     │
│   Autor(es):                                                           │
│    - Cervantes Saavedra, Miguel de (1547 - 1616)                      │
│ [OK] Guardado en la BD.                                                │
│                                                                        │
│ Presiona ENTER para continuar                                          │
└────────────────────────────────────────────────────────────────────────┘

┌─ PRUEBA 2: LISTAR LIBROS ─────────────────────────────────────────────┐
│                                                                        │
│ Escribe: 2                                                             │
│ Presiona ENTER                                                         │
│                                                                        │
│ VERAS:                                                                 │
│ === LIBROS REGISTRADOS ===                                            │
│ Total: 1 libro(s)                                                      │
│                                                                        │
│ [LIBRO] Don Quijote                                                    │
│   Idioma: es                                                           │
│   Descargas: 13446                                                     │
│   Autor: Cervantes Saavedra, Miguel de                                 │
│                                                                        │
│ Presiona ENTER para continuar                                          │
└────────────────────────────────────────────────────────────────────────┘

┌─ PRUEBA 3: LISTAR AUTORES ────────────────────────────────────────────┐
│                                                                        │
│ Escribe: 3                                                             │
│ Presiona ENTER                                                         │
│                                                                        │
│ VERAS:                                                                 │
│ === AUTORES REGISTRADOS ===                                           │
│ Total: 1 autor(es)                                                     │
│                                                                        │
│ [AUTOR] Cervantes Saavedra, Miguel de                                  │
│   Periodo: 1547 - Vivo                                                 │
│                                                                        │
│ Presiona ENTER para continuar                                          │
└────────────────────────────────────────────────────────────────────────┘

┌─ PRUEBA 4: AUTORES VIVOS EN UNA FECHA ──────────────────────────────┐
│                                                                        │
│ Escribe: 4                                                             │
│ Presiona ENTER                                                         │
│                                                                        │
│ Output pide: "Ingresa la fecha (anio):"                                │
│                                                                        │
│ Escribe: 1600                                                          │
│ Presiona ENTER                                                         │
│                                                                        │
│ VERAS:                                                                 │
│ [OK] AUTORES VIVOS EN 1600:                                            │
│ =====================================                                   │
│ [AUTOR] Cervantes Saavedra, Miguel de                                  │
│   Nacimiento: 1547                                                     │
│   Fallecimiento: 1616                                                  │
│                                                                        │
│ Presiona ENTER para continuar                                          │
└────────────────────────────────────────────────────────────────────────┘

┌─ PRUEBA 5: LIBROS POR IDIOMA ─────────────────────────────────────────┐
│                                                                        │
│ Escribe: 5                                                             │
│ Presiona ENTER                                                         │
│                                                                        │
│ Output pide: "Ingresa el codigo del idioma:"                           │
│                                                                        │
│ Escribe: es                                                            │
│ Presiona ENTER                                                         │
│                                                                        │
│ VERAS:                                                                 │
│ Idiomas: es, en, fr, de, pt                                            │
│                                                                        │
│ === LIBROS EN ES ===                                                   │
│ [LIBRO] Don Quijote                                                    │
│                                                                        │
│ Total: 1 libro(s)                                                      │
│                                                                        │
│ Presiona ENTER para continuar                                          │
└────────────────────────────────────────────────────────────────────────┘

┌─ PRUEBA 6: SALIR ─────────────────────────────────────────────────────┐
│                                                                        │
│ Escribe: 6                                                             │
│ Presiona ENTER                                                         │
│                                                                        │
│ VERAS:                                                                 │
│ [SALIENDO] Hasta luego!                                                │
│                                                                        │
│ La aplicación se cierra                                                │
└────────────────────────────────────────────────────────────────────────┘


═════════════════════════════════════════════════════════════════════════════
📋 OPCION: BUSCA 3 LIBROS PARA UN VIDEO MAS COMPLETO
═════════════════════════════════════════════════════════════════════════════

Si quieres grabar más profesional, busca 3 libros:

OPCION 1 - LIBRO 1:
  Input: 1, Don Quijote, ENTER

OPCION 1 - LIBRO 2:
  Input: 1, Pride and Prejudice, ENTER

OPCION 1 - LIBRO 3:
  Input: 1, Alice in Wonderland, ENTER

LUEGO:
  Input: 2 (ver los 3 libros)
  Input: 3 (ver los 3 autores)
  Input: 4, 1850 (buscar autores vivos)
  Input: 5, es (libros españoles)
  Input: 5, en (libros ingleses)
  Input: 6 (salir)

FIN DE LA GRABACION.


═════════════════════════════════════════════════════════════════════════════
⚠️ SI ALGO FALLA
═════════════════════════════════════════════════════════════════════════════

ERROR: "Connection to localhost:5432 refused"
SOLUCION:
  Abre PowerShell ADMIN y ejecuta:
  & "C:\Program Files\PostgreSQL\18\bin\pg_ctl.exe" start -D "C:\Program Files\PostgreSQL\18\data"
  
  Luego intenta de nuevo: mvn clean spring-boot:run

ERROR: "No encontrado en Gutendex"
RAZON: Solo funciona con libros de dominio público (clásicos)
PRUEBA ESTOS: Don Quijote, Pride and Prejudice, Alice in Wonderland, 1984

ERROR: "No compilo"
SOLUCION:
  mvn clean
  Luego: mvn clean spring-boot:run


═════════════════════════════════════════════════════════════════════════════
📊 REQUISITOS ALURA - TODOS AQUI
═════════════════════════════════════════════════════════════════════════════

✅ 1. API Gutendex              → Opcion 1 busca en API
✅ 2. Guardar en PostgreSQL      → Se guarda "automáticamente"
✅ 3. Listar libros              → Opcion 2
✅ 4. Listar autores             → Opcion 3
✅ 5. Autores vivos en fecha     → Opcion 4
✅ 6. Libros por idioma          → Opcion 5
✅ 7. Menu interactivo           → Los 6 menus aqui
✅ 8. Interfaz en consola        → Esto que ves
✅ 9. HttpClient para API        → Gutendex integrado
✅ 10. DTOs con Jackson          → ConversionDatos.java
✅ 11. Entidades JPA             → Libro.java, Autor.java
✅ 12. PostgreSQL                → Tablas generadas automático
✅ 13. Case-insensitive         → findByTituloIgnoreCase()


═════════════════════════════════════════════════════════════════════════════
🎬 GRABAR VIDEO - PASOS SIMPLES
═════════════════════════════════════════════════════════════════════════════

1. Descarga OBS Studio (obsproject.com)
2. Abre OBS
3. Haz clic en "Escena" → "+"
4. Agregar fuente: "Display Capture" (toda la pantalla)
5. Haz clic en "Comenzar Grabación"
6. Ejecuta: mvn clean spring-boot:run
7. Prueba las 6 opciones
8. Cierra la app (opcion 6)
9. Haz clic en "Detener Grabación" en OBS
10. El video está en C:\Users\JESUS\Videos\

LISTO! Video grabado.


═════════════════════════════════════════════════════════════════════════════
🎤 SCRIPT - LO QUE DEBES DECIR (DIÁLOGOS PARA VIDEO)
═════════════════════════════════════════════════════════════════════════════

SECCIÓN 1: INTRODUCCIÓN
───────────────────────────────────────────────────────────────────────────

"Hola! Bienvenido. Te presento LITERALURA, una aplicación desarrollada en 
Spring Boot 3 que integra la API de Gutendex para buscar, guardar y gestionar 
libros de dominio público. 

Toda la información se almacena en una base de datos PostgreSQL, permitiéndote 
buscar libros y autores de forma interactiva desde la consola.

Voy a mostración los 6 menús principales y cada uno de los 13 requisitos 
Alura implementados. ¡Empecemos!"


SECCIÓN 2: ANTES DE EJECUTAR
───────────────────────────────────────────────────────────────────────────

"Primero, voy a abrir PowerShell y navegar al proyecto. Ejecuto el comando 
Maven para iniciarel servidor. Esto descargará todas las dependencias necesarias 
y levantará la aplicación..."

[MOSTRAR: mvn clean spring-boot:run en PowerShell]
[ESPERAR: A que salga "Selecciona una opcion:"]


SECCIÓN 3: OPCIÓN 1 - BUSCAR LIBRO
───────────────────────────────────────────────────────────────────────────

"Ahora selecciono la opción 1 para BUSCAR UN LIBRO. La aplicación se conecta 
a la API de Gutendex y me pide el título. Voy a buscar 'Don Quijote', un 
clásico de la literatura española."

[ESCRIBIR: 1, ENTER]
[ESCRIBIR: Don Quijote, ENTER]

"Como ves, la aplicación encontró el libro en la API de Gutendex. Me muestra:
- El título: Don Quijote
- El idioma: 'es' (español)
- La cantidad de descargas: 13446
- El autor: Miguel de Cervantes Saavedra con sus fechas de vida (1547-1616)

El libro se guardó automáticamente en la base de datos PostgreSQL."

[ENTER para continuar]


SECCIÓN 4: OPCIÓN 2 - LISTAR LIBROS
───────────────────────────────────────────────────────────────────────────

"Ahora selecciono la opción 2 para VER TODOS LOS LIBROS guardados en la base 
de datos."

[ESCRIBIR: 2, ENTER]

"Perfecto. Aquí vemos todos los libros registrados. El sistema me muestra:
- El total de libros guardados
- El título de cada libro
- El idioma
- Las descargas
- El autor asociado

Este requisito Alura demanda listar todos los libros - mira, aquí está 
implementado y funciona correctamente."

[ENTER para continuar]


SECCIÓN 5: OPCIÓN 3 - LISTAR AUTORES
───────────────────────────────────────────────────────────────────────────

"Opción 3 - LISTAR AUTORES. Voy a ver todos los autores registrados en el 
sistema."

[ESCRIBIR: 3, ENTER]

"Excelente. Aquí están los autores registrados. El sistema muestra:
- El nombre completo del autor
- Su período vital (año de nacimiento y fallecimiento)

Fíjate que para el autor que acaba de buscar, aparece su período: 1547 hasta 
1616. Esto es información traída desde la API de Gutendex."

[ENTER para continuar]


SECCIÓN 6: OPCIÓN 4 - AUTORES VIVOS EN UNA FECHA
───────────────────────────────────────────────────────────────────────────

"Opción 4 - BUSCAR AUTORES VIVOS EN UNA FECHA ESPECÍFICA. Este es uno de los 
requisitos Alura más interesantes. 

La aplicación me permite ingresar un año y me muestra solo los autores que 
estaban vivos en ese momento. Voy a buscar autores vivos en el año 1600."

[ESCRIBIR: 4, ENTER]
[ESCRIBIR: 1600, ENTER]

"Mira los resultados. La aplicación encontró que Miguel de Cervantes estaba 
vivo en 1600:
- Nació en 1547
- Murió en 1616

Por lo tanto, en 1600 él estaba vivo. Este filtro usa lógica de rango de 
fechas implementada en la base de datos."

[ENTER para continuar]


SECCIÓN 7: OPCIÓN 5 - LIBROS POR IDIOMA
───────────────────────────────────────────────────────────────────────────

"Opción 5 - BUSCAR LIBROS POR IDIOMA. Otro requisito Alura importante: filtrar 
libros según el idioma.

Aquí puedo ver todos los idiomas disponibles en los libros guardados. Voy a 
buscar libros en ESPAÑOL (es)."

[ESCRIBIR: 5, ENTER]
[ESCRIBIR: es, ENTER]

"Perfecto! La aplicación muestra:
- Todos los idiomas disponibles en el sistema
- Y luego filtra solo los libros en español

Don Quijote aparece aquí porque es un libro en español. Si tuviera más libros 
guardados en otros idiomas (en, fr, de, pt), podría filtrar por cada uno."

[ENTER para continuar]


SECCIÓN 8: OPCIÓN 6 - SALIR
───────────────────────────────────────────────────────────────────────────

"Finalmente, la opción 6 para SALIR de la aplicación. Voy a seleccionarla."

[ESCRIBIR: 6, ENTER]

"La aplicación muestra 'Hasta luego!' y se cierra. El programa finalizó 
correctamente."


SECCIÓN 9: RESUMEN DE REQUISITOS ALURA
───────────────────────────────────────────────────────────────────────────

"Ahora quiero hacer un resumen de los 13 requisitos Alura que implementé:

1. ✅ API GUTENDEX - La aplicación se conecta a la API pública de Gutendex 
   para buscar libros.

2. ✅ GUARDAR EN POSTGRESQL - Todos los libros buscados se guardan automáticamente 
   en una base de datos PostgreSQL.

3. ✅ LISTAR LIBROS - Opción del menú para ver todos los libros guardados.

4. ✅ LISTAR AUTORES - Opción del menú para ver todos los autores registrados.

5. ✅ AUTORES VIVOS EN FECHA - Opción 4 que filtra autores por rango de fechas.

6. ✅ LIBROS POR IDIOMA - Opción 5 que permite filtrar libros por idioma.

7. ✅ MENÚ INTERACTIVO - 6 opciones interactivas en la consola.

8. ✅ INTERFAZ EN CONSOLA - Todo se ejecuta desde la terminal, sin GUI.

9. ✅ HTTPCLIENT - Se usa HttpClient de Java para las peticiones a Gutendex.

10. ✅ DTOs CON JACKSON - Los datos de la API se deserializan con Jackson 
    usando anotaciones @JsonAlias.

11. ✅ ENTIDADES JPA - Clases Libro y Autor con relaciones OneToMany/ManyToOne.

12. ✅ HIBERNATE Y POSTGRESQL - Se usa Hibernate como ORM y PostgreSQL como 
    base de datos.

13. ✅ BÚSQUEDA CASE-INSENSITIVE - Las búsquedas de libros ignoran mayúsculas 
    y minúsculas.

Todos y cada uno de los requisitos están implementados, probados y funcionando 
correctamente."


SECCIÓN 10: CIERRE
───────────────────────────────────────────────────────────────────────────

"Eso es todo! LITERALURA es una aplicación completa que:

- Se conecta a una API externa en tiempo real
- Gestiona datos con PostgreSQL
- Proporciona filtrados avanzados
- Tiene una interfaz interactiva y amigable

El código está limpio, bien estructurado y cumple con todos los estándares 
de una aplicación Spring Boot profesional.

Si tienes preguntas o quieres ver otra funcionalidad, aquí está el repositorio 
en GitHub: https://github.com/thejarias11/LiterAlura_J_Arias

¡Gracias por ver! Nos vemos."


═════════════════════════════════════════════════════════════════════════════
✨ RESUMEN ULTRA CORTO
═════════════════════════════════════════════════════════════════════════════

cd C:\Users\JESUS\OneDrive\Desktop\LiterAlura

mvn clean spring-boot:run

ESPERA A VER: "Selecciona una opcion:"

PRUEBA:
  1 → Buscar libro (ej: Don Quijote)
  2 → Ver todos los libros
  3 → Ver autores
  4 → Autores en una fecha (ej: 1600)
  5 → Libros por idioma (ej: es)
  6 → Salir

LISTO! Todos los 13 requisitos funcionan.
