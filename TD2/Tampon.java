
package td2;

import java.util.ArrayList;

public class Tampon {
    private final ArrayList<String> queue =  new ArrayList<>();
    public Tampon(){}
    
    public void put(String value){
        queue.add(value);
    }
    
    public String get() {
        int lastIndex = queue.size() - 1;
        if(lastIndex < 0){
            return null;
        }
        String lastValue = queue.get(lastIndex); 
        queue.remove(lastIndex);
        return lastValue;
    }
}