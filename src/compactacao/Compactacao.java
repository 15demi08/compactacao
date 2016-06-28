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

        String entrada = Console.readLine("String para compactar: ");
        //String entrada = "teste";
        
        Console.println("Representação binária: " + toBinaryString(entrada));
        
        Compressor c = new Compressor(entrada);
        
        c.compactar();
        
        String saida = c.getHuffmanString();
        
        Console.println("Representação Huffman: " + saida);
        
        Console.println( toBinaryString(entrada).length() );
        Console.println( saida.length() );
        
        //double reducao = ( saida.length() / entrada.length() );
        
        //Console.println("Redução: " + reducao + "%");


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
