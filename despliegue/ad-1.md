## 1. ¿Cómo sabemos si tenemos conexión a internet?
Para saber si tenemos conexión a internet, se puede usar el comando `ping`.
Este comando envía paquetes a una dirección web y recibe una respuesta. Si se recibe una respuesta, significa que tenemos conexión a internet.
Para usar este comando, en sistemas Linux, se debe usar el comando `sudo` antes del comando `ping`.
Tambien se requiere tener instalado el paquete `net-tools`

```bash
# Podemos ver la dirección IP de nuestro servidor con el comando ifconfig
$serferna sudo ifconfig
eth0: flags=4163<UP,BROADCAST,RUNNING,MULTICAST>  mtu 1500
        inet ************  netmask ************  broadcast ************
        inet6 fe80::************  prefixlen 64  scopeid 0x20<link>
        ether **:**:**:**:**:**  txqueuelen 1000  (Ethernet)
        RX packets 97047  bytes 139635678 (133.1 MiB)
        RX errors 0  dropped 0  overruns 0  frame 0
        TX packets 35225  bytes 3904809 (3.7 MiB)
        TX errors 0  dropped 0 overruns 0  carrier 0  collisions 0
```

```bash
# Si tenemos conexión a internet, podremos hacer ping a cualquier dirección web
$serferna sudo ping www.google.com
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
$serferna sudo ping www.google.com
ping: www.google.com: Temporary failure in name resolution
```



## 2.¿Cómo sabemos si nuestro servidor es accesible desde Internet?

Para saber si nuestro servidor es accesible desde internet, se puede usar el comando `netstat`.
Este comando muestra las conexiones de red, las tablas de enrutamiento y un número de interfaces de red.
```bash
# Si nuestro servidor es accesible desde internet, podremos ver las conexiones de red
$serferna sudo netstat -tulpn
Active Internet connections (only servers)
Proto Recv-Q Send-Q Local Address           Foreign Address         State       PID/Program name
tcp        0      0 127.0.0.1:33619         0.0.0.0:*               LISTEN      11386/node
udp        0      0 127.0.0.1:323           0.0.0.0:*                           -
udp6       0      0 ::1:323                 :::*                                -
```
En este caso, se puede ver que el servidor está escuchando en el puerto 33619. Esto significa que el servidor es accesible desde internet.

## 3. ¿Cómo sabemos a quién pertenece una dirección web (URL)?

Utilizando el comando `nslookup` se puede saber a quién pertenece una dirección web.
Para ello, se requiere tener instalado el paquete `dnsutils`.

```bash
# Se usa el comando nslookup seguido de la dirección web
$ nslookup www.google.com
Server:         172.25.64.1 # El servidor es el DNS de la dirección web
Address:        172.25.64.1#53 # 53 es el puerto por defecto del DNS

Non-authoritative answer: # Non-authoritative answer significa que la respuesta no es del servidor DNS
Name:   www.google.com # Nombre de la dirección web
Address: 142.250.200.132 # Dirección IP de la dirección web
```

Usar el comando `dig` también permite saber a quién pertenece una dirección web.
```bash
$ dig www.google.com

; <<>> DiG 9.18.19-1~deb12u1-Debian <<>> www.google.com # Versión de dig
;; global options: +cmd # Opciones globales
;; Got answer: # Respuesta
;; ->>HEADER<<- opcode: QUERY, status: NOERROR, id: 36774 
;; flags: qr rd ad; QUERY: 1, ANSWER: 1, AUTHORITY: 0, ADDITIONAL: 0
;; WARNING: recursion requested but not available

;; QUESTION SECTION:
;www.google.com.                        IN      A

;; ANSWER SECTION:
www.google.com.         0       IN      A       142.250.200.132

;; Query time: 10 msec
;; SERVER: 172.25.64.1#53(172.25.64.1) (UDP)
;; WHEN: Sun Jan 21 17:50:51 CET 2024
;; MSG SIZE  rcvd: 62
```

## 4. ¿Cómo probamos que podemos acceder a un servidor?
Se pueden usar los comandos `curl` y `wget` para probar que podemos acceder a un servidor.
Estos comandos pueden instalarse con el paquete `curl` y `wget` respectivamente.
`sudo apt install curl wget`

En este caso, se va a usar la dirección web de la página de neovim para probar que podemos acceder a un servidor.
Se va a descargar el archivo nvim.appimage de la página de neovim.

```bash
# Se usa el comando curl seguido de la dirección web
$serferna on ~/downloads curl -LO https://github.com/neovim/neovim/releases/latest/download/nvim.appimage
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0
  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0
100 10.6M  100 10.6M    0     0  6790k      0  0:00:01  0:00:01 --:--:-- 11.0M
# -L: Seguir redirecciones
# -O: Guardar el archivo con el mismo nombre que el archivo remoto
$serferna on ~/downloads ls # Se puede ver que se ha descargado el archivo nvim.appimage
```

```bash	
# Se usa el comando wget seguido de la dirección web
$serferna on ~/downloads wget https://github.com/neovim/neovim/releases/latest/download/nvim.appimage
nvim.appimage.1                           100%[==================================================================================>]  10.66M  11.0MB/s    in 1.0s
2024-01-21 17:59:57 (11.0 MB/s) - ‘nvim.appimage.1’ saved [11179200/11179200]

$serferna on ~/downloads ls
nvim.appimage
```

## 5. ¿Qué otros comandos te han hecho falta?

No se han necesitado más comandos, pero si se ha necesitado instalar los paquetes
- `net-tools` : Para usar el comando `ifconfig`
- `dnsutils` : Para usar el comando `nslookup` y `dig`
- `curl` : Para usar el comando `curl`
- `wget` : Para usar el comando `wget`