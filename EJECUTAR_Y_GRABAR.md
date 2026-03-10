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
