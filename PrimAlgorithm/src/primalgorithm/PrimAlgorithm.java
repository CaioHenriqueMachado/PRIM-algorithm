package primalgorithm;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PrimAlgorithm {
    public static void main(String[] args) {
	ArrayList G = new ArrayList();
	ArrayList W = new ArrayList();
        
        
        ManipuladorArquivo.coletarDados();   
        
        
        // Obtem os dados estruturados e prontos para serem usados na classe PRIM
        G.addAll(ManipuladorArquivo.ArrayVertices);
        W.addAll(ManipuladorArquivo.ArrayPesosArestas);

        try {
            PRIMM.prim(G, W, "A");
        } catch (InterruptedException ex) {
            Logger.getLogger(PrimAlgorithm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
}
