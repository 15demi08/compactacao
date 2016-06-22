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
public class Occurrence implements Comparable<Occurrence>{
    
    private char value;
    private int numOccurrences;

    public Occurrence(int numOccurrences) {
        this.numOccurrences = numOccurrences;
    }

    public Occurrence(char value) {
        this.value = value;
        this.numOccurrences = 1;
    }
    
    public void incrementCount(){
        this.numOccurrences++;
    }

    public char getValue() {
        return value;
    }

    public int getNumOccurrences() {
        return numOccurrences;
    }

    @Override
    public int compareTo(Occurrence o) {
        return this.numOccurrences - o.numOccurrences;
    }

    @Override
    public String toString() {
        return value + ": " + numOccurrences;
    }  
    
}
