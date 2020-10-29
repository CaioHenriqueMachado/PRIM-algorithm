package prim;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		String caminhoProjetoJava = "";

		ArrayList<Grafo> G = new ArrayList<Grafo>();
	    ArrayList<PesoArestas> W = new ArrayList<PesoArestas>();
	    	    	    
	    // Obtem o caminho do projeto java e concatena ao nome do arquivo a ser usado
	    
	    caminhoProjetoJava = System.getProperty("user.dir");
	    ManipuladorArquivo.leitor(caminhoProjetoJava + "\\Grafo.txt");
	    
	    // Obtem os dados estruturados e prontos para serem usados na classe PRIM
	    G.addAll(ManipuladorArquivo.ArrayGrafos);
	    W.addAll(ManipuladorArquivo.ArrayPesosArestas);
	    
	    PRIM.prim(G, W, "A");
	    
            
            
	}

}
