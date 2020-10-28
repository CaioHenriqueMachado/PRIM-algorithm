package prim;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

//Q -> � uma fila
//G -> Grafo
//W -> Custo das arestas
//r -> Vertice inicial

public class PRIM {
	
	static ArrayList<Grafo> auxKey = new ArrayList<Grafo>();
	static ArrayList<Grafo> PI = new ArrayList<Grafo>();
	static ArrayList<PesoArestas> W = new ArrayList<PesoArestas>();
	
	@SuppressWarnings("unchecked")
	public static void prim(ArrayList<Grafo> G,ArrayList<PesoArestas> W,String r) {
		
		ArrayList<Grafo> Q = new ArrayList<Grafo>();	    
	    ArrayList<Grafo> retGrafosAdjacentes = new ArrayList<Grafo>();
	    
	    Grafo minGrafo = new Grafo();
	    
	    Integer index = 0;
	    
//	    Necess�rio para gerar IDs para cada Grafo
	    Random geradorID = new Random();
	    
	    Q = G;
	    PRIM.W = W;

	    // Seta o valores aos vertices
	    for( Grafo iGrafo : Q )
	    {
	    	Grafo grafo = new Grafo();
	    	Grafo PIgrafo = new Grafo();
	    	
//	    	Seta vertice inicial igual a zero
	    	if(iGrafo.getAresta().equals(r)) {
	    		
	    		grafo.setCustoAresta(0);
	    		grafo.setAresta(iGrafo.getAresta());
	    		grafo.setID(geradorID.nextInt());
	    		
//	    		Adiciona vertice inicial ao vetor PI
	    		PIgrafo.setAresta(grafo.getAresta());
		    	PIgrafo.setID(grafo.getID());
		    	PI.add(PIgrafo);
	    		
	    	}
	    	else {
	    		
//	    		Seta o vertice com o maio valor possivel
	    		grafo.setCustoAresta(Integer.MAX_VALUE);
	    		grafo.setAresta(iGrafo.getAresta());
	    		grafo.setID(geradorID.nextInt());
	    		
//	    		Adiciona aresta e o ID do grafo ao vetor PI
	    		PIgrafo.setAresta(grafo.getAresta());
		    	PIgrafo.setID(grafo.getID());
		    	PI.add(PIgrafo);
		    	
	    	}
	    	
		    auxKey.add(grafo);	        
	        index++;
	    }
	        
//	    Clona axuKey para ser usado na extracao do menor grafo
	    Q = (ArrayList<Grafo>) auxKey.clone();
	    
	    Integer retornoPEsos = 0;
	    
	    try {
	    	
	    	while (!Q.isEmpty()) {
		    	
		    	minGrafo = EXTRACT_MIN(Q);
		    	
		    	if(minGrafo.getAresta() == null) {
		    		continue;
		    	}
		    	
		    	retGrafosAdjacentes = VerticesAdjacentes(minGrafo, Q);
		    		
		    	for( Grafo iGrafo : retGrafosAdjacentes )
			    {
		    		
		    		// Verifica se esta na fila
		    		if (Q.contains(iGrafo)) {
		    			    			
		    			retornoPEsos = ObterPesoAresta(iGrafo);
		    			
		    			if(retornoPEsos == null) {
		    	    		continue;
		    	    	}
		    			
		    			if(retornoPEsos < VerificaAuxiliarKEY(iGrafo, auxKey).getCustoAresta()) {
                                                
                                                // Adiciona grafo ao vetor auxKey caso o peso do grafo seja menor que o grafo do auxKey

		    				AdicionaAoVetor(minGrafo, iGrafo, "PI");
		    				AdicionaAoVetor(minGrafo, iGrafo, "auxKey");
		    				
		    				
		    			}
		    			
		    			
		    		}
		    		
			    }
			}
			
		} catch (Exception e) {
			System.out.printf("\nLoop contendo a fun��o: EXTRACT_MIN -> ", e.getMessage());
		}
    
	    System.out.printf("\n<<< Grafo Resultante >>>\n\n");
	    
	    // Trabalha os valores do vetor auxKey
	    ContainsVerticeAuxKey();
	    	    
	}
	
	public static Integer ObterPesoAresta(Grafo iGrafo){
		
		Integer peso = 0;
	
		try {
			
			for (PesoArestas pesos : PRIM.W) {
				
				if(iGrafo.getAresta() == pesos.getVertices()) {
					
					peso = pesos.getPesoAresta();
					
					break;
				}				
				
			}			
			
		} catch (Exception e) {
			System.out.printf("\nObterPesoAresta -> ", e.getMessage());
			return peso;
		}
		
		return peso;
			
	}
	
