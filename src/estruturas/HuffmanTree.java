/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturas;

/**
 *
 * @author demetrius
 */
public class HuffmanTree {
    
    private HuffmanNode root;

    public HuffmanTree() {
    }

    public HuffmanTree(HuffmanNode root) {
        this.root = root;
    }

    public HuffmanNode getRoot() {
        return root;
    }

    public void setRoot(HuffmanNode root) {
        this.root = root;
    }
    
    public void print(){
        
        if( root != null )
            root.print();
        
    }
    
}
