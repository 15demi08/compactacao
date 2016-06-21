/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compactacao;

import estruturas.Occurrence;
import estruturas.Vector;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author demetrius
 */
class Arquivo {
    
    private String path;
    private String dados;
    private Vector<Occurrence<Character>> ocorrencias;

    public Arquivo(String path){
        
        this.path = path;
        
    }

    public void ler() {
        
        FileReader fr = null;
        
        try {
            
            fr = new FileReader(path);
            
            Scanner s = new Scanner(fr);
            
            StringBuilder sb = new StringBuilder();
            
            while(s.hasNext())
                sb.append(s.next());
            
            dados = sb.toString();
            
        } catch (FileNotFoundException ex) {
            
            Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
            
        } finally {
            
            try {
                
                fr.close();
                
            } catch (IOException ex) {
                
                Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        }
    }

    public void salvar(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Arquivo compactar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        
        return dados;
        
    }
    
    
    
}
