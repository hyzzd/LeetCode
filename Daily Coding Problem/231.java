class Main {
    public static String rearr(String s) {
        char[] ch = s.toCharArray();
        for (int i = 1; i < s.length(); i++) {
            if (ch[i - 1] != ch[i]) {
                continue;
            } else {
                int j = i + 1;
                while (j++ < s.length()) {
                    if (ch[j] != ch[i]) {
                        char t = ch[i];
                        ch[i] = ch[j];
                        ch[j] = t;
                        break;
                    }
                }
            }
        }
        return new String(ch);
    }

    public static void main(String[] args) {
        System.out.println(rearr("aaabbc"));
    }
}