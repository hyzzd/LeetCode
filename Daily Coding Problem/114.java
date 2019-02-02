import java.util.List;
import java.util.ArrayList;

class Main {
    public static String reverseWords(String s){
        StringBuilder sb = new StringBuilder();
        int len = s.length(), idx = 0;
        List<String> listW = new ArrayList<>();
        List<String> listC = new ArrayList<>();
        boolean flag = Character.isLetter(s.charAt(0)); // f - char, t - word
        int ldx = 0;
        while(idx++ < len){
            if(flag && !Character.isLetter(s.charAt(idx))){
                listW.add(s.substring(ldx, idx));
                ldx = idx;
                flag = false;
            }
            if(!flag && Character.isLetter(s.charAt(idx))){
                listC.add(s.substring(ldx, idx));
                ldx = idx;
                flag = true;
            }
        }
        
        for(int i = listW.size() - 1, j = 0; i >= 0 && j < listC.size(); i--, j++){
            sb.append(listW.get(i)).append(listC.get(j));
        }
        
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(reverseWords("hello/world:here/"));
    }
}