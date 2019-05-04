import java.util.*;

class Main {
    public static int longestOnes(int n) {
        if (n <= 0)
            return 0;
        int res = 1, cur = 0;
        String s = Integer.toBinaryString(n);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                if (s.charAt(i - 1) == '1') {
                    cur++;
                } else {
                    cur = 1;
                }
            } else {
                cur = 0;
            }

            res = Math.max(res, cur);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestOnes(128));
        System.out.println(longestOnes(130));
        System.out.println(longestOnes(131));
        System.out.println(longestOnes(156));
    }
}