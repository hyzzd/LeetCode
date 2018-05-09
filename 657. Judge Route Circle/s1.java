class Solution {
    public boolean judgeCircle(String moves) {
        char[] chars = moves.toCharArray();
        int a = 0, b = 0;
        for(int i = 0; i < chars.length; ++i){
            if(chars[i] == 'U'){
                a++;
            }else if(chars[i] == 'D'){
                a--;
            }else if(chars[i] == 'L'){
                b++;
            }else if(chars[i] == 'R'){
                b--;
            }
        }
        if(a == 0 && b == 0)
            return true;
        else 
            return false;
    }
}
