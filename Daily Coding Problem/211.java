class Main {
    public static void kmp(String pat, String txt) {
        int m = pat.length();
        int n = txt.length();

        int lps[] = new int[m];
        int j = 0;

        computeLps(pat, m, lps);
        int i = 0;
        while (i < n) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }
            if (j == m) {
                System.out.println(i - j);
            } else if (i < n && txt.charAt(i) != pat.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i = i + 1;
                }
            }
        }
    }

    private static void computeLps(String pat, int m, int[] lps) {
        int len = 0;
        int i = 1;
        lps[0] = 0;
        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        kmp(pat, txt);
    }
}