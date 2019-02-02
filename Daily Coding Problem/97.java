import java.util.HashMap;
import java.util.Map;

class Main {
    Map<Integer, Map<Integer, Integer>> map;
    // Or use ArrayList then O(n)
    Main(){
        map = new HashMap<>();
    }
    
    public void set(int key, int value, int time){
        if(!map.containsKey(key)){
            map.put(key, new HashMap<Integer, Integer>(){{put(time, value);}});
        }else{
            map.get(key).put(time, value);
        }
    }
    
    public int get(int key, int time){
        if(!map.containsKey(key))
            return Integer.MIN_VALUE;
        if(!map.get(key).containsKey(time)){
            int temp = time;
            while(temp >= 0){
                if(map.get(key).containsKey(--temp)){
                    return map.get(key).get(temp);
                }                
            }
            
            return Integer.MIN_VALUE;
        }
        
        return map.get(key).get(time);
    }
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}