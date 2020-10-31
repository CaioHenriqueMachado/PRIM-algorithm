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
    public static void prim(ArrayList<Vertice> Vertice,ArrayList<Aresta> Aresta,ArrayList<Configuracao> config) throws InterruptedException {
        System.out.println("EXECUTANDO PRIM");

        Boolean target = false;
        String U;
        String v = ".";
        String aux;
        
        ArrayList<String> Q = new ArrayList<>();
        Collections.addAll(Q, ManipuladorArquivo.vertices_list);
        

        //PEVerticeA VERTICE INICIAL
        U = config.get(0).getVerticeInicial();
        
        //APLICAR CUSTO ZERO NO VERTICE INICIAL
        for (int i = 0; i<Q.size(); i++){
            if (Vertice.get(i).getNome().equals(U)){
                Vertice.get(i).setCusto(0);
            }
        }
        
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
            
            for (int i=0; i<Aresta.size(); i++){
                
                if ( Aresta.get(i).getVerticeOrigem().equals(U) ){
                    for ( int k = 0; k < Q.size(); k++ ){
                        if (Q.get(k).equals(Aresta.get(i).getVerticeDestino())){
                            v = Aresta.get(i).getVerticeDestino();
                            target = true;
                            break;
                        }
                    }
                }

                if ( Aresta.get(i).getVerticeDestino().equals(U) && !config.get(0).getDirecionado() ){
                    for ( int k = 0; k < Q.size(); k++ ){
                        if (Q.get(k).equals(Aresta.get(i).getVerticeOrigem())){
                            v = Aresta.get(i).getVerticeOrigem();
                            target = true;
                            break;
                        }
                    }
                }

                if ( target.equals(true) ){
                    for (int j=0; j<Vertice.size(); j++){
                        if(Vertice.get(j).getNome().equals(v)){
                            if (Vertice.get(j).getCusto() > Aresta.get(i).getPesoAresta() || Vertice.get(j).getCusto().equals(-1)){
                                Vertice.get(j).setCusto(Aresta.get(i).getPesoAresta());
                                Vertice.get(j).setVerticeProximo(Aresta.get(i).getVerticeOrigem() + ", " + Aresta.get(i).getVerticeDestino());
                                break;
                            }
                        }
                    }
                }
                target = false;
            }
            Q.remove(0);
        }
        
        for (int p = 0; p<Vertice.size(); p++){
            System.out.println(Vertice.get(p).getVerticeProximo()+ " => " + Vertice.get(p).getCusto());
        }
        
    }
}
