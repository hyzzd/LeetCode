class Solution {
    public String toGoatLatin(String S) {
        String[] string = S.split("\\s");
        StringBuilder str = new StringBuilder();
        int count = 0;
        for (String s : string) {
            count++;
            char[] ch = s.toLowerCase().toCharArray();
            if (ch[0] == 'a' || ch[0] == 'e' || ch[0] == 'i' || ch[0] == 'o' || ch[0] == 'u') {
                str.append(s);
            } else {
                // char[] cha = s.toCharArray();
                // char[] c = new char[cha.length];
                // for(int i = 0; i < cha.length; ++i)
                // c[(i-1+cha.length)%(cha.length)] = cha[i];
                // str.append(String.valueOf(c));
                str.append(s.substring(1));
                str.append(s.charAt(0));
            }
            str.append("ma");
            for (int i = 0; i < count; ++i)
                str.append("a");
            str.append(" ");
        }
        return str.toString().trim();
    }
}
// intuitive
// O(n*(n+l)) n number of words, l avg length of word l = N/n, worst O(N^2)
// O(N+n^2), worst O(N^2)
