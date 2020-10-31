
package primalgorithm;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class ManipuladorArquivo {
    static ArrayList ArrayPesosArestas = new ArrayList();
    static ArrayList ArrayVertices = new ArrayList();
    static ArrayList ArrayConfig = new ArrayList();
    static String[] vertices_list;
    static Boolean Erro = false;
    
    public static void coletarDados() {
    File file = new File("C:/Users/caiom/Git/PRIM-algorithm/grafo.txt");
    Scanner text = null;
    Integer line_number = 0;
    String nomeVertices = "";
    Integer qtd_vertice = 0; 
    String[] strToken;
    Configuracao config = new Configuracao();

    try{
        text = new Scanner(file);

        while(text.hasNextLine()) {
            Vertice vertices = new Vertice();
            Aresta aresta = new Aresta();
            String line = text.nextLine();
            line_number++;
            
            if(line.isEmpty()){
                System.out.println("ERRO:GRAFO COM LINHA EM BRANCO!!");
                Erro = true;
                break;
            }
            
            if (line_number == 1){
                switch(line){
                    case "1":
                        System.out.println("Grafo direcionado !!");
                        config.Direcionado = true;
                        break;
                    case "2":
                        System.out.println("Grafo direcionado !!");
                        config.Direcionado = false;
                        break;
                    default:
                        System.out.println("ERRO: TIPO DE GRAFO INVÁLIDO !!");
                        Erro = true;
                        break;
                }
            
            }
            
            if (line_number == 2){
                qtd_vertice = Integer.parseInt(line);
            }
            
            //Nome dos vertices
            if (line_number > 2 && line_number <= (2 + qtd_vertice) ){
                vertices.setNome(line);
                ArrayVertices.add(vertices);
                
                nomeVertices+= line + ","; 
            }
            
            //Arestas
            if ( line_number > (2 + qtd_vertice) ){
                if (line.split(",").length > 1){
                    strToken = line.trim().split(",");
                    aresta.setPesoAresta(Integer.parseInt(strToken[2]));
                }else {
                    strToken = line.trim().split(",");
                    aresta.setPesoAresta(1);
                }
                aresta.setVerticeOrigem(strToken[0]);
                aresta.setVerticeDestino(strToken[1]);
                ArrayPesosArestas.add(aresta);
                
            }
            

        }
        
        config.setVerticeInicial(PrimAlgorithm.verticeInicial);
        ArrayConfig.add(config);
        
        if (!Erro){
            vertices_list =  nomeVertices.trim().split(","); 
            System.out.println("São " + qtd_vertice + " vertices, sendo eles: " + nomeVertices);
        }
        

    } catch(IOException e) {
        System.out.println(e.getMessage());
    }
    
    text.close();
    }

    private static void Switch(String line) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
