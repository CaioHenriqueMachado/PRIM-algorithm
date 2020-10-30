package primalgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author caiom
 */
public class PRIMM {
    
    static ArrayList<Vertice> auxKey = new ArrayList<Vertice>();
    static ArrayList<Vertice> PI = new ArrayList<Vertice>();
    static ArrayList<Aresta> W = new ArrayList<Aresta>();

    @SuppressWarnings("unchecked")
    public static void prim(ArrayList<Vertice> G,ArrayList<Aresta> W,String r) throws InterruptedException {
        System.out.println("EXECUTANDO PRIM");
        
        String R;
        String aux;
        String U;
        
        ArrayList<String> Q = new ArrayList<>();
        Collections.addAll(Q, ManipuladorArquivo.vertices_list);
        
        R = r;
        
     
        for (int i = 0; i<Q.size(); i++){
            //System.out.println(G.get(i).getNome());
            
            //APLICA ZERO NO VERTICE INICIAL
            if (G.get(i).getNome().equals(R)){
                G.get(i).setCusto(0);
            }
        }
    
        //Vertice usado
        U = R;
        
        //PASSO 1
        for (int i=0; i<W.size(); i++){
            if (W.get(i).getVerticeOrigem().equals(U)){
                aux = W.get(i).getVerticeDestino();

                for (int j=0; j<G.size(); j++){
                    if(G.get(j).getNome().equals(aux)){
                        if (G.get(j).getCusto() > W.get(i).getPesoAresta() || G.get(j).getCusto().equals(-1)){
                            G.get(j).setCusto(W.get(i).getPesoAresta());
                        }
                    }

                }
            }
        }
        
        /*
        System.out.println(G.get(0).getNome());
        System.out.println(G.get(0).getCusto());
        
        
        System.out.println(G.get(1).getNome());
        System.out.println(G.get(1).getCusto());
        
        System.out.println(G.get(2).getNome());
        System.out.println(G.get(2).getCusto());
        */
        
     
        
        int k = 0;
        boolean active = false;

        while (!Q.isEmpty()) {
            U = Q.get(k);
            System.out.println("->" + U);
            if (active == false){
                
                if (Q.get(k).equals(R)){
                    //System.out.println(" " + Q.get(k) + " REMOVIDO");
                    Q.remove(k);
                    U = Q.get(k);
                    active = true;
                }
                
            } else {
                
                for (int i=0; i<W.size(); i++){
                    if (W.get(i).getVerticeOrigem().equals(U) /*e DESTINO ESTEJA EM Q*/){
                        aux = W.get(i).getVerticeDestino();

                        for (int j=0; j<G.size(); j++){
                            if(G.get(j).getNome().equals(aux)){
                                if (G.get(j).getCusto() > W.get(i).getPesoAresta() || G.get(j).getCusto().equals(-1)){
                                    G.get(j).setCusto(W.get(i).getPesoAresta());
                                    
                                    W.remove(i);
                                }
                            }

                        }
                    }
                }
                //System.out.println(Q.get(k) + " REMOVIDO");
                Q.remove(k);
            }
        }
        System.out.println("ACABOU!! ");
        
        
        for (int i = 0; i<3; i++){
        System.out.println("Nome: " + G.get(i).getNome()+ " " + G.get(i).getCusto());
        System.out.println("");
        }
        
        
        
        
        
        
        
        
        /*
        System.out.println(G.get(0).getCusto());
        System.out.println(G.get(1).getCusto());
        */
        
        
        /*
        for(int i = 0; i < Q.length; i++){;
          
        }
        */
    }

}
