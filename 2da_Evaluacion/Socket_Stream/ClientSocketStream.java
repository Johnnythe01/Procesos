import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientSocketStream {

	public static void main(String[] args) {

		try {
			System.out.println("Creant socket client");
			Socket clientSocket = new Socket();
			
			System.out.println("Establint connexio");
			InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
			clientSocket.connect(addr);
			
			System.out.println("Enviant missatge");
			
			// getOutputStream empleat per operacions de escritura
			OutputStream os = clientSocket.getOutputStream();
			String missatge = "missatge des del client";
			os.write(missatge.getBytes());
			System.out.println("Missatge enviat");
			
			System.out.println("Tancant el socket client");
			clientSocket.close();
			System.out.println("Fi");	
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

/*Escribe un programa que cuente el número de conexiones que vaya recibiendo.
Este programa dispondrá de un socket stream servidor.
Cada vez que un socket stream cliente se conecte,
el servidor imprimirá un mensaje con el número de clientes conectados hasta ahora.
Así, el primer cliente que se conecte recibirá un 1, el segundo un 2, el tercero un 3, etc.*/