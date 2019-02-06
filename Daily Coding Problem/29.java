class Main {
    public String encoding(String s) {
        if (s == null || s.length() == 0)
            return "";

        StringBuilder sb = new StringBuilder();

        char curr = '!';
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (curr == ch) {
                count++;
            } else {
                sb.append(count);
                sb.append(curr);
                curr = ch;
                count = 1;
            }
        }
        sb.append(count);
        sb.append(curr);

        return sb.toString().substring(2);
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.encoding("AAAABBBCCDAA"));
    }
}