
package primalgorithm;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class ManipuladorArquivo {
    static ArrayList<PesoArestas> ArrayPesosArestas = new ArrayList<PesoArestas>();
    static ArrayList ArrayVertices = new ArrayList();
    static String[] vertices_list;
    
    public static void coletarDados() {
    File file = new File("C:/Users/caiom/Git/PRIM-algorithm/grafo.txt");
    Scanner text = null;
    Integer line_number = 0;
    String nomeVertices = "";
    Integer qtd_vertice = 0; 
    String[] strToken;
    

    try{
        text = new Scanner(file);

        while(text.hasNextLine()) {
            Vertice vertices = new Vertice();
            PesoArestas pesoAresta = new PesoArestas();
            
            line_number++;
            String line = text.nextLine();

            if (line.equals("1") && line_number == 1){
            System.out.println("Grafo direcionado !!");
            }
            
            if (line.equals("2") && line_number == 1){
                System.out.println("Grafo não direcionado !!");
            }
            
            if (line_number == 2){
                System.out.println("Número de vértices: " + line);
                qtd_vertice = Integer.parseInt(line);
            }
            
            //Nome dos vertices
            if (line_number > 2 && line_number <= (2 + qtd_vertice) ){
                vertices.setNome(line);
                ArrayVertices.add(vertices);
                
                nomeVertices+= line + ", "; 
            }
            
            //Arestas
            if ( line_number > (2 + qtd_vertice) ){
                if (line.split(",").length > 1){
                    strToken = line.trim().split(",");
                    pesoAresta.setPesoAresta(Integer.parseInt(strToken[2]));
                }else {
                    strToken = line.trim().split(",");
                    pesoAresta.setPesoAresta(1);
                }
                
                pesoAresta.setVerticeOrigem(strToken[0]);
                pesoAresta.setVerticeDestino(strToken[1]);
                ArrayPesosArestas.add(pesoAresta);
                
            }
            
            if(line.isEmpty()){
                System.out.println("ERRO: O grafo fornecido contém linha em branco, favor apagar!!");
            }
        }
        vertices_list =  nomeVertices.trim().split(",");
        System.out.println("Os Vertices são: " + nomeVertices);

    } catch(IOException e) {
        System.out.println(e.getMessage());
    } finally{
        System.out.println("Arquivo lido com sucesso !!");
    }
        text.close();
    }

}
