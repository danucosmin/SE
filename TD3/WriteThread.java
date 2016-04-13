package td3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WriteThread extends Thread {
    private static final Logger log = Logger.getLogger(WriteThread.class.getName());
    private static ArrayList<String> madames = new ArrayList<>();
    
    public WriteThread(ArrayList<String> madames, String s){
        super(s);
        WriteThread.madames =  madames;
    }
    
    @Override
    public void run(){
        String name;
        try(BufferedWriter bw =  new BufferedWriter(new FileWriter("C:/TD3/Bonjour.txt"))){
            while((name = WriteThread.madames.get(WriteThread.madames.size()-1)) != null){
                bw.append(name + "\n");
                WriteThread.madames.remove(WriteThread.madames.size()-1);
            }
            bw.close();
        } catch(Exception e) {
            log.log(Level.INFO, e.getMessage());
        }
    }
}
