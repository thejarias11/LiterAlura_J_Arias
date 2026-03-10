# 🎯 Guía Completa: PostgreSQL + Video Demo

## 📹 PARTE 1: GRABAR VIDEO DEMO

### Paso 1: Descarga un grabador
Elige uno (todos son gratuitos):
- **Windows 10/11 nativo**: Presiona `Win + G` (Grabadora de Juegos)
- **OBS Studio**: https://obsproject.com (profesional)
- **ShareX**: https://getsharex.com (simple)

### Paso 2: Graba tu demo (2-3 minutos)
```
✅ Muestra el menú principal
✅ Busca "Pride and Prejudice"
✅ Muestra el resultado encontrado
✅ Opción 2: Lista todos los libros
✅ Opción 3: Lista autores
✅ Opción 5: Filtra por idioma "en"
✅ Cierra elegantemente con opción 6
```

### Paso 3: Sube a YouTube
1. Ve a https://youtube.com
2. Click arriba a la derecha → "Crear" → "Subir un video"
3. Sube tu video
4. Título: "LiterAlura - Catálogo de Libros"
5. Descripción: Pega el link de tu GitHub
6. **Importante**: Privacidad = "No listado" (solo quien tenga el link)
7. Publica
8. Copia el link: `https://youtu.be/AQUI_TA_CODIGO`

### Paso 4: Actualiza tu README
En el archivo `README.md`, cambia esta línea:
```markdown
**[VER DEMOSTRACIÓN](https://youtu.be/ejemplo)** - Aquí va el enlace a tu video demo
```

Por tu URL real:
```markdown
**[VER DEMOSTRACIÓN](https://youtu.be/tu_codigo_real)** - Demo en vivo de LiterAlura
```

---

## 🔧 PARTE 2: CONFIGURAR POSTGRESQL

### Opción A: Usar pgAdmin (MÁS FÁCIL - RECOMENDADO)

#### Paso 1: Abre pgAdmin
- En Windows: Busca "pgAdmin" en el menú Inicio
- Se abrirá en tu navegador: `http://localhost:5050`

#### Paso 2: Login inicial
- Si es la primera vez:
  - Email: `postgres@example.com` (o el que hayas puesto)
  - Password: `postgres` (o la que pusiste)

#### Paso 3: Crea el servidor PostgreSQL
1. Click en "Add New Server"
2. **General tab:**
   - Name: `PostgreSQL 16 Local`
   - Comment: `Mi base de datos local`

3. **Connection tab:**
   - Host: `localhost`
   - Port: `5432`
   - Username: `postgres`
   - Password: `postgres`
   - Save Password: ✅ Sí

4. Click "Save"

#### Paso 4: Cambia la contraseña del usuario postgres
1. Expande el árbol: Servers → PostgreSQL 16 Local → Login/Group Roles
2. Click derecho en `postgres`
3. Properties
4. Definition tab
5. Password: Pon una contraseña que recuerdes (ej: `admin123`)
6. Click "Save"

#### Paso 5: Crea la BD literalura
1. Click derecho en "Databases"
2. Create → Database
3. **General tab:**
   - Database: `literalura`
   - Owner: `postgres`
   - Encoding: `UTF8`

4. Click "Save"

#### Paso 6: Configura la aplicación
Edita `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/literalura
spring.datasource.username=postgres
spring.datasource.password=admin123
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=create-drop
```

#### Paso 7: Ejecuta la app
```bash
$env:JAVA_HOME = "C:\Program Files\Java\jdk-17"
cd C:\Users\JESUS\OneDrive\Desktop\LiterAlura
& "$env:USERPROFILE\maven\bin\mvn.cmd" clean compile spring-boot:run
```

---

### Opción B: Línea de comandos (AVANZADO)

Si prefieres no usar pgAdmin:

```powershell
# 1. Cambiar contraseña del usuario postgres
"C:\Program Files\PostgreSQL\16\bin\psql.exe" -U postgres -c "ALTER USER postgres WITH PASSWORD 'admin123';"

# 2. Crear la BD
"C:\Program Files\PostgreSQL\16\bin\psql.exe" -U postgres -c "CREATE DATABASE literalura;"

# 3. Verificar que se creó
"C:\Program Files\PostgreSQL\16\bin\psql.exe" -U postgres -c "\l"
```

---

## ✅ CHECKLIST FINAL

Antes de hacer commit final:

- [ ] Video grabado y subido a YouTube
- [ ] URL del video actualizada en README
- [ ] PostgreSQL configurado con contraseña
- [ ] Base de datos `literalura` creada
- [ ] `application.properties` actualizado con credenciales
- [ ] App ejecutada exitosamente con PostgreSQL
- [ ] Búsqueda de libros funcionando
- [ ] Datos persistiendo en PostgreSQL

---

## 🚀 Comandos finales para hacer commit

```bash
cd C:\Users\JESUS\OneDrive\Desktop\LiterAlura

# Agregar cambios
git add .

# Commit
git commit -m "feat: Add PostgreSQL support and video demo

- Configured PostgreSQL as primary database
- Added video demo to README
- Updated installation documentation
- Added detailed PostgreSQL setup guide"

# Push a GitHub
git push origin main
```

---

## 🆘 Si hay problemas

### "Connection refused" en PostgreSQL
→ Verifica que el servicio esté corriendo:
```powershell
Get-Service | Where-Object {$_.Name -like "*postgres*"}
```
Debe mostrar "Running"

### "Password authentication failed"
→ Cambia la contraseña desde pgAdmin
→ Verifica que esté correcta en `application.properties`

### "Database literalura does not exist"
→ Crea la BD desde pgAdmin
→ Verifica el nombre exacto en `application.properties`

---

¡Éxito, hermano! 💪
