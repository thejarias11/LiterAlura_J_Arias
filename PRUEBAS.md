# Manual de Pruebas - LiterAlura

Para probar la aplicación, ejecuta en la terminal:

```bash
mvn clean compile spring-boot:run
```

## Pruebas a Realizar

### Opción 1: Buscar Libro
- Entrada: Pride and Prejudice
- Resultado esperado: Debe mostrar el libro encontrado en Gutendex
- Verificar: Dato se guarda en PostgreSQL

### Opción 2: Listar Todos los Libros  
- Resultado esperado: Debe mostrar todos los libros buscados
- Verificar: Aparece "Pride and Prejudice"

### Opción 3: Listar Autores
- Resultado esperado: Muestra todos los autores con años
- Verificar: Aparece "Jane Austen" con años (1775-1817)

### Opción 4: Autores Vivos en Año
- Entrada: 1800
- Resultado esperado: Muestra autores vivos en ese año
- Verificar: Jane Austen aparece (vivía en 1800)

### Opción 5: Filtrar por Idioma
- Entrada: en
- Resultado esperado: Muestra libros en inglés
- Verificar: Pride and Prejudice aparece

### Opción 6: Salir
- Resultado esperado: Termina la aplicación
- Verificar: Se cierra correctamente

## Checklist Final

- [ ] Opción 1 funciona (inserta en BD)
- [ ] Opción 2 lista todos los libros
- [ ] Opción 3 lista autores con años
- [ ] Opción 4 filtra por año vivo
- [ ] Opción 5 filtra por idioma
- [ ] Opción 6 sale correctamente
- [ ] NO hay simbolos ????? en la salida
- [ ] Los caracteres especiales se ven correctamente (UTF-8)
