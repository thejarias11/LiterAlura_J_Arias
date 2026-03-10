# Script para probar todas las funcionalidades de LiterAlura
# Este script simula la entrada del usuario en las opciones del menú

Write-Host "================================" -ForegroundColor Cyan
Write-Host "INICIANDO PRUEBAS DE LITERALURA" -ForegroundColor Cyan
Write-Host "================================" -ForegroundColor Cyan
Write-Host ""

# Esperar a que el usuario presione una tecla para empezar
Write-Host "INSTRUCCIONES DE PRUEBA MANUAL:" -ForegroundColor Yellow
Write-Host ""
Write-Host "1. La aplicación está compilada y lista para ejecutar"
Write-Host "2. NO CIERRES ESTA VENTANA - entrarás en el menú interactivo"
Write-Host ""
Write-Host "PRUEBAS QUE DEBES REALIZAR:" -ForegroundColor Yellow
Write-Host ""
Write-Host "  [Opción 1] Buscar un libro por título"
Write-Host "    - Ingresa: Pride and Prejudice"
Write-Host "    - Debe: Encontrar el libro en Gutendex y guardarlo"
Write-Host ""
Write-Host "  [Opción 2] Listar todos los libros"
Write-Host "    - Debe: Mostrar 'Pride and Prejudice' en la lista"
Write-Host ""
Write-Host "  [Opción 3] Listar autores"
Write-Host "    - Debe: Mostrar 'Jane Austen' con nacimiento/muerte"
Write-Host ""
Write-Host "  [Opción 4] Autores vivos en un año"
Write-Host "    - Ingresa: 1800"
Write-Host "    - Debe: Mostrar 'Jane Austen (1775-1817)'"
Write-Host ""
Write-Host "  [Opción 5] Filtrar libros por idioma"
Write-Host "    - Ingresa: en"
Write-Host "    - Debe: Mostrar 'Pride and Prejudice' (en inglés)"
Write-Host ""
Write-Host "  [Opción 6] Salir"
Write-Host "    - Debe: Terminar la aplicación correctamente"
Write-Host ""
Write-Host "VERIFICAR:" -ForegroundColor Yellow
Write-Host "  ✓ NO hay símbolos ????? en ninguna salida"
Write-Host "  ✓ Los caracteres especiales se ven correctamente"
Write-Host "  ✓ Los datos persisten en PostgreSQL"
Write-Host ""
Write-Host "Presiona Enter para iniciar la aplicación..." -ForegroundColor Green
Read-Host

Write-Host ""
Write-Host "Ejecutando: mvn clean compile spring-boot:run" -ForegroundColor Cyan
Write-Host ""

cd 'C:\Users\JESUS\OneDrive\Desktop\LiterAlura'
mvn clean compile spring-boot:run
