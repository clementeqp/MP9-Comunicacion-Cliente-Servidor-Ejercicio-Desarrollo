package client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    // Socket cliente
   private Socket sc;

   // Constructor vacio
   public Client() throws IOException {
       sc = new Socket("localhost", 9876);

   }

    public void startClient() {
       Scanner scan = new Scanner(System.in);
       String mensaje;

        try {
            //Creamos los flujos de entrada y salida
            DataInputStream in = new DataInputStream(sc.getInputStream());
            DataOutputStream out = new DataOutputStream(sc.getOutputStream());
            // 2-Leer el mensaje del servidor
            mensaje = in.readUTF();
            // 3-Imprimir el mensaje para el usuario
            System.out.println(mensaje);
            // 4-Leer el mensaje del usuario
            mensaje = scan.nextLine();
            // 5-Cliente envia el mensaje al servidor
            out.writeUTF(mensaje);
            // 8-Leer el mensaje del servidor
            mensaje = in.readUTF();
            System.out.println(mensaje);
            // 9-Usuario introduce numero de tareas
            int nTareas = Integer.parseInt(scan.nextLine());
            // 10-Cliente envia el numero de tareas al servidor
            out.writeInt(nTareas);

            // Cliente muestra al usuario los mensajes del servidor
            // y solicita al usuario que introduzca los datos de las tareas
            for (int i = 0 ; i < nTareas; i++){
                //12-2-Leer  mensajes del servidor y mostrarlos al usuario
                System.out.println(in.readUTF());
                System.out.println(in.readUTF());
                //12-3-usuario introduce descripcion de la tarea y cliente lo envia al servidor
                mensaje = scan.nextLine();
                out.writeUTF(mensaje);
                //12-6-Leer mensajes del servidor y mostrarlos al usuario
                System.out.println(in.readUTF());
                //12-7-usuario introduce el estado de la tarea y cliente lo envia a servidor
                mensaje = scan.nextLine();
                out.writeUTF(mensaje);
            }

            // 14-Leer mensaje de aviso del servidor y mostrarlo al cliente
            System.out.println(in.readUTF());
            // 16-Cliente recibe la lista de tareas del servidor y lo muestra al usuario
            for(int i=0; i<nTareas; i++){
                System.out.println(in.readUTF());
            }
            // 17-Cerramos los flujos y el socket
            out.close();
            in.close();
            sc.close();

        } catch (IOException ex) {
            System.out.println("No se inicio la conexion correctamente,\n Error: " + ex.getMessage());
        }
    }
}


// Apuntes, pdf y videtutorias Ilerna Programacion de servicios y procesos 2ºDAM
//https://www.programarya.com/Cursos-Avanzados/Java/Sockets