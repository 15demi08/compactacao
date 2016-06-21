/*
 * Demétrius Jr.
 */
package compactacao;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilidades.Console;

/**
 *
 * @author demetrius
 */
public class Compactacao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String path = "teste.txt";
        Arquivo entrada = new Arquivo(path);
        entrada.ler();
        Console.println(entrada);
        
    }
    
}
