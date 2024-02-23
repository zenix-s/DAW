User
En esta práctica se presenta al alumno dos aplicaciones con una serie de requisitos. En función
de estos, el alumno debe determinar que servidor debe montar para que se puedan desplegar
las distintas aplicaciones.

1. Aplicación desarrollada mediante,

- Lenguaje de front  HTML5, CSS3, Javascript.
- Lenguaje de back  PHP.
- Base de datos relacionada  gestor MySQL.

2. Aplicación desarrollada mediante,

- Lenguaje de front  HTML5, CSS3, Javascript.
- Lenguaje de back  Java.
- Base de datos relacionada  gestor MySQL.
  El alumno debe,

1. Definir que servidor debe montar en función de los lenguajes utilizados en el desarrollo
   de las aplicaciones.
2. Indicar los pasos que debe dar para poder implementar dicho servidor.
   El servidor creado, debe tener todas las funcionabilidades, desde poder subir ficheros,
   hasta poder establecer una conexión para ver que aplicación se ha desplegado.
3. Crear un servidor real para cada aplicación. Debe obtener distintas imágenes o
   pantallazos donde se muestre comando utilizado para poder dar dicha funcionabilidad.
   Para dicha práctica NO se podrá utilizar software como, por ejemplo, XAMPP, WAMP

# Ad-2 Servidores

## Aclaraciones

Para la realización de esta práctica se ha utilizado una máquina virtual con sistema Debian 12.
En orden de simular un equipo real, se esta usando de Network settings `Bridged Adapter` para que la máquina tenga su propia ip en la red.

- Nombre de la máquina: `debianServer`
- Usuario: `usr`
- Contraseña: `password`

Durante la instalación del sistema no se han instalado ni entornos gráficos ni programas adicionales.

Se ha creado un usuario llamado `usr`

## Sistema

### Especificaciones

Sistema Debian 12

- 2Gb RAM
- 2 CPU

### Configuración base

1. Se inicia sesión con el usuario `root`

2. Se actualiza el sistema con el comando

```bash
apt update && apt upgrade -y
```

3. Se instalan los programas base con el comando

```bash
apt install -y sudo vim net-tools passwd
```

4. Se dan permisos de sudo al usuario `usr` con el comando

```bash
usermod -aG sudo usr
```

5. Iniciar sesión con el usuario `usr` y comprobar que tiene permisos de sudo con el comando

```bash
su - usr
sudo echo "hola"
```

### Firewall

1. Instalar el firewall con el comando

```bash
sudo apt install -y ufw
```

2. Habilitar el firewall con el comando

```bash
sudo ufw enable
```

### Servicio SSH

1. Instalar el servidor SSH con el comando

```bash
sudo apt install -y openssh-server
```

2. Comprobar que el servicio esta activo con el comando

```bash
sudo systemctl status ssh
```

3. Añadir una regla al firewall para permitir el tráfico SSH con el comando

```bash
sudo ufw allow OpenSSH
sudo ufw allow ssh
sudo ufw reload
```

4. Conectar por SSH desde el equipo local con el comando

```bash
ssh -p 22 user@ip
```

### Servicio FTP

1. Instalar el servidor FTP con el comando

```bash
sudo apt install -y vsftpd ftp
```

2. Añadir una regla al firewall para permitir el tráfico FTP con el comando

```bash
sudo ufw allow ftp
sudo ufw allow 20/tcp
sudo ufw allow 21/tcp
sudo ufw reload
```

3. Comprobar que el servicio esta activo con el comando

```bash
sudo systemctl status vsftpd
```

## Aplicación 1

### Tecnologias

- Lenguaje de front
  - HTML5
  - CSS3
  - Javascript
- Lenguaje de back
  - PHP
- BBDD
  - MySql

### Instalación

#### Servidor Apache

1. Instalar el servidor Apache con el comando

```bash
sudo apt install -y apache2
```

2. Comprobar que el servicio esta activo con el comando

```bash
sudo systemctl status apache2
```

3. Añadir una regla al firewall para permitir el tráfico HTTP con el comando

```bash
sudo ufw allow http
sudo ufw allow 80/tcp
sudo ufw reload
```

4. Acceder a la ip de la máquina virtual desde el navegador para comprobar que el servidor esta activo

#### PHP

1. Instalar el lenguaje de programación PHP con el comando

```bash
sudo apt install -y php libapache2-mod-php
```

2. Comprobar que php se ha instalado correctamente

- Crear un archivo `phpinfo.php` en el directorio `/var/www/html` con el comando

```bash
sudo echo "<?php phpinfo(); ?>" | sudo tee /var/www/html/phpinfo.php
```

- Acceder a la ip de la máquina virtual desde el navegador y añadir `/phpinfo.php` para comprobar que php esta activo

3. Habilitar el módulo de Apache para PHP con el comando

