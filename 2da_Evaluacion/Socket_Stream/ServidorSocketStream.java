
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServidorSocketStream {

    public static void main(String[] args) {
        
        try {
            int port = 5555;
            int numClients = 0;
            System.out.println("Creant socket servidor");
            ServerSocket serverSocket = new ServerSocket(port);
            Scanner sc = new Scanner(System.in);
            // System.out.println("Asigna una direccio i un numero de port al servidor");
            // InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
            // serverSocket.bind(addr);
            System.out.println("Escolta el socket servidor esperant connexions de clients");
            while (true) {
                
                
                Socket newSocket = serverSocket.accept();
                numClients++;

                // System.out.println("Connexio rebuda");

                // getInputStream empleat per operacions de lectura
                // InputStream is = newSocket.getInputStream();
                // byte[] missatge = new byte[25];
                // is.read(missatge);
                System.out.println("Clients conectats " + numClients);

                // System.out.println("Tancant el socket rebut");
                newSocket.close();
                System.out.println("Quieres salir? (s/n)");
                String respuesta = sc.nextLine();
                if (respuesta.equals("s")) {
                    break;
                }
            }
            // System.out.println("Tancant el socket servidor");
             
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // serverSocket.close();
    }
}

/*Escribe un programa que cuente el número de conexiones que vaya recibiendo.
Este programa dispondrá de un socket stream servidor.
Cada vez que un socket stream cliente se conecte,
el servidor imprimirá un mensaje con el número de clientes conectados hasta ahora.
Así, el primer cliente que se conecte recibirá un 1, el segundo un 2, el tercero un 3, etc.*/
