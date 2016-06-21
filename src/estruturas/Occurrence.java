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
public class Occurrence<T> implements Comparable<Occurrence<T>>{
    
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

    @Override
    public int compareTo(Occurrence<T> t) {
        if(this.getNumOccurrences() > t.getNumOccurrences())
            return 1;
        else if(this.getNumOccurrences() < t.getNumOccurrences())
            return -1;
        else
            return 0;
    }

    @Override
    public String toString() {
        return value + ": " + numOccurrences;
    }
    
    
    
}
