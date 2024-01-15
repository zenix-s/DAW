La administración de un servidor web y/o un servidor de aplicaciones requiere unos conocimientos básicos de comandos de consola que permite visualizar qué está pasando en nuestro servidor. Se pide practicar y crear una guía de uso para las siguientes problemáticas que nos podemos encontrar:

  1. ¿Cómo sabemos si tenemos conexión a internet? Pista: ifconfig, ping
  2. ¿Cómo sabemos si nuestro servidor es accesible desde Internet? Pista: ufw, netstat
  3. ¿Cómo sabemos a quién pertenece una dirección web (URL)? Pista: dig, nslookup
  4. ¿Cómo probamos que podemos acceder a un servidor? Pista: curl, wget
  5. ¿Qué otros comandos te han hecho falta?

Consideraciones

Para toda la actividad se valorará el orden y la claridad de la documentación, así como la facilidad de uso.

Para la entrega, es necesaria la creación y subida a la plataforma de un pequeño documento formal sobre la actividad (portada, explicación, etc.) y una guía “how-to” que describa y permita resolver las preguntas planteadas en la actividad.

Nótese que más adelante se pedirá que se realicen tareas con un repositorio GIT que contenga la documentación de esta actividad.

## 1. ¿Cómo sabemos si tenemos conexión a internet?
Para saber si tenemos conexión a internet, se puede usar el comando `ping`.
Este comando envía paquetes a una dirección web y recibe una respuesta. Si se recibe una respuesta, significa que tenemos conexión a internet.
Para usar este comando, en sistemas Linux, se debe usar el comando `sudo` antes del comando `ping`.
Tambien se requiere tener instalado el paquete `net-tools`
```bash
# Si tenemos conexión a internet, podremos hacer ping a cualquier dirección web
$ sudo ping www.google.com
PING www.google.com (142.250.200.100) 56(84) bytes of data.
64 bytes from mad41s13-in-f4.1e100.net (142.250.200.100): icmp_seq=1 ttl=114 time=9.17 ms
64 bytes from mad41s13-in-f4.1e100.net (142.250.200.100): icmp_seq=2 ttl=114 time=8.99 ms
64 bytes from mad41s13-in-f4.1e100.net (142.250.200.100): icmp_seq=3 ttl=114 time=9.05 ms
64 bytes from mad41s13-in-f4.1e100.net (142.250.200.100): icmp_seq=4 ttl=114 time=25.7 ms
64 bytes from mad41s13-in-f4.1e100.net (142.250.200.100): icmp_seq=5 ttl=114 time=18.3 ms
64 bytes from mad41s13-in-f4.1e100.net (142.250.200.100): icmp_seq=6 ttl=114 time=18.5 ms
64 bytes from mad41s13-in-f4.1e100.net (142.250.200.100): icmp_seq=7 ttl=114 time=18.3 ms
64 bytes from mad41s13-in-f4.1e100.net (142.250.200.100): icmp_seq=8 ttl=114 time=22.0 ms
^C
--- www.google.com ping statistics ---
8 packets transmitted, 8 received, 0% packet loss, time 6997ms
rtt min/avg/max/mdev = 8.987/16.257/25.683/6.028 ms

# En caso de no tener conexión a internet, no se recibirá ninguna respuesta
$ sudo ping www.google.com
ping: www.google.com: Temporary failure in name resolution
```

## 2.¿Cómo sabemos si nuestro servidor es accesible desde Internet?

Para saber si nuestro servidor es accesible desde internet, se puede usar el comando `netstat`.
Este comando muestra las conexiones de red, las tablas de enrutamiento y un número de interfaces de red.
```bash
# Si nuestro servidor es accesible desde internet, podremos ver las conexiones de red
$ sudo netstat -tulpn
Active Internet connections (only servers)
Proto Recv-Q Send-Q Local Address           Foreign Address         State       PID/Program name
tcp        0      0 127.0.0.1:33619         0.0.0.0:*               LISTEN      11386/node
udp        0      0 127.0.0.1:323           0.0.0.0:*                           -
udp6       0      0 ::1:323                 :::*                                -
```
En este caso, se puede ver que el servidor está escuchando en el puerto 33619. Esto significa que el servidor es accesible desde internet.

## 3. ¿Cómo sabemos a quién pertenece una dirección web (URL)?

Para saber a quién pertenece una dirección web, se puede usar el comando `whois`.
Este comando muestra información sobre un nombre de dominio o una dirección IP.
```bash
# Si queremos saber a quién pertenece la dirección web www.google.com, podemos usar el comando whois
