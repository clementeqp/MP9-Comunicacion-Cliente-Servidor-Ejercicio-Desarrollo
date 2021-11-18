package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private final int PUERTO = 9876;
    private ServerSocket ss;
    private Socket sc;

    // Constructor
    public Server() throws IOException {
        ss = new ServerSocket(PUERTO);
        System.out.println("Servidor iniciado en el puerto: " + PUERTO);
        sc = new Socket();
    }

    public void startServer() {

        // Dejamos al servidor siempre en espera de conexiones
        while (true) {

            try {
                sc = ss.accept();

                System.out.println("Cliente conectado");

                //Creamos los flujos de datos de entrada y salida
                DataInputStream in = new DataInputStream(sc.getInputStream());
                DataOutputStream out = new DataOutputStream(sc.getOutputStream());
                // 1-Enviamos mensaje al cliente
                out.writeUTF("¿Como te llamas?");
                // 6-Recibimos mensaje del cliente
                String nombre = in.readUTF();
                // 7-Enviamos mensaje al cliente
                out.writeUTF("¿Dime " + nombre + ",  cuantas tareas necesitas?");
                // 11-Recibimos mensaje del cliente
                int nTareas = in.readInt();
                Tarea[] tareas = new Tarea[nTareas];

                // 12-Enviamos mensaje al cliente solicitando
                // la descripcion y el estado de la tarea
                for (int i = 0; i < nTareas; i++) {
                    //12-1
                    out.writeUTF("Vamos a crear la tarea " + (i + 1));
                    out.writeUTF("Cual es descripcion?");
                    //12-4 Servidor recibe la descripcion
                    String descripcion = in.readUTF();
                    // 12-5 Servidor pide estado de la tarea
                    out.writeUTF("En que estado se encuentra?");
                    // 12-8 Servidor recibe estado de la tarea
                    String estado = in.readUTF();
                    // 12-9 Servidor crea la tarea y la agrega al array tareas
                    Tarea tarea = new Tarea(descripcion, estado);
                    tareas[i] = tarea;
                }

                // 13- Servidor envía mensaje al cliente
                out.writeUTF("Enviando Lista de tareas ... ");
                // 15- Servidor envia la lista de tareas al cliente
                for (int i = 0; i < nTareas; i++) {
                    out.writeUTF("Tarea: " + (i + 1) + tareas[i].toString());
                }


            } catch (IOException e) {
                System.out.println("Error de conexion ,\n Error: " + e.getMessage());
            }
        }
    }
}


// Apuntes, pdf y videtutorias Ilerna Programacion de servicios y procesos 2ºDAM
//https://www.programarya.com/Cursos-Avanzados/Java/Sockets