	// Adiciona grafo ao vetor auxKey caso o peso do grafo seja menor que o grafo do auxKey
	public static void AdicionaAoVetor(Grafo minGrafo, Grafo grafo, String OP){
		
		Integer index = 0;
        Integer subStrMinGrafoLen = 0;
        Integer subStrGrafoLen = 0;
        
        String verticeA = "";
        String verticeB = "";
        
        subStrMinGrafoLen = minGrafo.getAresta().split(",").length;
        subStrGrafoLen = grafo.getAresta().split(",").length;
        
        try {
        	
        	if(subStrMinGrafoLen > 1) {
            	verticeA = minGrafo.getAresta().substring(0, minGrafo.getAresta().indexOf(","));
            }
            else {
            	verticeA = minGrafo.getAresta();
            }
            
            if(subStrGrafoLen > 1) {
            	verticeB = grafo.getAresta().substring(grafo.getAresta().indexOf(",") + 1, grafo.getAresta().length());
            }
            else {
            	verticeB = grafo.getAresta();
            }
    	
    		if(OP == "PI") {
    			
    			for (Grafo p : PI) {
    				
    				if(p.getID() == grafo.getID()) {
    					
    					PI.get(index).setCustoAresta(grafo.getCustoAresta());
    					PI.get(index).setAresta(grafo.getAresta());
    					PI.get(index).setID(grafo.getID());
    					
    					break;
    					
    				}
    				
    				index++;
    				
    			}
    		}
    		else {
    			for (Grafo ak : auxKey) {
    				
    				if(ak.getID() == grafo.getID()) {
    					
    					for (PesoArestas PA : W) {
    						
    											
    						if(ak.getAresta().equals(PA.getVertices())) {
    							
    							auxKey.get(index).setCustoAresta(PA.getPesoAresta());
    							auxKey.get(index).setAresta(grafo.getAresta());
    							auxKey.get(index).setID(grafo.getID());
    							
    							break;		
    						}
    						
    					}
    										
    				}
    				
    				index++;
    				
    			}
    		}
			
		} catch (Exception e) {
			System.out.printf("\nAdicionaAoVetor -> ", e.getMessage());
		}
        	
	}
	//validação
	// verifica se o vertice esta conectado e o peso das arestas. Escolhe a aresta de menor peso
	public static void ContainsVerticeAuxKey(){

        Integer subStrMinGrafoLen = 0;
        Integer iAuxKeyLen = 0;
        Integer menorValorAresta = 0;
        Integer menorValorAresta2 = 0;
        Integer aux2IndexAnterior = 0;
        Integer index = 0;
        
        String strArestaGrafo = "";        
        String iAuxKeyStr = "";
        
        boolean primeiraIteracao = true;
        
        ArrayList<Grafo> adjRemove = new ArrayList<Grafo>();
        ArrayList<Grafo> newAuxKey = new ArrayList<Grafo>();
        ArrayList<Grafo> teste = new ArrayList<Grafo>();
 
        Grafo grafoAnterior = new Grafo();

        try {
        	
        	for (Integer i = 0 ; i<auxKey.size() ; i++) {
            	newAuxKey.add(auxKey.get(i));
    		}
            
            for (Grafo aux : newAuxKey) {

            	subStrMinGrafoLen = aux.getAresta().split(",").length;
            	menorValorAresta = aux.getCustoAresta();
            	
            	if(subStrMinGrafoLen <= 1) {
            		continue;
            	}
                
                if(subStrMinGrafoLen > 1) {
                	strArestaGrafo = aux.getAresta().substring(0, aux.getAresta().indexOf(","));
                }
                else {
                	strArestaGrafo = aux.getAresta();
                }
                
                ArrayList<Grafo> g = new ArrayList<Grafo>();
                //Obtem os adjacentes
                g = VerticesAdjacentes(aux, newAuxKey);
                
        		
        		for (Grafo aux2 : g) {

        			iAuxKeyLen = aux2.getAresta().split(",").length;
        			menorValorAresta2 = aux2.getCustoAresta();
        			
        			if(iAuxKeyLen <= 1) {
                		continue;
                	}
        			
        			if(iAuxKeyLen > 1) {
        				iAuxKeyStr = aux2.getAresta().substring(0, aux2.getAresta().indexOf(","));
        	        }
        	        else {
        	        	iAuxKeyStr = aux2.getAresta();
        	        }
        			
        			// verdadeiro? Adjacente : n�o adjacente
        			if(iAuxKeyStr.equals(strArestaGrafo)) {
        				
        				if(menorValorAresta2 < menorValorAresta) {
        					
        					if(ContemArestaNoVetorFinal(adjRemove, aux2) > -1) {
        						// Seta aresta reversa
		        				SetaArestaReversa(adjRemove, aux2);
        						continue;
        					}
        					
        					if(!adjRemove.contains(aux2)) {
        						
        							if(VerificaMenorArestaDeUmGrupo(adjRemove, aux2) > -1) {
        								// � menor, entao seta o valor antigo para false
        								adjRemove.get(VerificaMenorArestaDeUmGrupo(adjRemove, aux2)).setArestaConectada(false);
        								
        								aux2.setArestaConectada(true);
        		        				
        								adjRemove.add(aux2);
        							}else {
        								aux2.setArestaConectada(true);
        		        				//Setar aresta com maior valor para false
        								adjRemove.add(aux2);
        							}

		        			}        					
        					
        				}
        				
        			}
    
        			menorValorAresta = aux2.getCustoAresta();

        		} 	
     		
        		primeiraIteracao = true;
        	}
            
            for (Grafo adjRem : adjRemove) {
            	
            	if(adjRem.getArestaConectada()) {
            		
            		System.out.printf("Aresta: %S Peso: %d\n", adjRem.getAresta(), adjRem.getCustoAresta());
            	}
    		}
			
		} catch (Exception e) {
			System.out.printf("\nContainsVerticeAuxKey -> ", e.getMessage());
		}       
		
	}
	//Validação pra ver qual a menor aresta do grupo.
public static Integer VerificaMenorArestaDeUmGrupo(ArrayList<Grafo> grafo, Grafo grafoProcurado) {
	
	ArrayList<Grafo> ret = new ArrayList<Grafo>();
	Integer index = 0;
	String arestaProcurada = "";
	
	arestaProcurada = grafoProcurado.getAresta().substring(0, grafoProcurado.getAresta().indexOf(","));
	
//	ret = VerticesAdjacentes(grafoProcurado, grafo);
	
	for (Grafo g : grafo) {
		
		if(g.getArestaConectada()) {
			
			if(g.getAresta().substring(0, g.getAresta().indexOf(",")).equals(arestaProcurada)) {
				
				if(grafoProcurado.getCustoAresta() < g.getCustoAresta()) {
					return index;
				}
		
			}
			
		}
		
		index++;
		
	}
	
	return -1;
	
}
	//Validação caso pra aresta reversa
public static void SetaArestaReversa(ArrayList<Grafo> grafo, Grafo grafoProcurado) {
		
		String strArestaGrafoProcurado = "";
		Integer index = 0;
		
		strArestaGrafoProcurado = new StringBuilder(grafoProcurado.getAresta()).reverse().toString();
		
		for (Grafo g : grafo) {
			// vetorFinal ja possui a aresta na lista
			if(g.getAresta().equals(strArestaGrafoProcurado)) {
				grafo.get(index).setArestaConectada(true);
			}
			
			index++;
		}
		
	}
	
