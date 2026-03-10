╔════════════════════════════════════════════════════════════════════════════╗
║                    LITERALURA - HOW TO EXECUTE AND RECORD VIDEO             ║
║                              ¡SUPER SIMPLE!                                 ║
╚════════════════════════════════════════════════════════════════════════════╝

═════════════════════════════════════════════════════════════════════════════
🚀 STEP 1: EXECUTE THE APP (THE REAL WORK)
═════════════════════════════════════════════════════════════════════════════

OPEN POWERSHELL AND COPY THIS:

cd C:\Users\JESUS\OneDrive\Desktop\LiterAlura

PRESS ENTER

THEN COPY THIS:

mvn clean spring-boot:run

PRESS ENTER

WAIT 10-15 SECONDS... First times takes longer.

WHEN YOU SEE THIS ON SCREEN:

Selecciona una opcion:

¡LISTO! THE APP IS RUNNING.


═════════════════════════════════════════════════════════════════════════════
🎬 STEP 2: RECORD VIDEO (OPTIONAL - FOR PRESENTATION)
═════════════════════════════════════════════════════════════════════════════

BEFORE RECORDING:
1. Open OBS Studio (download it free if you don't have it)
2. Click "Start Recording"

DURING RECORDING - TRY THIS:

╔══════════════════════════════════════════════════════════════════════════╗
║ INPUT → OUTPUT YOU WILL SEE                                             ║
╚══════════════════════════════════════════════════════════════════════════╝

┌─ TEST 1: SEARCH BOOK ─────────────────────────────────────────────────┐
│                                                                        │
│ Write: 1                                                               │
│ Press ENTER                                                            │
│                                                                        │
│ Output asks: "Titulo del libro:"                                       │
│                                                                        │
│ Write: Don Quijote                                                     │
│ Press ENTER                                                            │
│                                                                        │
│ YOU WILL SEE:                                                          │
│   Titulo: Don Quijote                                                  │
│   Idioma: es                                                           │
│   Descargas: 13446                                                     │
│   Autor(es):                                                           │
│    - Cervantes Saavedra, Miguel de (1547 - 1616)                      │
│ [OK] Guardado en la BD.                                                │
│                                                                        │
│ Press ENTER to continue                                                │
└────────────────────────────────────────────────────────────────────────┘

┌─ TEST 2: LIST BOOKS ──────────────────────────────────────────────────┐
│                                                                        │
│ Write: 2                                                               │
│ Press ENTER                                                            │
│                                                                        │
│ YOU WILL SEE:                                                          │
│ === LIBROS REGISTRADOS ===                                            │
│ Total: 1 libro(s)                                                      │
│                                                                        │
│ [LIBRO] Don Quijote                                                    │
│   Idioma: es                                                           │
│   Descargas: 13446                                                     │
│   Autor: Cervantes Saavedra, Miguel de                                 │
│                                                                        │
│ Press ENTER to continue                                                │
└────────────────────────────────────────────────────────────────────────┘

┌─ TEST 3: LIST AUTHORS ────────────────────────────────────────────────┐
│                                                                        │
│ Write: 3                                                               │
│ Press ENTER                                                            │
│                                                                        │
│ YOU WILL SEE:                                                          │
│ === AUTORES REGISTRADOS ===                                           │
│ Total: 1 autor(es)                                                     │
│                                                                        │
│ [AUTOR] Cervantes Saavedra, Miguel de                                  │
│   Periodo: 1547 - Vivo                                                 │
│                                                                        │
│ Press ENTER to continue                                                │
└────────────────────────────────────────────────────────────────────────┘

┌─ TEST 4: AUTHORS ALIVE IN A DATE ─────────────────────────────────────┐
│                                                                        │
│ Write: 4                                                               │
│ Press ENTER                                                            │
│                                                                        │
│ Output asks: "Ingresa la fecha (anio):"                                │
│                                                                        │
│ Write: 1600                                                            │
│ Press ENTER                                                            │
│                                                                        │
│ YOU WILL SEE:                                                          │
│ [OK] AUTORES VIVOS EN 1600:                                            │
│ =====================================                                   │
│ [AUTOR] Cervantes Saavedra, Miguel de                                  │
│   Nacimiento: 1547                                                     │
│   Fallecimiento: 1616                                                  │
│                                                                        │
│ Press ENTER to continue                                                │
└────────────────────────────────────────────────────────────────────────┘

┌─ TEST 5: BOOKS BY LANGUAGE ───────────────────────────────────────────┐
│                                                                        │
│ Write: 5                                                               │
│ Press ENTER                                                            │
│                                                                        │
│ Output asks: "Ingresa el codigo del idioma:"                           │
│                                                                        │
│ Write: es                                                              │
│ Press ENTER                                                            │
│                                                                        │
│ YOU WILL SEE:                                                          │
│ Idiomas: es, en, fr, de, pt                                            │
│                                                                        │
│ === LIBROS EN ES ===                                                   │
│ [LIBRO] Don Quijote                                                    │
│                                                                        │
│ Total: 1 libro(s)                                                      │
│                                                                        │
│ Press ENTER to continue                                                │
└────────────────────────────────────────────────────────────────────────┘

┌─ TEST 6: EXIT ────────────────────────────────────────────────────────┐
│                                                                        │
│ Write: 6                                                               │
│ Press ENTER                                                            │
│                                                                        │
│ YOU WILL SEE:                                                          │
│ [SALIENDO] Hasta luego!                                                │
│                                                                        │
│ The application closes                                                 │
└────────────────────────────────────────────────────────────────────────┘


═════════════════════════════════════════════════════════════════════════════
📋 OPTION: SEARCH 3 BOOKS FOR A MORE COMPLETE VIDEO
═════════════════════════════════════════════════════════════════════════════

If you want to record more professional, search 3 books:

OPTION 1 - BOOK 1:
  Input: 1, Don Quijote, ENTER

OPTION 1 - BOOK 2:
  Input: 1, Pride and Prejudice, ENTER

OPTION 1 - BOOK 3:
  Input: 1, Alice in Wonderland, ENTER

THEN:
  Input: 2 (see the 3 books)
  Input: 3 (see the 3 authors)
  Input: 4, 1850 (search authors alive)
  Input: 5, es (Spanish books)
  Input: 5, en (English books)
  Input: 6 (exit)

END OF RECORDING.


═════════════════════════════════════════════════════════════════════════════
⚠️ IF SOMETHING FAILS
═════════════════════════════════════════════════════════════════════════════

ERROR: "Connection to localhost:5432 refused"
SOLUTION:
  Open PowerShell ADMIN and execute:
  & "C:\Program Files\PostgreSQL\18\bin\pg_ctl.exe" start -D "C:\Program Files\PostgreSQL\18\data"
  
  Then try again: mvn clean spring-boot:run

ERROR: "Not found in Gutendex"
REASON: Only works with public domain books (classics)
TRY THESE: Don Quijote, Pride and Prejudice, Alice in Wonderland, 1984

ERROR: "No compile"
SOLUTION:
  mvn clean
  Then: mvn clean spring-boot:run


═════════════════════════════════════════════════════════════════════════════
📊 ALURA REQUIREMENTS - ALL HERE
═════════════════════════════════════════════════════════════════════════════

✅ 1. Gutendex API              → Option 1 searches in API
✅ 2. Save in PostgreSQL         → Saves "automatically"
✅ 3. List books                 → Option 2
✅ 4. List authors               → Option 3
✅ 5. Authors alive in date      → Option 4
✅ 6. Books by language          → Option 5
✅ 7. Interactive menu           → The 6 menus here
✅ 8. Console interface          → This that you see
✅ 9. HttpClient for API         → Gutendex integrated
✅ 10. DTOs with Jackson         → ConversionDatos.java
✅ 11. JPA entities              → Libro.java, Autor.java
✅ 12. PostgreSQL                → Tables generated automatically
✅ 13. Case-insensitive search   → findByTituloIgnoreCase()


═════════════════════════════════════════════════════════════════════════════
🎬 RECORD VIDEO - SIMPLE STEPS
═════════════════════════════════════════════════════════════════════════════

1. Download OBS Studio (obsproject.com)
2. Open OBS
3. Click "Scene" → "+"
4. Add source: "Display Capture" (full screen)
5. Click "Start Recording"
6. Execute: mvn clean spring-boot:run
7. Test the 6 options
8. Close the app (option 6)
9. Click "Stop Recording" in OBS
10. The video is in C:\Users\JESUS\Videos\

DONE! Video recorded.


═════════════════════════════════════════════════════════════════════════════
🎤 SCRIPT - WHAT YOU SHOULD SAY (DIALOGUE FOR VIDEO)
═════════════════════════════════════════════════════════════════════════════

SECTION 1: INTRODUCTION
───────────────────────────────────────────────────────────────────────────

"Hello! Welcome. Let me introduce you to LITERALURA, an application developed 
in Spring Boot 3 that integrates the Gutendex API to search, save, and manage 
public domain books.

All information is stored in a PostgreSQL database, allowing you to search for 
books and authors interactively from the console.

I'm going to show you the 6 main menus and each of the 13 Alura requirements 
implemented. Let's get started!"


SECTION 2: BEFORE EXECUTING
───────────────────────────────────────────────────────────────────────────

"First, I'm going to open PowerShell and navigate to the project. I'll execute 
the Maven command to start the server. This will download all necessary 
dependencies and launch the application..."

[SHOW: mvn clean spring-boot:run in PowerShell]
[WAIT: For "Selecciona una opcion:" to appear]


SECTION 3: OPTION 1 - SEARCH BOOK
───────────────────────────────────────────────────────────────────────────

"Now I'll select option 1 to SEARCH A BOOK. The application connects to the 
Gutendex API and asks me for the title. I'm going to search for 'Don Quijote', 
a classic of Spanish literature."

[WRITE: 1, ENTER]
[WRITE: Don Quijote, ENTER]

"As you can see, the application found the book in the Gutendex API. It shows me:
- The title: Don Quijote
- The language: 'es' (Spanish)
- The number of downloads: 13446
- The author: Miguel de Cervantes Saavedra with his life dates (1547-1616)

The book was automatically saved to the PostgreSQL database."

[ENTER to continue]


SECTION 4: OPTION 2 - LIST BOOKS
───────────────────────────────────────────────────────────────────────────

"Now I'll select option 2 to SEE ALL THE BOOKS saved in the database."

[WRITE: 2, ENTER]

"Perfect. Here we see all registered books. The system shows me:
- The total number of saved books
- The title of each book
- The language
- The downloads
- The associated author

This Alura requirement demands listing all books - look, here it is 
implemented and working correctly."

[ENTER to continue]


SECTION 5: OPTION 3 - LIST AUTHORS
───────────────────────────────────────────────────────────────────────────

"Option 3 - LIST AUTHORS. I'm going to see all registered authors in the 
system."

[WRITE: 3, ENTER]

"Excellent. Here are the registered authors. The system shows:
- The author's full name
- Their vital period (birth year and death year)

Notice that for the author we just searched for, their period appears: 1547 to 
1616. This is information brought from the Gutendex API."

[ENTER to continue]


SECTION 6: OPTION 4 - AUTHORS ALIVE IN A DATE
───────────────────────────────────────────────────────────────────────────

"Option 4 - SEARCH AUTHORS ALIVE IN A SPECIFIC DATE. This is one of the most 
interesting Alura requirements.

The application allows me to enter a year and shows me only the authors who 
were alive at that time. I'm going to search for authors alive in the year 1600."

[WRITE: 4, ENTER]
[WRITE: 1600, ENTER]

"Look at the results. The application found that Miguel de Cervantes was 
alive in 1600:
- Born in 1547
- Died in 1616

Therefore, in 1600 he was alive. This filter uses date range logic implemented 
in the database."

[ENTER to continue]


SECTION 7: OPTION 5 - BOOKS BY LANGUAGE
───────────────────────────────────────────────────────────────────────────

"Option 5 - SEARCH BOOKS BY LANGUAGE. Another important Alura requirement: 
filtering books by language.

Here I can see all available languages in the saved books. I'm going to search 
for books in SPANISH (es)."

[WRITE: 5, ENTER]
[WRITE: es, ENTER]

"Perfect! The application shows:
- All available languages in the system
- And then filters only books in Spanish

Don Quijote appears here because it's a Spanish book. If I had more books saved 
in other languages (en, fr, de, pt), I could filter by each one."

[ENTER to continue]


SECTION 8: OPTION 6 - EXIT
───────────────────────────────────────────────────────────────────────────

"Finally, option 6 to EXIT the application. I'm going to select it."

[WRITE: 6, ENTER]

"The application shows 'Hasta luego!' and closes. The program finished 
correctly."


SECTION 9: SUMMARY OF ALURA REQUIREMENTS
───────────────────────────────────────────────────────────────────────────

"Now I want to make a summary of the 13 Alura requirements I implemented:

1. ✅ GUTENDEX API - The application connects to the public Gutendex API 
   to search for books.

2. ✅ SAVE IN POSTGRESQL - All searched books are automatically saved 
   in a PostgreSQL database.

3. ✅ LIST BOOKS - Menu option to see all saved books.

4. ✅ LIST AUTHORS - Menu option to see all registered authors.

5. ✅ AUTHORS ALIVE IN DATE - Option 4 filters authors by date range.

6. ✅ BOOKS BY LANGUAGE - Option 5 allows filtering books by language.

7. ✅ INTERACTIVE MENU - 6 interactive options in the console.

8. ✅ CONSOLE INTERFACE - Everything runs from the terminal, no GUI.

9. ✅ HTTPCLIENT - HttpClient of Java is used for requests to Gutendex.

10. ✅ DTOs WITH JACKSON - API data is deserialized with Jackson 
    using @JsonAlias annotations.

11. ✅ JPA ENTITIES - Libro and Autor classes with OneToMany/ManyToOne 
    relationships.

12. ✅ HIBERNATE AND POSTGRESQL - Hibernate is used as ORM and PostgreSQL 
    as database.

13. ✅ CASE-INSENSITIVE SEARCH - Book searches ignore uppercase and 
    lowercase letters.

Each and every one of the requirements is implemented, tested, and working 
correctly."


SECTION 10: CLOSING
───────────────────────────────────────────────────────────────────────────

"That's it! LITERALURA is a complete application that:

- Connects to an external API in real-time
- Manages data with PostgreSQL
- Provides advanced filtering
- Has an interactive and user-friendly interface

The code is clean, well-structured, and meets all standards of a professional 
Spring Boot application.

If you have questions or want to see another feature, here's the repository 
on GitHub: https://github.com/thejarias11/LiterAlura_J_Arias

Thanks for watching! See you soon."


═════════════════════════════════════════════════════════════════════════════
✨ ULTRA SHORT SUMMARY
═════════════════════════════════════════════════════════════════════════════

cd C:\Users\JESUS\OneDrive\Desktop\LiterAlura

mvn clean spring-boot:run

WAIT TO SEE: "Selecciona una opcion:"

TEST:
  1 → Search book (ex: Don Quijote)
  2 → See all books
  3 → See authors
  4 → Authors in a date (ex: 1600)
  5 → Books by language (ex: es)
  6 → Exit

DONE! All 13 requirements work.
