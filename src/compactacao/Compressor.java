/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compactacao;

import estruturas.HuffmanNode;
import estruturas.HuffmanTree;
import estruturas.Vector;
import java.util.Comparator;
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
     * Armazena o número de occurrences de cada caractere presente na String
     * fornecida
     */
    private Vector<HuffmanNode> occurrences;

    /**
     * Arvore na qual serão armazenadas as occurrences dos caracteres, a fim de
     * executar o Código de Huffman
     */
    private HuffmanTree charTree;

    public Compressor(String dados) {
        this.dados = dados;
        this.occurrences = new Vector<>();
        this.charTree = new HuffmanTree();
    }

    public void printTree() {
        charTree.print();
    }

    public String getDados() {
        return dados;
    }

    public Vector<HuffmanNode> getOccurrences() {
        return occurrences;
    }

    public void compactar() {
        
        gerarOcorrencias();
        
        gerarArvoreHuffman();

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
    
    private void geraCodigoChar( char c ){
        
        
        
    }

}
