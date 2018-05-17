public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: magazine.toCharArray()) map.put(c, map.getOrDefault(c, 0)+1);
        for(char c: ransomNote.toCharArray()){
            if(!map.containsKey(c) || map.getOrDefault(c, 0) <= 0){
                return false;
            }else{
                map.put(c, map.getOrDefault(c, 0)-1);
            }
        } 
        return true;
    }
}
// O(n)
// O(n)
