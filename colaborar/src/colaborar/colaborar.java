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
 *
 * @author chern007
 */
public class colaborar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {  


        try {

            String rutaJar = args[0] + " ";
            String rutaOutput = " " + args[1];
            
            Process p;

            for (int i = 1; i < 11; i++) {

                p = Runtime.getRuntime().exec("cmd /C java -jar " + rutaJar + i*10 + rutaOutput);

                // se obtiene el stream de salida del programa 
                InputStream is = p.getInputStream();

                //se prepara un bufferedReader para poder leer la salida más comodamente.
                BufferedReader br = new BufferedReader(new InputStreamReader(is));

                // Se lee la primera linea 
                String aux = br.readLine();

                // mientras se haya leido alguna linea 
                while (aux != null) {
                    // se escribe la linea en pantalla 
                    System.out.println(aux);

                    // y se lee la siguiente. 
                    aux = br.readLine();
                }
            }

            return;

        } catch (Exception e) {
            System.err.println("Se ha producido un error al ejecutar el programa externo.");
        }

    }

}
