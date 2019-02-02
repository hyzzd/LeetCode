class Main {
    public int longestDir(String s){
        if(s == null || s.length() == 0)
            return 0;
        
        //StringBuilder sb = new StringBuilder();
        
        String[] str = s.split("\n");
        String[] strTrim = new String[str.length];
        String tab = "\t";
        
        for(int i = 0; i < str.length; ++i){
            strTrim[i] = str[i].trim();
        }
        
        for(int i = 0; i < str.length; ++i){
            for(int j = i + 1; j < str.length; ++j){
                str[j] = str[j].replaceFirst(tab, "/" + strTrim[i]);
            }
        }
        
        int maxLen = 0;
        for(int i = 0; i < str.length; ++i){
            if(maxLen < str[i].length()){
                maxLen = str[i].length();
            }
        }
        
        return maxLen;
    }
    public static void main(String[] args) {
        Main m = new Main();
        
        System.out.println(m.longestDir("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
    }
}