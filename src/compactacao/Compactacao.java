/*
 * Demétrius Jr.
 */
package compactacao;

import estruturas.Occurrence;
import estruturas.Vector;
import utilidades.Console;
import utilidades.Sorting;

/**
 *
 * @author demetrius
 */
public class Compactacao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String teste = "Demétrius Aron dos Santos Junior";
        
        Compressor c = new Compressor(teste);
        
        c.gerarOcorrencias();
        
        Vector<Occurrence<Character>> ov = c.getOcorrencias();
        
        for( Occurrence<Character> oc : ov )
            Console.println(oc);
        
    }
    
}
