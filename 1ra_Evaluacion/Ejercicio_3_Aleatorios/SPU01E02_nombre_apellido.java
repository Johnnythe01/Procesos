import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class SPU01E02_nombre_apellido {
    public static void main(String[] args) {
        try {
            // Crea el proceso hijo ejecutando SPU01E02_fill_nombre_apellido
            ProcessBuilder builder = new ProcessBuilder("java", "SPU01E02_fill_nombre_apellido");
            Process procesoHijo = builder.start();

            // Prepara para escribir y leer desde el proceso hijo
            PrintWriter escritorHijo = new PrintWriter(new OutputStreamWriter(procesoHijo.getOutputStream()), true);
            BufferedReader lectorHijo = new BufferedReader(new InputStreamReader(procesoHijo.getInputStream()));

            Scanner scanner = new Scanner(System.in);
            System.out.println("Pulsa 'intro' para solicitar un número aleatorio o escribe 'fin' para terminar.");

            while (true) {
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("fin")) {
                    procesoHijo.destroy();
                    System.out.println("Ejecución finalizada.");
                    break;
                }

                escritorHijo.println();
                String numeroAleatorio = lectorHijo.readLine();
                System.out.println("Número aleatorio recibido: " + numeroAleatorio);
            }

            scanner.close();
            escritorHijo.close();
            lectorHijo.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
