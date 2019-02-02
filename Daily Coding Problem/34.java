class Main {
    public int findInsert(char[] str, int l, int h){
        if(l > h) return Integer.MAX_VALUE;
        if(l == h) return 0;
        if(l == h - 1) return (str[l] == str[h]) ? 0 : 1;
        
        return (str[l] == str[h]) ? 
            findInsert(str, l + 1, h - 1) :
            (Math.min(findInsert(str, l, h - 1),
                     findInsert(str, l + 1, h)) + 1);
    }
    public static void main(String[] args) {
        Main m = new Main();
        String str = "google";
        
        System.out.println(new StringBuilder(str.substring(str.length() - m.findInsert(str.toCharArray(), 0, str.length() - 1), str.length())).reverse().toString() + str);
    }
}