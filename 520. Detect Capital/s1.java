class Solution {
    public boolean detectCapitalUse(String word) {
        if(word == null || word.length() < 2) return true;
        char[] ch = word.toCharArray();

        if(Character.isUpperCase(ch[0])){ // K--
            if(Character.isUpperCase(ch[1])){
                for(char c: ch){
                    if(Character.isLowerCase(c))
                        return false;
                }
            }else{ // Kk--
                for(int i = 1; i < ch.length; ++i){
                    if(Character.isUpperCase(ch[i]))
                        return false;
                }
            }
        }else{ // k--
            for(char c: ch){
                if(Character.isUpperCase(c))
                    return false;
            }
        }
        return true;        
    }
}
// O(n)
// O(n)
