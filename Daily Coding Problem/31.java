class Main {
    public int editDist(String s1, String s2, int m, int n){
        
        if(m == 0) return n;
        if(n == 0) return m;
        
        if(s1.charAt(m - 1) == s2.charAt(n - 1))
            return editDist(s1, s2, m - 1, n - 1);
        
        return 1 + Math.min(Math.min(
            editDist(s1, s2, m, n - 1),
            editDist(s1, s2, m - 1, n)),
            editDist(s1, s2, m - 1, n - 1)
        );
    }
    public static void main(String[] args) {
        Main m = new Main();
        String s1 = "kitten";
        String s2 = "sitting";
        
        System.out.println(m.editDist(s1, s2, s1.length(), s2.length()));
    }
}