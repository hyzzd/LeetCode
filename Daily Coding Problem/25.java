class Main {
    public boolean regex(String s, String reg) {
        if (s == null || s.length() == 0) {
            return false;
        }

        int idx = 0;
        for (int i = 0; i < reg.length(); ++i) {
            if (reg.charAt(i) != '.' && reg.charAt(i) != '*') {
                if (s.charAt(idx) != reg.charAt(i)) {
                    return false;
                } else {
                    idx++;
                }
            } else if (reg.charAt(i) == '.') {
                idx++;
            } else {
                while (reg.charAt(i) == '*') {
                    i++;
                }

                String newReg = reg.substring(i, reg.length());
                for (int j = idx; j < s.length(); ++j) {
                    if (regex(s.substring(j, s.length()), newReg)) {
                        return true;
                    }
                }
                return false;
            }
        }

        return idx == s.length();
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.regex("chat", "**c**.*a."));
    }
}