```bash
sudo a2enmod php
```

#### MySql

1. Instalar el gestor de base de datos MySql con el comando

```bash
sudo apt install -y mariadb-server
sudo mysql_secure_installation
```

2. Acceder a MySql con el comando

```bash
sudo mysql
```

3. Configurar el usuario para la base de datos

```sql
CREATE USER 'username'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON *.* TO 'username'@'localhost' WITH GRANT OPTION;
exit
```

4. Acceder a MySql con el usuario creado

```bash
mysql -u username -p
```

5. Crear una base de datos para la aplicación

```sql
CREATE DATABASE app1;
```

6. Crear una tabla para la aplicación

```sql
USE app1;
CREATE TABLE tareas (id INT AUTO_INCREMENT PRIMARY KEY, tarea VARCHAR(100), fecha DATE);
INSERT INTO tareas (tarea, fecha) VALUES ('tarea1', '2022-12-31');
INSERT INTO tareas (tarea, fecha) VALUES ('tarea2', '2022-12-31');
INSERT INTO tareas (tarea, fecha) VALUES ('tarea3', '2022-12-31');
```

7. Reiniciar el servidor Apache con el comando

```bash
sudo systemctl restart apache2
```

#### PhpMyAdmin

1. Instalar el gestor de base de datos PhpMyAdmin con el comando

```bash
sudo apt install -y phpmyadmin
```

2. Crear un enlace para poder acceder a phpmyadmin desde el servidor web

```bash
sudo ln -s /usr/share/phpmyadmin /var/www/html/phpmyadmin
```

3. Habilitar el módulo de Apache para PHP con el comando

```bash
sudo phpenmod mbstring
sudo phpenmod mysqli
```

4. Reiniciar apache para aplicar los cambios

```bash
sudo service apache2 restart
```

#### Configuración ftp para subir archivos a la aplicación

Ya tenemos instalado el servidor ftp, ahora vamos a configurar el acceso a la aplicación.

1. Dar permisos de escritura al directorio `/var/www/html` con el comando

```bash
sudo chmod 777 /var/www/html
sudo chown -R usr /var/www/html
```

2. Asegurarse que en el archivo `/etc/vsftpd.conf` tiene la siguiente configuración

```bash
local_umask=022jjjh
write_enable=YES
local_root=/var/www/html
chroot_local_user=YES
```

#### Crear aplicación

1. Crear el directorio de la aplicación en el directorio `/var/www/html` con el comando

```bash
sudo mkdir /var/www/html/app1
```

##### Opción 1 - Editar archivos desde el servidor

2. Crear el archivo `index.php` en el directorio `/var/www/html/app1` con el comando

```bash
sudo echo "<?php echo 'hola'; ?>" | sudo tee /var/www/html/app1/index.php
```

3. Acceder a la ip de la máquina virtual desde el navegador y añadir `/app1` para comprobar que la aplicación esta activa

4. Modificar el archivo `index.php` para que se conecte a la base de datos

```php
<?php
$servername = "localhost";
$username = "username";
$password = "password";
$dbname = "app1";

$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
	die("Connection failed: " . $conn->connect_error);
}

$sql = "SELECT id, tarea, fecha FROM tareas";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
	echo "<table><tr><th>ID</th><th>Tarea</th><th>Fecha</th></tr>";
	while($row = $result->fetch_assoc()) {
		echo "<tr><td>" . $row["id"]. "</td><td>" . $row["tarea"]. "</td><td>" . $row["fecha"]. "</td></tr>";
	}
	echo "</table>";
} else {
	echo "0 results";
}

$conn->close();

?>
```

##### Opción 2 - Subir archivos desde el equipo local usando ftp

1. Conectar por ftp desde el equipo local con filezilla

- Host: ip de la máquina virtual
- Usuario: usr
- Contraseña: password
- Puerto: 21

2. Subir el archivo `index.php` al directorio `/var/www/html/app1`

3. Acceder a la ip de la máquina virtual desde el navegador y añadir `/app1` para comprobar que la aplicación esta activa

## Aplicación 2

### Tecnologias

- Lenguaje de front
  - HTML5
  - CSS3
  - Javascript
- Lenguaje de back
  - Java
- BBDD
  - MySql
- Servidor de aplicaciones
  - Tomcat

### Instalación

#### Servidor Tomcat

1. Instalar el servidor Tomcat con el comando

```bash
sudo apt install -y tomcat10 tomcat10-admin tomcat10-common tomcat10-user tomcat10-docs tomcat10-examples
```

2. Comprobar que el servicio esta activo con el comando

```bash
sudo systemctl status tomcat10
```

3. Añadir una regla al firewall para permitir el tráfico HTTP con el comando

```bash
sudo ufw allow 8080/tcp

sudo ufw reload
```

