import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ManipuladorArquivo {
	
	static ArrayList<PesoArestas> ArrayPesosArestas = new ArrayList<PesoArestas>();
	static ArrayList<Grafo> ArrayGrafos = new ArrayList<Grafo>();
	static boolean pulaLinhaAresta = false;

	public static void leitor(String path) throws IOException {
		
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		
		String linha = "";
		Integer indexLinha = 0;
		
		try {
			
			while (true) {
				if (linha != null) {
					VerificaConteudoLinha(linha,indexLinha);	
				} else
					break;
				linha = buffRead.readLine();

				indexLinha++;
			}
			
			System.out.println();

			buffRead.close();
			
		} catch (Exception e) {
			System.out.printf("\nManipuladorArquivo.leitor -> ", e.getMessage());
		}
		
		
	}
	
	private static void VerificaConteudoLinha(String _linha, Integer _indexLinha) {
		
		ArrayList<String> tokenLinha = new ArrayList<String>();
		String[] strToken;
		Grafo grafo = new Grafo();
		PesoArestas pesoAresta = new PesoArestas();
		
		try {
			
			if(_indexLinha == 1){
				if(_linha.trim().equals("1")) {
					System.out.println("< Grafo direcionado >");
				} else {
					System.out.println("< Grafo não direcionado >");
				}			
			}
			if(_indexLinha == 2){
				System.out.printf("\nNúmero de vértices: %s\n", _linha);
			}
			if(_indexLinha > 2){
				
				if(_linha.split(",").length == 1) {
					
					System.out.printf("\nVértice: %s", _linha);
					
					grafo.setAresta(_linha);
					ArrayGrafos.add(grafo);
				}
									
			}
			if(_indexLinha > 2){
				
				if(_linha.split(",").length > 1) {
					
					strToken = _linha.trim().split(",");
					pesoAresta.setPesoAresta(Integer.parseInt(strToken[2]));
					pesoAresta.setVertices(strToken[0] + "," + strToken[1]);
					ArrayPesosArestas.add(pesoAresta);
					
					if(pulaLinhaAresta == false) {
						System.out.println("\n\nArestas:");
					}
					
					pulaLinhaAresta = true;
					
					System.out.printf("\nAresta: %s,%s Peso: %s", strToken[0],strToken[1], strToken[2]);
					
					grafo.setAresta(strToken[0] + "," + strToken[1]);
					grafo.setCustoAresta(Integer.parseInt(strToken[2]));
					ArrayGrafos.add(grafo);
				}
									
			}
			
		} catch (Exception e) {
			System.out.printf("\nManipuladorArquivo.VerificaConteudoLinha -> ", e.getMessage());
		}

	}

}