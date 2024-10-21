import java.io.IOException;
import java.util.Arrays;

public class SPU01E01_Jonathan_Barragan {

    public static void main(String[] args) throws IOException { //
        if (args.length == 0) {
            System.err.println("Se necesita un programa a ejecutar");
            System.exit(-1);
        }

        // Crea el proceso hijo, que ejecuta el pedido con las opciones correspondientes
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







/* Escribe una clase llamada SPU01E01_nombre_apellido que reciba como argumentos
el pedido y las opciones del pedido que se desea ejecutar. El programa debe
crear un proceso hijo que ejecute el pedido con las opciones correspondientes,
mostrando un mensaje de error en caso de que no se realizara correctamente la ejecución.
El padre debe esperar a que el hijo acabe por informar si se ha producido alguna anomalía en
la ejecución del hijo.
Sube al Classroom el archivo .java con el nombre indicado. Por ejemplo:
SPU01E01_nombre_apellido.java */