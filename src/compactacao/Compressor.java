/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compactacao;

import estruturas.DuplicateKeyException;
import estruturas.Hashtable;
import estruturas.HuffmanNode;
import estruturas.HuffmanTree;
import estruturas.Vector;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilidades.Console;
import utilidades.Sorting;

/**
 *
 * @author demetrius
 */
public class Compressor {

    private String dados, huffmanString;
    private Vector<HuffmanNode> occurrences, leafList;
    private Hashtable<Character, String> codigos;
    private HuffmanTree charTree;

    public Compressor(String dados) {
        this.dados = dados;
        this.occurrences = new Vector<>();
        this.charTree = new HuffmanTree();
        this.codigos = new Hashtable<>();
    }

    public void compactar() {

        gerarOcorrencias();

        gerarArvoreHuffman();
        
        gerarCodigos();
        
        gerarRepresentacaoHuffman();

    }

    public String getHuffmanString() {
        return huffmanString;
    }

    /**
     * Analisa a String fornecida e gera um vetor contendo o número de
     * occurrences de cada caractere nela presente (inclui espaços em branco).
     */
    private void gerarOcorrencias() {

        for (char c : dados.toCharArray()) {

            if (occurrences.size() == 0) {

                occurrences.append(new HuffmanNode(c));

            } else {

                boolean found = false;

                for (HuffmanNode oc : occurrences) {

                    if (oc.getValue() == c) {

                        oc.incrementCount();
                        found = true;
                        break;

                    }

                }

                if (!found) {
                    occurrences.append(new HuffmanNode(c));
                }

            }

        }

        ordenarOcorrencias();

        leafList = occurrences.clonar();

    }

    /**
     * Ordena as occurrences dos caracteres da String fonte para esta
     * compactação, em ordem crescente.
     */
    private void ordenarOcorrencias() {

        HuffmanNode[] array = occurrences.toArray(new HuffmanNode[occurrences.size()]);

        Comparator<HuffmanNode> cmp = (HuffmanNode t, HuffmanNode t1) -> t.compareTo(t1);

        long ops = Sorting.insertionSort(array, cmp);

        //Console.println("ops: " + String.valueOf(ops));
        occurrences = new Vector<>(array);

    }

    /**
     * Usa as occurrences ordenadas para criar uma arvore de geração de códigos
     */
    private void gerarArvoreHuffman() {

        switch (occurrences.size()) {
            case 2: {
                HuffmanNode child0 = occurrences.pop(0);
                HuffmanNode child1 = occurrences.pop(0);
                HuffmanNode parent = new HuffmanNode(child0.getNumOccurrences() + child1.getNumOccurrences(), child0, child1);
                charTree.setRoot(parent);
                break;
            }
            case 1:
                charTree.setRoot(occurrences.pop(0));
                break;
            default: {
                HuffmanNode child0 = occurrences.pop(0);
                HuffmanNode child1 = occurrences.pop(0);
                HuffmanNode parent = new HuffmanNode(child0.getNumOccurrences() + child1.getNumOccurrences(), child0, child1);
                occurrences.append(parent);
                ordenarOcorrencias();
                gerarArvoreHuffman();
                break;
            }
        }

    }

    private void gerarCodigos() {

        for (HuffmanNode node : leafList) {

            StringBuilder sb = new StringBuilder();

            HuffmanNode tmp = node;

            while (tmp != null) {
                
                //Console.println(tmp.getValue());

                sb.append(tmp.getBit() ? "1" : "0");

                if( tmp.getParent() == null )
                    break;
                else
                    tmp = tmp.getParent();

            }

            sb = sb.reverse();
            
            try {
                codigos.put(node.getValue(), sb.toString());
            } catch (DuplicateKeyException ex) {
                Logger.getLogger(Compressor.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    
    private void gerarRepresentacaoHuffman(){
        
        StringBuilder sb = new StringBuilder();
        
        char[] chars = dados.toCharArray();
        
        for( char c : chars ){
            
            sb.append(codigos.get(c));
            
        }
        
        huffmanString = sb.toString();
        
    }
    
    public void printTree() {
        charTree.print();
    }
    
    public void printCodigos(){
        
        for( HuffmanNode hn : leafList ){
            
            Console.println( hn.getValue() + ": " + codigos.get(hn.getValue()) );
            
        }
        
    }

}
