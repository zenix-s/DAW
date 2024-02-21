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

## Sistema

### Distribución

- Sistema Debian 12
  - 2Gb RAM
  - 2 CPU
  - Network settings
    - Bridged Adapter
  - Instlar otros programas
    - servidor web
    - servidor ssh

### Configuración

Se inicia sesión con el usuario `root`

### Comprobaciones

#### Comprobar configuración de red

Ya que la máquina tiene una interfaz de red en modo `Bridged Adapter` la ip se puede obtener con el comando

```bash
ip a
```

Comprobamos la conexión a internet con el comando

```bash
ping google.com
```

#### Actualizar el sistema

```bash
sudo apt-get update && sudo apt-get upgrade
```

#### Instalar paquetes necesarios

```bash
apt-get install sudo vim openssh-server net-tools ufw passwd
```

```bash
adduser username
usermod -aG sudo username

su - username
```

#### Configurar el firewall

```bash
sudo ufw allow OpenSSH
sudo ufw allow ssh
sudo ufw allow http
sudo ufw allow ftp
sudo ufw allow 20/tcp
sudo ufw allow 21/tcp
sudo ufw allow 80/tcp
sudo ufw enable
```

#### conectar por SSH desde el equipo local

- username: nombre de usuario de la máquina virtual
- host: ip de la máquina virtual

```bash
ssh -p 2222 username@host
```

#### Configurar el servicio FTP

Se instala el servidor FTP

- vsftpd: Servidor FTP
- ftp: Cliente FTP

```bash
sudo apt-get install vsftpd ftp
```

Se añade la regla de firewall para el servicio FTP

```bash
sudo ufw allow ftp
sudo ufw allow 20/tcp
sudo ufw allow 21/tcp
```

## Aplicación 1

### Tecnologias

- Front:
  - HTML5
  - CSS3
  - JavaScript
- Back
  - PHP
- BBDD
  - MySql

### Instalación

#### Instalar Paquetes

- apache2: Servidor web HTTP
- php: Lenguaje de programación
- libapache2-mod-php: Módulo de Apache para PHP

```bash
sudo apt-get install apache2 php libapache2-mod-php
```

#### Reiniciar Apache para aplicar cambios

- service: Comando para gestionar servicios

```bash
sudo service apache2 restart
```

#### Verificar la instalación de PHP

```bash
echo "<?php phpinfo(); ?>" | sudo tee /var/www/html/phpinfo.php
```

Si accedemos a `http://localhost:8080/phpinfo.php` deberíamos ver la información de PHP

#### Instalar MySql

```bash
sudo apt install mariadb-server
systemctl status mariadb
sudo mysql_secure_installation
sudo mariadb
MariaDB [(none)]> CREATE USER 'username'@'localhost' IDENTIFIED BY 'password';
MariaDB [(none)]> GRANT ALL PRIVILEGES ON *.* TO 'username'@'localhost' WITH GRANT OPTION;
MariaDB [(none)]> exit

maridb -u username -p



```

#### Instalar PhpMyAdmin

```bash

sudo apt-get install phpmyadmin

```

1. Se selecciona apache2
2. Se selecciona yes para configurar la base de datos
3. Se introduce la contraseña para la base de datos

Se debe crear un enlace para poder acceder a phpmyadmin desde el servidor web

```bash
sudo ln -s /usr/share/phpmyadmin /var/www/html/phpmyadmin
```

phpmyadmin requiere activar varias extensiones de php

```bash
sudo phpenmod mbstring
sudo phpenmod mysqli
```

Reiniciar apache para aplicar los cambios

```bash
sudo service apache2 restart
```

### Configuración

#### Configurar Apache

Nos aseguramos que el archivo de configuración de Apache tenga el siguiente contenido

```bash
sudo vim /etc/apache2/sites-available/000-default.conf
```

```apache
<VirtualHost *:80>
		ServerAdmin webmaster@localhost
		DocumentRoot /var/www/html
		ErrorLog ${APACHE_LOG_DIR}/error.log
		CustomLog ${APACHE_LOG_DIR}/access.log combined
</VirtualHost>

```

### Aplicación PHP

#### Base de datos

```bash
mysql -u username -p
```

```sql
CREATE DATABASE app1;
USE app1;
CREATE TABLE tareas (id INT AUTO_INCREMENT PRIMARY KEY, tarea VARCHAR(100), fecha DATE);
INSERT INTO tareas (tarea, fecha) VALUES ('tarea1', '2022-12-31');
INSERT INTO tareas (tarea, fecha) VALUES ('tarea2', '2022-12-31');
INSERT INTO tareas (tarea, fecha) VALUES ('tarea3', '2022-12-31');
```

#### Crear aplicación

```bash
sudo mkdir /var/www/html/app1
```

crear un archivo `index.php` en `/var/www/html/app1`

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

## Aplicación 2

### Tecnologias

- Front:
  - HTML5
  - CSS3
  - JavaScript
- Back
  - Java
- BBDD
  - MySql
- Servidor
  - Tomcat

### Instalación

#### Instalar Paquetes

- openjdk-17-jre: Java Runtime Environment
- tomcat9: Servidor web Java

```bash
sudo apt-get install openjdk-17-jre tomcat9
```

#### Reiniciar Tomcat para aplicar cambios

```bash
sudo service tomcat9 restart
```

#### Verificar la instalación de Tomcat

Si accedemos a `http://localhost:8080` deberíamos ver la página de inicio de Tomcat

#### Instalar MySql

```bash
sudo apt install mariadb-server
systemctl status mariadb
sudo mysql_secure_installation
sudo mariadb
MariaDB [(none)]> CREATE USER 'username'@'localhost' IDENTIFIED BY 'password';
MariaDB [(none)]> GRANT ALL PRIVILEGES ON *.* TO 'username'@'localhost' WITH GRANT OPTION;
MariaDB [(none)]> exit

maridb -u username -p
```

#### Instalar PhpMyAdmin

```bash

sudo apt-get install phpmyadmin

```

Se debe crear un enlace para poder acceder a phpmyadmin desde el servidor web

```bash
sudo ln -s /usr/share/phpmyadmin /var/www/html/phpmyadmin
```

### Configuración

#### Configurar Tomcat

```bash
sudo vim /etc/tomcat9/server.xml
```

```xml
<Connector port="8080" protocol="HTTP/1.1"
							 connectionTimeout="20000"
							 redirectPort="8443" />
```

#### Configurar MySql

```bash
sudo vim /etc/mysql/mariadb.conf.d/50-server.cnf
```

```bash
bind-address =
```

### Aplicación Java

#### Base de datos

```bash
mysql -u username -p
```

```sql
CREATE DATABASE app2;
USE app2;
CREATE TABLE users (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(100), email VARCHAR(100));
INSERT INTO users (name, email) VALUES ('user1', 'user1@email');
INSERT INTO users (name, email) VALUES ('user2', 'user2@email');
INSERT INTO users (name, email) VALUES ('user3', 'user3@email');
```

#### Crear aplicación

```bash
mkdir /var/lib/tomcat9/webapps/app2
```