	public static Integer ContemArestaNoVetorFinal(ArrayList<Grafo> grafo, Grafo grafoProcurado) {
		
		String strArestaGrafoProcurado = "";
		Integer index = 0;
		
		strArestaGrafoProcurado = new StringBuilder(grafoProcurado.getAresta()).reverse().toString();
		
		for (Grafo g : grafo) {
			// vetorFinal ja possui a aresta na lista
			if(g.getAresta().equals(strArestaGrafoProcurado)) {
				return index;
			}
			
			index++;
		}
		
		return -1;
		
	}
	
	public static Grafo procuraElementoNoVetorFinal(Grafo grafoProcurado, ArrayList<Grafo> listaAserProcurada) {
		
		String strGrafoAdj = "";
		Grafo grafoEncontrado = new Grafo();
		
		strGrafoAdj = new StringBuilder(grafoProcurado.getAresta()).reverse().toString();
		
		for (Grafo g : listaAserProcurada) {
			
			if(strGrafoAdj.equals(g.getAresta())) {
				
				grafoEncontrado.setAresta(g.getAresta());
				grafoEncontrado.setArestaConectada(g.getArestaConectada());
				grafoEncontrado.setCustoAresta(g.getCustoAresta());
				grafoEncontrado.setID(g.getID());
				
				grafoEncontrado = g;
				
				return grafoEncontrado;
			}else {
				
				return grafoProcurado;
				
			}
			
		}
		
		return grafoProcurado;
		
	}
	
