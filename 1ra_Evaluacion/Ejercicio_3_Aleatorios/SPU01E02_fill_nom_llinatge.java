import java.util.Random;
import java.util.Scanner;

public class SPU01E02_fill_nom_llinatge {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.trim().isEmpty()) {  // Detecta la solicitud del padre con "intro"
                int aleatorio = random.nextInt(11);  // Genera un número entre 0 y 10
                System.out.println(aleatorio);  // Envía el número a la salida estándar
            }
        }
        scanner.close();
    }
}
