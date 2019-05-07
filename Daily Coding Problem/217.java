import java.util.*;

class Main {
    public static int sparseNum(int n) {
        List<Integer> bits = new ArrayList<>();
        while (n != 0) {
            bits.add(n & 1);
            n >>= 1;
        }
        // extra bit
        bits.add(0);
        int lastFinal = 0;
        for (int i = 1; i < bits.size() - 1; i++) {
            if (bits.get(i) == 1 && bits.get(i - 1) == 1 && bits.get(i + 1) != 1) {
                bits.set(i + 1, 1);
                for (int j = i; j >= lastFinal; j--) {
                    bits.set(j, 0);
                }
                lastFinal++;
            }
        }

        int ans = 0;
        for (int i = 0; i < bits.size(); i++) {
            ans += bits.get(i) * (1 << i);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(sparseNum(15));
    }
}