
package td2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class TD2 {
   
    public static void main(String[] args) {
        Tampon queue = new Tampon();
        ArrayList<String> Madames = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("C:/TD2/ListePersonnes.txt"))) {
            while ((line = br.readLine()) != null) {
                if(line.indexOf(".") == 1){
                    queue.put(line);
                }else{
                    Madames.add(line);
                }
            }
            br.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
        for(String name : Madames){
            queue.put(name);
        }
        
        Consumer consumer = new Consumer(queue);
        consumer.start();
    }
    
}
