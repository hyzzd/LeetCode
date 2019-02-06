class Main {
    public static void SieveOfEratosthenes(int n, boolean[] isPrime) {
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i <= n; i++)
            isPrime[i] = true;

        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p] == true) {
                for (int i = p * 2; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
        }
    }

    public static void findPrimePair(int num) {
        boolean[] isPrime = new boolean[num + 1];
        SieveOfEratosthenes(num, isPrime);

        for (int i = 0; i < num; i++) {
            if (isPrime[i] && isPrime[num - i]) {
                System.out.println(i + " " + (num - i));
                return;
            }
        }
    }

    public static void main(String[] args) {
        findPrimePair(74);
    }
}