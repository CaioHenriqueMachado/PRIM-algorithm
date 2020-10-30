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

        Boolean target = false;
        String U;
        String v = ".";
        
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
        
        //REMOVE DA LISTA
      
        for (int i = 0; i<Q.size(); i++){
            if (Q.get(i).equals(U)){
                Q.remove(i);
                break;
            }
        }

        
        //PASSO 1
        //ARRUMAR O ERRO PRA VER PRINTAR TUDO
        //FALTOU DESCARTAR OS CASOS QUE JA SAIRAM DO Q
        for (int z = 0; z<Q.size(); z++){
            
            for (int i=0; i<W.size(); i++){
                if ( W.get(i).getVerticeOrigem().equals(U) ){
                    //System.out.println(W.get(i).getVerticeDestino());
                    v = W.get(i).getVerticeDestino();
                    target = true;
                }

                if ( W.get(i).getVerticeDestino().equals(U) ){
                    //System.out.println(W.get(i).getVerticeOrigem());
                    v = W.get(i).getVerticeOrigem();
                    target = true;
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
            
            U = Q.get(z);
            
        }
        
        System.out.println("Fim");
        /*
        for (int p = 0; p<Q.size(); p++){
            System.out.println(G.get(p).getVerticeProximo() + " => " + G.get(p).getCusto());
 
        }
        */

   
    }
        
        
        
        
 
        
     /*
        
        
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
                    if (W.get(i).getVerticeOrigem().equals(U) ){
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
        
        
       
        
        */
        
        
        
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
