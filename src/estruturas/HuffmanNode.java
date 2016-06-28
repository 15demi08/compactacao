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
public class HuffmanNode implements Comparable<HuffmanNode>{
    
    private char value;
    private int numOccurrences;
    private boolean bit;
    private HuffmanNode child0, child1, parent;

    public HuffmanNode(int numOccurrences, HuffmanNode child0, HuffmanNode child1) {
        this.numOccurrences = numOccurrences;
        this.child0 = child0;
        this.child0.setBit(false);
        this.child1 = child1;
        this.child1.setBit(true);
        
        setParents();
    }

    public HuffmanNode(char value) {
        this.value = value;
        this.numOccurrences = 1;
    }

    private void setParents() {
        this.child0.setParent(this);
        this.child1.setParent(this);
    }

    public HuffmanNode getParent() {
        return parent;
    }

    public void setParent(HuffmanNode parent) {
        this.parent = parent;
    }

    public boolean getBit() {
        return bit;
    }

    public void setBit(boolean bit) {
        this.bit = bit;
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
    public int compareTo(HuffmanNode o) {
        return this.numOccurrences - o.numOccurrences;
    }

    @Override
    public String toString() {
        return value + ": " + numOccurrences;
    }  

    public void print() {
        System.out.print("(" + value + "/" + numOccurrences + " ");
        if (child0 != null) {
            child0.print();
        } else {
            System.out.print("_");
        }
        if (child1 != null) {
            child1.print();
        } else {
            System.out.print(" _");
        }
        System.out.print(")");
    }
    
}
