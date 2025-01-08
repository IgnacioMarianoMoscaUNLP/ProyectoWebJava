# Requisitos Previos
Tener MySQL instalado en tu máquina local y de que el servicio esté en ejecución.
También se puede hacer con xampp. Se crea la bd "que_comemos" y ejecuta la query.

1. Abrir la Terminal de MySQL Local
   - Abrir tu terminal 
   - Inicia sesión en MySQL con el comando:
     mysql -u root -p
     
   - Ingresar usuario y contraseña de MySQL.

2.Crear la Base de Datos y el Usuario
   - Copia y pega 
   
   CREATE DATABASE que_comemos;

   CREATE USER 'usuario1'@'localhost' IDENTIFIED BY 'contraseña1';

   GRANT ALL PRIVILEGES ON que_comemos.* TO 'usuario1'@'localhost';

   FLUSH PRIVILEGES;
