public class Solution {
    public String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        int i = 0;
        int j = ch.length - 1;
        while (i < j){
            if(isVowel(ch[i])){
                for (int k = j; k > i; k--){
                    if(isVowel(ch[k])){
                        char temp;
                        temp = ch[i];
                        ch[i] = ch[k];
                        ch[k] = temp;
                        j = k - 1;
                        break;
                    }
                }
            }
            i++;
        }
        return String.valueOf(ch);
    }

    private boolean isVowel(char ch){
        if (ch == 'a') return true;
        if (ch == 'e') return true;
        if (ch == 'i') return true;
        if (ch == 'o') return true;
        if (ch == 'u') return true;
        if (ch == 'A') return true;
        if (ch == 'E') return true;
        if (ch == 'I') return true;
        if (ch == 'O') return true;
        if (ch == 'U') return true;
        return false;
    }

}