4. Acceder a la ip de la máquina virtual desde el navegador y añadir `:8080` para comprobar que el servidor esta activo

#### MySql

1. Instalar el gestor de base de datos MySql con el comando

```bash
sudo apt install -y mariadb-server
sudo mysql_secure_installation
```

2. Acceder a MySql con el comando

```bash
sudo mysql
```

3. Configurar el usuario para la base de datos

```sql
CREATE USER 'username'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON *.* TO 'username'@'localhost' WITH GRANT OPTION;
exit
```

4. Acceder a MySql con el usuario creado

```bash
mysql -u username -p
```

5. Crear una base de datos para la aplicación

```sql
CREATE DATABASE app2;
```

6. Crear una tabla para la aplicación

```sql
USE app2;
CREATE TABLE tareas (id INT AUTO_INCREMENT PRIMARY KEY, tarea VARCHAR(100), fecha DATE);
INSERT INTO tareas (tarea, fecha) VALUES ('tarea1', '2022-12-31');
INSERT INTO tareas (tarea, fecha) VALUES ('tarea2', '2022-12-31');
INSERT INTO tareas (tarea, fecha) VALUES ('tarea3', '2022-12-31');
```

#### Configuración ftp para subir archivos a la aplicación

Ya tenemos instalado el servidor ftp, ahora vamos a configurar el acceso a la aplicación.

1. Dar permisos de escritura al directorio `/var/lib/tomcat10/webapps` con el comando

```bash
sudo chmod 777 /var/lib/tomcat10/webapps
sudo chown -R usr /var/lib/tomcat10/webapps
```

2. Asegurarse que en el archivo `/etc/vsftpd.conf` tiene la siguiente configuración

```bash
local_umask=022
write_enable=YES
local_root=/var/lib/tomcat10/webapps
chroot_local_user=YES
```

#### Crear aplicación

1. Crear el directorio de la aplicación en el directorio `/var/lib/tomcat10/webapps` con el comando

```bash
sudo mkdir /var/lib/tomcat10/webapps/app2
```

##### Opción 1 - Editar archivos desde el servidor

2. Crear el archivo `index.jsp` en el directorio `/var/lib/tomcat10/webapps/app2` con el comando

```bash
sudo echo "<!DOCTYPE html>
<html>
<head>
    <title>Sum Calculator</title>
</head>
<body>
    <h2>Sum Calculator</h2>
    <form action="calculate.jsp" method="post">
        Enter number 1: <input type="text" name="num1"><br>
        Enter number 2: <input type="text" name="num2"><br>
        <input type="submit" value="Calculate Sum">
    </form>
</body>
</html>" | sudo tee /var/lib/tomcat10/webapps/app2/index.jsp

sudo echo "<!DOCTYPE html>
<html>
<head>
    <title>Sum Calculator</title>
</head>
<body>
    <h2>Sum Calculator</h2>
    <form action="calculate.jsp" method="post">
        Enter number 1: <input type="text" name="num1"><br>
        Enter number 2: <input type="text" name="num2"><br>
        <input type="submit" value="Calculate Sum">
    </form>
</body>
</html>

root@debianServer:/var/lib/tomcat10/webapps/app2# cat calculate.jsp
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="javax.servlet.*,javax.servlet.http.*" %>

<%
    // Get parameters from the form
    String num1Str = request.getParameter("num1");
    String num2Str = request.getParameter("num2");

    // Convert parameters to integers
    int num1 = Integer.parseInt(num1Str);
    int num2 = Integer.parseInt(num2Str);

    // Calculate the sum
    int sum = num1 + num2;
%>

<!DOCTYPE html>
<html>
<head>
    <title>Sum Result</title>
</head>
<body>
    <h2>Sum Result</h2>
    <p>Number 1: <%= num1 %></p>
    <p>Number 2: <%= num2 %></p>
    <p>Sum: <%= sum %></p>
</body>
</html>" | sudo tee /var/lib/tomcat10/webapps/app2/calculate.jsp
```

3. Acceder a la ip de la máquina virtual desde el navegador y añadir `/app2` para comprobar que la aplicación esta activa
4. Modificar el archivo `index.jsp` para que se conecte a la base de datos
5. Reiniciar el servidor Tomcat con el comando

```bash

sudo systemctl restart tomcat10
```

##### Opción 2 - Subir archivos desde el equipo local usando ftp

1. Conectar por ftp desde el equipo local con filezilla

- Host: ip de la máquina virtual
- Usuario: usr
- Contraseña: password
- Puerto: 21

2. Subir el archivo `index.jsp` y `calculate.jsp`  al directorio `/var/lib/tomcat10/webapps/app2`

3. Acceder a la ip de la máquina virtual desde el navegador y añadir `/app2` para comprobar que la aplicación esta activa
4. Reiniciar el servidor Tomcat con el comando

```bash

sudo systemctl restart tomcat10
```

