/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturas;

/**
 * Representa uma ocorrência na pesquisa inicial para a construção da Árvore de Huffman
 * @author demetrius
 */
public class Occurrence<T> {
    
    private T value;
    private int numOccurrences;

    public Occurrence(T value) {
        this.value = value;
        this.numOccurrences = 1;
    }
    
    public void incrementCount(){
        this.numOccurrences++;
    }

    public T getValue() {
        return value;
    }

    public int getNumOccurrences() {
        return numOccurrences;
    }
    
}
