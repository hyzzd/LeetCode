import java.util.ArrayList;

class Main {
    public String[] solution1(String[] arr, String s){
        if(arr == null || arr.length == 0){
            return null;
        }
        
        ArrayList<String> result = new ArrayList<>();
        for(String str : arr){
            if(str.indexOf(s) == 0){
                result.add(str);
            }
        }
        
        return result.toArray(new String[result.size()]);
    }
    public String[] trieTree(String[] arr, String s){
        //https://www.geeksforgeeks.org/auto-complete-feature-using-trie/
        return null;
    }
    public static void main(String[] args) {
        Main m = new Main();
        String[] result = m.solution1(new String[]{"dog", "deer", "deal"}, "de");
        
        for(String str : result){
            System.out.println(str);
        }        
    }
}
