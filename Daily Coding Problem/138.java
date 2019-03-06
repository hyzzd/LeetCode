import java.util.Arrays;

class Main {
    public static int minCoins(int[] coins, int V) {
        int[] table = new int[V + 1];
        Arrays.fill(table, Integer.MAX_VALUE);
        table[0] = 0;
        for (int i = 1; i <= V; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    int subRes = table[i - coins[j]];
                    if (subRes != Integer.MAX_VALUE && subRes + 1 < table[i]) {
                        table[i] = subRes + 1;
                    }
                }
            }
        }

        return table[V];
    }

    public static void main(String[] args) {
        int coins[] = { 25, 10, 5, 1 };
        int V = 16;
        System.out.println(minCoins(coins, V));
    }
}