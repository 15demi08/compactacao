/*
 * Demétrius Jr.
 */
package compactacao;

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

        String teste = "divisibilidade";
        
        //Console.println(toBinaryString(teste));
        
        Compressor c = new Compressor(teste);
        
        c.compactar();
        
        c.printTree();


    }

    public static String toBinaryString(String string) {

        StringBuilder sb = new StringBuilder();

        char[] chars = string.toCharArray();

        for (Character c : chars) {

            sb.append(Integer.toBinaryString(c));

        }

        return sb.toString();

    }

}
