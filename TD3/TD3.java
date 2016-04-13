package td3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TD3 {
    private static final Logger log = Logger.getLogger(TD3.class.getName());

    public static void main(String[] args) {
        String line;
        String[] parts;
        ArrayList<String> madames = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("C:/TD3/ListePersonnes.txt"))){
            while((line = br.readLine()) != null){
                parts = line.split(" ");
                if(parts[0].equals("Mme.")){
                    madames.add(line);
                }
            }
        }catch(IOException e){
            log.log(Level.SEVERE, e.toString(), e);
        }
        
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        Sched CPUScheduler = new Sched();
        CPUScheduler.start();
        WriteThread t1 = new WriteThread(madames, "Thread 1");
        t1.start();
        CPUScheduler.addThread(t1);
        WriteThread t2 = new WriteThread(madames, "Thread 2");
        t2.start();
        CPUScheduler.addThread(t2);
    }
}