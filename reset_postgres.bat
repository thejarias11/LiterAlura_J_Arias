@echo off
REM Script para resetear la contraseña de PostgreSQL

echo Parando PostgreSQL...
net stop postgresql-x64-18

echo Esperando 3 segundos...
timeout /t 3

echo Iniciando PostgreSQL en modo single-user...
"C:\Program Files\PostgreSQL\18\bin\postgres.exe" --single -D "C:\Program Files\PostgreSQL\18\data" postgres

REM Una vez en el prompt de single-user, ejecuta:
REM ALTER USER postgres WITH PASSWORD 'admin123';
REM \q

pause
