/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compactacao;

import estruturas.BinarySearchTree;
import estruturas.Occurrence;
import estruturas.Vector;
import java.util.Comparator;
import utilidades.Console;
import utilidades.Sorting;

/**
 *
 * @author demetrius
 */
public class Compressor {

    /**
     * A String com o texto a ser compactado
     */
    private String dados;
    
    /**
     * Armazena o número de ocorrencias de cada caractere presente na String fornecida
     */
    private Vector<Occurrence> ocorrencias;
    
    /**
     * Arvore na qual serão armazenadas as ocorrencias dos caracteres, a fim de executar
     * o Código de Huffman
     */
    private BinarySearchTree<Occurrence> charTree;

    public Compressor(String dados) {
        this.dados = dados;
        this.ocorrencias = new Vector<>();
    }

    public String getDados() {
        return dados;
    }

    public Vector<Occurrence> getOcorrencias() {
        return ocorrencias;
    }

    public void compactar() {

        

    }
    
    /**
     * Analisa a String fornecida e gera um vetor contendo o número de ocorrencias
     * de cada caractere nela presente (inclui espaços em branco).
     */
    public void gerarOcorrencias(){
        
        for (char c : dados.toCharArray()) {

            if (ocorrencias.size() == 0) {
                
                ocorrencias.append(new Occurrence(c));
                
            } else {
                
                boolean found = false;
                
                for( Occurrence oc : ocorrencias ){
                    
                    if( oc.getValue() == c ){
                        
                        oc.incrementCount();
                        found = true;
                        break;
                        
                    }
                    
                }
                
                if( !found )
                    ocorrencias.append(new Occurrence(c));

            }

        }
        
        ordenarOcorrencias();
        
    }
    
    /**
     * Ordena as ocorrencias dos caracteres da String fonte para esta compactação,
     * em ordem crescente.
     */
    private void ordenarOcorrencias(){
        
        Occurrence[] array = ocorrencias.toArray(new Occurrence[ocorrencias.size()]);
        
        Comparator<Occurrence> cmp = (Occurrence t, Occurrence t1) -> t.compareTo(t1);
        
        long ops = Sorting.insertionSort(array, cmp);
        
        Console.println("ops: " + String.valueOf(ops));
        
        ocorrencias = new Vector<>(array);
        
    }
    
    /**
     * Usa as ocorrencias ordenadas para criar uma arvore de geração de códigos
     */
    private void gerarArvoreHuffman(){
        
        
    }

}
