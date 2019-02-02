import java.util.HashMap;
import java.util.Map;

class Main
{
    public static void main(String[] args) {
        char[] chs = new char[]{'G', 'G', 'R', 'B', 'R', 'B'};
        char[] ch = countLength(chs);
        for(char c : ch){
            System.out.println(c);
        }
    }
    
    public static char[] countLength(char[] ch){
        int n = ch.length;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < n; ++i){
            if(!map.containsKey(ch[i])){
                map.put(ch[i], 1);
            }else{
                map.put(ch[i], map.get(ch[i])+1);
            }
        }
        int r = 0, g = map.get('R'), b = n - map.get('B');
        Map<Character, Integer> clr = new HashMap<>();
        clr.put('R', 0);
        clr.put('G', 0);
        clr.put('B', 0);
        
        for(int i = 0; i < n; ++i){
            while(ch[i] != should(i, map)){
                swap(ch, i, map.get(ch[i]) + clr.get(ch[i]));
                clr.put(ch[i], clr.get(ch[i])+1);
            }
        }
        
        return ch;
    }
    
    public static void swap(char[] ch, int i, int j){
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
    
    public static char should(int i, Map<Character, Integer> map){
        if(i < map.get('R')){
            return 'R';
        }else if(i < map.get('R') + map.get('G')){
            return 'G';
        }else{
            return 'B';
        }
    }
}