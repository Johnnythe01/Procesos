import java.io.IOException;
import java.util.Arrays;

public class SPU01E01_Jonathan_Barragan {

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.err.println("Se necesita un programa a ejecutar");
            System.exit(-1);
        }

        // Crear el proceso con los argumentos proporcionados
        ProcessBuilder pb = new ProcessBuilder(args);
        try {
            // Iniciar el proceso hijo
            Process process = pb.start();

            // El padre espera a que el proceso hijo termine
            int retorno = process.waitFor();
            
            // Informar si el proceso se ejecutó correctamente o no
            System.out.println("La ejecución de " + Arrays.toString(args) + " retorna " + retorno);
            
        } catch (IOException ex) {
            System.err.println("Error de Entrada/Salida durante la ejecución del comando.");
            System.exit(-1);
        } catch (InterruptedException ex) {
            System.err.println("El proceso hijo fue interrumpido inesperadamente.");
            System.exit(-1);
        }
    }
}

/* s */