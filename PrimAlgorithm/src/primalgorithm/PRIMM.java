package primalgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author caiom
 */
public class PRIMM {

    @SuppressWarnings("unchecked")
    public static void prim(ArrayList<Vertice> G,ArrayList<Aresta> W,String r) throws InterruptedException {
        System.out.println("EXECUTANDO PRIM");

        Boolean target = false;
        String U;
        String v = ".";
        String aux;
        
        ArrayList<String> Q = new ArrayList<>();
        Collections.addAll(Q, ManipuladorArquivo.vertices_list);
        

        //APLICAR CUSTO ZERO NO VERTICE INICIAL
        for (int i = 0; i<Q.size(); i++){
            if (G.get(i).getNome().equals(r)){
                G.get(i).setCusto(0);
            }
        }
        
        //PEGA VERTICE INICIAL
        U = r;
        
        //ORDENA COM BASE NO PRIMEIRO DA LISTA
        for (int i = 0; i<Q.size(); i++){
            if (Q.get(i).equals(U)){
                aux = Q.get(i);
                Q.set(i, Q.get(0));
                Q.set(0, aux );
                break;
            } 
        }
        
        
        while(!Q.isEmpty()){
            U = Q.get(0);
            
            //LISTA DE ARESTAS(14 LAÇOS)
            for (int i=0; i<W.size(); i++){
                
                
                if ( W.get(i).getVerticeOrigem().equals(U) ){
                    for ( int k = 0; k < Q.size(); k++ ){
                        if (Q.get(k).equals(W.get(i).getVerticeDestino())){
                            v = W.get(i).getVerticeDestino();
                            target = true;
                            break;
                        }
                    }
                }

                if ( W.get(i).getVerticeDestino().equals(U) ){
                    for ( int k = 0; k < Q.size(); k++ ){
                        if (Q.get(k).equals(W.get(i).getVerticeOrigem())){
                            v = W.get(i).getVerticeOrigem();
                            target = true;
                            break;
                        }
                    }
                }

                if ( target.equals(true) ){

                    for (int j=0; j<G.size(); j++){
                        if(G.get(j).getNome().equals(v)){
                            if (G.get(j).getCusto() > W.get(i).getPesoAresta() || G.get(j).getCusto().equals(-1)){
                                G.get(j).setCusto(W.get(i).getPesoAresta());
                                G.get(j).setVerticeProximo(W.get(i).getVerticeOrigem() + ", " + W.get(i).getVerticeDestino());
                                break;
                            }
                        }

                    }
                }

                target = false;
            }
            
            Q.remove(0);
        }
        
        for (int p = 0; p<G.size(); p++){
            System.out.println(G.get(p).getVerticeProximo()+ " => " + G.get(p).getCusto());
        }
   
        
    }

}
