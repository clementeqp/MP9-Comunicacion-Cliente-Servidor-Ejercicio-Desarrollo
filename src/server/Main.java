package server;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Creamos el servidor yt lo arrancamos
        Server server = new Server();
        server.startServer();
    }
}


// Apuntes, pdf y videtutorias Ilerna Programacion de servicios y procesos 2ºDAM
//https://www.programarya.com/Cursos-Avanzados/Java/Sockets