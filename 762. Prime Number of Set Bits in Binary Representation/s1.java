class Solution {
    public int countPrimeSetBits(int L, int R) {
        int ans = 0;
        for (int i = L; i <= R; ++i) {
            if (isPrime(i))
                ans++;
        }
        return ans;
    }

    public boolean isPrime(int n) {
        int count = Integer.bitCount(n);
        Set<Integer> set = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19)); // 10^6 < 2^20
        return set.contains(count);
    }
}
// store a dict to check prime directly
// O(n)
// O(1)
