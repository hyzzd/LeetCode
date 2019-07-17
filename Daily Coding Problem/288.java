import java.util.*;

class Main {
    private int KAP_CONST = 6174;

    public int kproc(int num) {
        return kprocUtil(num, 0);
    }

    private int kprocUtil(int num, int steps) {
        if (num == KAP_CONST)
            return steps;

        char[] digits = String.valueOf(num).toCharArray();
        Arrays.sort(digits);
        String ascNum = String.valueOf(digits);
        String dscNum = new StringBuilder(ascNum).reverse().toString();
        int diff = Integer.parseInt(dscNum) - Integer.parseInt(ascNum);
        return kprocUtil(diff, steps + 1);
    }
}