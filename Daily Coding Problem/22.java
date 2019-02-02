import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Main {
    public boolean strMatch(String s, Set<String> wordDict){
        int[] pos = new int[s.length() + 1];
        
        Arrays.fill(pos, -1);
        //initial state
        pos[0] = 0;
        
        for(int i = 0; i < s.length(); ++i){
            if(pos[i] != -1){
                for(int j = i + 1; j < s.length(); ++j){
                    String sub = s.substring(i, j);
                    if(wordDict.contains(sub)){
                        pos[j] = i;
                    }
                }
            }
        }
        
        return pos[s.length()] != -1;
    }
    public static void main(String[] args) {
        Main m = new Main();
        Set<String> set = new HashSet<>();
        set.add("the");
        set.add("quick");
        set.add("brown");
        set.add("fox");
        boolean result = m.strMatch("thequickbrownfox", set);
        
        System.out.println(result);
    }
}