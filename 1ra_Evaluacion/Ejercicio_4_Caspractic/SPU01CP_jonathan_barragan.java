import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SPU01CP_jonathan_barragan {

    public static void main(String[] args) {
        try {
            // Comando para listar archivos en Windows
            ProcessBuilder pb1 = new ProcessBuilder("cmd", "/c", "dir");
            Process process1 = pb1.start();

            // Lee la salida del proceso y realiza la conversión de "d" a "D"
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process1.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    // Reemplaza todas las "d" por "D" en la salida de "dir"
                    line = line.replace("d", "D");
                    System.out.println(line);
                }
            }

            // Espera a que el proceso termine
            process1.waitFor();

        } catch (IOException | InterruptedException e) {
        }
    }
}


/*
En este caso práctico se desarrollará una solución multiproceso al problema de
sincronizar y comunicar dos procesos hijos creados a partir de una proceso padre. La
idea es escribir una clase Java que ejecute dos comandos (cada hijo creado ejecutará
uno de ellos) con sus respectivos argumentos y redirija la salida estándar del
primero en la entrada estándar del segundo. Por sencillez, los comandados y sus
argumentos irán directamente escritos en el código del programa para no complicar
demasiado el problema.
El siguiente ejemplo muestra la ejecución de los comandos ls -la y tr "d" "D" en Unix (el
resultado debería ser el mismo que el de ejecutar en la shell de Linux o Mac ls -la| tr
"d" "D"):

Total6
Drwxr-xr-x 5 user users 4096 22/12/2011 10:59.
Drwxr-xr-x 8 user users 4096 2011-02-07 9:26 . .
-rw-r—r— 1 user users 30 2011-02-22 10:59 a. txt
-rw-r—r— 1 user users 27 2011-02-22 10:59 b.txt
Drwxr-xr-x 2 user users 4056 2011-01-24 17:49 Dir3
Drwxr-xr-x 2 user users 4096 2011-01-24 11:48 Dir4

Suba al Classroom el archivo:
SPU01CP_nombre_apellido.java
Se debe entregar el ejercicio resuelto y una memoria donde se expliquen los pasos seguidos
para resolver el ejercicio.
*/
