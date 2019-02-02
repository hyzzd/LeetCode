class Main {
    public static void main(String[] args) {        
        System.out.println(countDecoded("111"));
    }
    public static int countDecoded(String s){
        char[] ch = s.toCharArray();
        int n = ch.length;
        
        return helper(ch, n);
    }
    private static int helper(char[] ch, int n){
        if(n == 0 || n == 1){
            return 1;
        }
        
        int count = 0;
        if(ch[n - 1] > '0'){
            count = helper(ch, n - 1);
        }
        if(ch[n - 2] == '1' || ch[n - 2] == '2' && ch[n - 1] < '7'){
            count += helper(ch, n - 2);
        }
        
        return count;
    }
}