	// Verifica se o vertice do grafo pesquisa est� conectado
	public static Boolean isConnected(Grafo grafo) {
		
		String strVerticeProcurado = "";
		String strVerticeVetorAuxKey = "";
		
		Integer countVerticeProcurado = 0;
		Integer countVerticeVetorAuxKey = 0;
		
		ArrayList<Grafo> teste = new ArrayList<Grafo>();
				
		countVerticeProcurado = grafo.getAresta().split(",").length;
		
		try {
			
			if(countVerticeProcurado > 1) {
				strVerticeProcurado = grafo.getAresta().substring(0, grafo.getAresta().indexOf(","));		
			}
			else {
				strVerticeProcurado = grafo.getAresta();
			}
	      
	        Integer index = 0;
	        
	        for (Grafo g : auxKey) {
	        	
	        	countVerticeVetorAuxKey = g.getAresta().split(",").length;
	        	
	        	if(countVerticeVetorAuxKey > 1) {
	        		strVerticeVetorAuxKey = g.getAresta().substring(0, g.getAresta().indexOf(","));		
	    		}
	    		else {
	    			strVerticeVetorAuxKey = g.getAresta();
	    		}
	        	
	        	if(strVerticeVetorAuxKey.equals(strVerticeProcurado)) {
	        		if(g.getArestaConectada()) {
	        			// Esta conectado
	        			return true;
	        		}
	        		else {
	        			teste.add(g);
	        			auxKey.get(index).setArestaConectada(true);
	        		}
	        	}        	
	        	
	        	index++;
				
			}
			
		} catch (Exception e) {
			System.out.printf("\nisConnected -> ", e.getMessage());
			return null;
		}
		
        // N�o esta conectado
		return false;
		
	}
	
	
	public static Grafo VerificaAuxiliarKEY(Grafo grafo, ArrayList<Grafo> aux){
		
		Grafo auxGrafo = new Grafo();
		
		try {
			
			for (Grafo g : aux) {
				
				if(g.getID() == grafo.getID()) {
					
					auxGrafo = g;
					
					return auxGrafo;
				}
				
			}
			
			return auxGrafo;
			
		} catch (Exception e) {
			System.out.printf("\nVerificaAuxiliarKEY -> ", e.getMessage());
			return null;
		}
		
	}
	
//  Retorna uma lista com os vertices adjacentes ao vertice procurado
	public static ArrayList<Grafo> VerticesAdjacentes(Grafo minGrafo, ArrayList<Grafo> G){
		ArrayList<Grafo> listAdj = new ArrayList<Grafo>();
		
		int minGrafoLen = 0;
		int GLen = 0;
		
		String strminGra = "";
		String strGLen = "";
		
		try {
			
			minGrafoLen = minGrafo.getAresta().split(",").length;
			
			if(minGrafoLen > 1) {
				strminGra = minGrafo.getAresta().substring(0, minGrafo.getAresta().indexOf(","));
			}
			else {
				strminGra = minGrafo.getAresta();
			}
			
			for (Grafo g : G) {
				
				GLen = g.getAresta().split(",").length;
				
				if(GLen > 1) {
					strGLen = g.getAresta().substring(0, g.getAresta().indexOf(","));
				}
				else {
					strGLen = g.getAresta();
				}
				
				if(strminGra.equals(strGLen)) {
					listAdj.add(g);
				}
				
			}
			
			return listAdj;
			
		} catch (Exception e) {
			System.out.printf("\nVerticesAdjacentes -> ", e.getMessage());
			return null;
		}
		
		
		
	}
	
//	Extrai o Grafo de menor valor de aresta
	public static Grafo EXTRACT_MIN(ArrayList<Grafo> Q){
		Integer menorValor;
		Grafo menorGrafo = new Grafo();
		Boolean encontrou = false;
		
		Grafo grafoIndice0 = new Grafo();
		
		try {
			
			grafoIndice0 = Q.get(0);
			
			menorValor = grafoIndice0.getCustoAresta();			
	
			for( Grafo grafo2 : Q )
		    {
				if(grafo2.getCustoAresta() < menorValor) {
					
					menorValor = grafo2.getCustoAresta();
					menorGrafo = grafo2;
					encontrou = true;
					
				}

		    }
			
			if(encontrou) {
				Q.remove(menorGrafo);
				
				return menorGrafo;
			}
			else {
				Q.remove(grafoIndice0);	
				
				return grafoIndice0;
			}
		
		} 
		catch (Exception e) {
			System.out.printf("\nEXTRACT_MIN -> ", e.getMessage());
			return null;
		}
			
	}
	
	
}


