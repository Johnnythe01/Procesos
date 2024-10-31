import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SPU01E03_hijo_jonathan_barragan {
    public static void main(String[] args) {
        try {
            // Leer la palabra del padre
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String palabra = reader.readLine();
            System.out.println("Hijo: Recibido del padre -> " + palabra);

            // Convertir la palabra a mayúsculas
            String palabraMayusculas = palabra.toUpperCase();

            // Enviar la palabra convertida de vuelta al padre
            System.out.println("Hijo: Enviando al padre la palabra en mayúsculas -> " + palabraMayusculas);
            System.out.println(palabraMayusculas);

        } catch (IOException e) {
        }
    }
}
