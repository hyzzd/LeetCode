import java.util.*;

class Main {
    public static void solution(int n) {
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);
        for (int i = 2; i * i <= n; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = false;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (primes[i]) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        solution(100);
        System.out.println("Hello World");
    }
}