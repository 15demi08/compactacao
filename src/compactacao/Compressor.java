/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compactacao;

import estruturas.BinarySearchTree;
import estruturas.Occurrence;
import estruturas.Vector;

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
    private Vector<Occurrence<Character>> ocorrencias;
    
    /**
     * Arvore na qual serão armazenadas as ocorrencias dos caracteres, a fim de executar
     * o Código de Huffman
     */
    private BinarySearchTree<Occurrence<Character>> charTree;

    public Compressor(String dados) {
        this.dados = dados;
        this.ocorrencias = new Vector<>();
    }

    public String getDados() {
        return dados;
    }

    public Vector<Occurrence<Character>> getOcorrencias() {
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
                
                ocorrencias.append(new Occurrence<>(c));
                
            } else {
                
                boolean found = false;
                
                for( Occurrence<Character> oc : ocorrencias ){
                    
                    if( oc.getValue().equals(c) ){
                        
                        oc.incrementCount();
                        found = true;
                        break;
                        
                    }
                    
                }
                
                if( !found )
                    ocorrencias.append(new Occurrence<>(c));

            }

        }
        
    }

}
