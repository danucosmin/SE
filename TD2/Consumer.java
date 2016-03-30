
package td2;

import java.io.BufferedWriter;
import java.io.FileWriter;


public class Consumer extends Thread {
    private final Tampon queue;
    
    public Consumer(Tampon queue){
        this.queue = queue;
    }
    
    @Override
    public void run(){
        String name;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:/TD2/Bonjour.txt"))) {
            while((name = this.queue.get()) != null){
                bw.append(name + "\n");
            }
            bw.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}