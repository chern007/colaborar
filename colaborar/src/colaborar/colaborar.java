/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colaborar;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Aplicación que ejecuta 10 veces la aplicación lenguaje y guarda el resultado
 * en el fichero de salida que especifiquemos.
 *
 * @author chern007
 */

public class colaborar {

    /**
     * @param args (ruta del archivo lenguaje.jar , ruta del archivo de salida).
     */
    
    public static void main(String[] args) {

        try {
            //guardamos los argumentos que le pasamos
            String rutaJar = args[0] + " ";
            String rutaOutput = " " + args[1];

            //declaramos la variable de la clase proceso
            Process p;

            for (int i = 1; i < 11; i++) {

                p = Runtime.getRuntime().exec("cmd /C java -jar " + rutaJar + i * 10 + rutaOutput);

                // se obtiene el stream de salida del programa 
                InputStream is = p.getInputStream();

                //se prepara un bufferedReader para poder leer la salida más comodamente.
                BufferedReader br = new BufferedReader(new InputStreamReader(is));

                //leemos la primera linea 
                String aux = br.readLine();

                // mientras se haya leido alguna linea 
                while (aux != null) {
                    // se escribe la linea en pantalla 
                    System.out.println(aux);

                    // y se lee la siguiente
                    aux = br.readLine();
                }
            }

            return;

        } catch (Exception e) {
            System.err.println("Se ha producido un error al ejecutar el programa externo.");
            System.err.println(e.toString());
        }

    }

}
