class Solution {
    int count = 0;

    public int countArrangement(int N) {
        boolean[] visited = new boolean[N + 1];
        calculate(visited, N, 1);
        return count;
    }

    public void calculate(boolean[] visited, int N, int l) {
        if (l > N)
            count++;
        for (int i = 1; i <= N; ++i) {
            if (!visited[i] && (l % i == 0 || i % l == 0)) {
                visited[i] = true;
                calculate(visited, N, l + 1);
                visited[i] = false;
            }
        }
    }
}
// O(number of valid permutation)
// O(n)
