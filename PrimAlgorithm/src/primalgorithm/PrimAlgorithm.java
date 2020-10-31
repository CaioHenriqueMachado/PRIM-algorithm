package primalgorithm;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PrimAlgorithm {
    
    static String verticeInicial;
    
    public static void main(String[] args) {
	ArrayList Vertices = new ArrayList();
	ArrayList Arestas = new ArrayList();
        ArrayList Configuracao = new ArrayList();
        
        //Escolher vertice inicial
        verticeInicial = "A";
        
        ManipuladorArquivo.coletarDados();   
        
        if (ManipuladorArquivo.Erro){
            System.out.println("EXECUÇÃO FINALIZADA !!");
            
        }else {
            // Obtem os dados estruturados e prontos para serem usados na classe PRIM
            Vertices.addAll(ManipuladorArquivo.ArrayVertices);
            Arestas.addAll(ManipuladorArquivo.ArrayPesosArestas);
            Configuracao.addAll(ManipuladorArquivo.ArrayConfig);


            try {
                PRIMM.prim(Vertices, Arestas, Configuracao);
            } catch (InterruptedException ex) {
                Logger.getLogger(PrimAlgorithm.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }

        

    }
        
}
