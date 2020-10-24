package primalgorithm;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author Caio Henrique MAchado de Olivera
 */

public class PrimAlgorithm {
    public static void main(String[] args) {
        File file = new File("C:/Users/caiom/Git/PRIM-algorithm/grafo.txt");
        Scanner text = null;

        try{
            text = new Scanner(file);
            while(text.hasNextLine()) {
                String line = text.nextLine();
                
                
                if(line.isEmpty()){
                    System.out.println("O grafo fornecido contém linha em branco, favor apagar!!");
                }
            }
            
            
      
            
  
            
            
        } catch(IOException e) {
            System.out.println(e.getMessage());
        } finally{
            text.close();
        }
        
        
        
    }

   
    
}
