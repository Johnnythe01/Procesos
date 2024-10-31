import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class SPU01E03_padre_jonathan_barragan {
    //le meto esto para que no salten alertas de que no se ha cerrado el flujo
    @SuppressWarnings("ConvertToTryWithResources") 
    public static void main(String[] args) {
        try {
            // Crear el proceso hijo
            ProcessBuilder builder = new ProcessBuilder("java", "-cp", ".", "SPU01E03_hijo_jonathan_barragan");
            builder.redirectErrorStream(true);
            Process procesoHijo = builder.start();

            // Configurar los streams para comunicarse con el hijo
            OutputStream os = procesoHijo.getOutputStream();
            InputStream is = procesoHijo.getInputStream();
            
            // Enviar una palabra al hijo
            String palabra = "Hola";
            System.out.println("Padre: Enviando la palabra '" + palabra + "' al hijo.");
            os.write((palabra + "\n").getBytes());
            os.flush();

            // Leer la respuesta del hijo
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String respuestaHijo = reader.readLine();
            System.out.println("Padre: Recibido del hijo -> " + respuestaHijo);

            // Esperar a que el proceso hijo termine
            procesoHijo.waitFor();
            os.close();
            is.close();
        } catch (IOException | InterruptedException e) {
        }
    }
}
