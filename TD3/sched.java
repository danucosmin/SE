package td3;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sched extends Thread {
    private static final Logger log = Logger.getLogger(Sched.class.getName());
    
    private Queue q;
    private int burst;
    private Thread current;
    public Sched() {
        this.setPriority(6);
        log.log(Level.INFO, "Set to priority 6: {0}", this.getName());
        burst = 1000;
        q = new LinkedList();
    }
    public Sched(int b) {
        burst = b;
        q = new LinkedList();
    }
    public void addThread(Thread t){
        q.offer(t);
        log.log(Level.INFO, "Thread added: {0}", t.getName());
    }
    public void executeThread(){
        try{
            log.log(Level.INFO, "Executing: {0}", current.getName());
            Thread.sleep(burst);
        }catch(InterruptedException ex){
			log.log(Level.SEVERE, ex.toString(), ex);
		}
    }
    public void run(){
        while(true){
            current = (Thread)q.poll();
            if(current!=null){
                log.log(Level.INFO, "Current thread to execute: {0}", current.getName());
                executeThread();
            }
            else{
                if(q.isEmpty()){
                    log.log(Level.INFO, "Queue is already empty...");
                    break;
                }
            }
        }
    }
}