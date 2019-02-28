class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        // S = "aaa";
        List<List<Integer>> ans = new LinkedList<>();
        if (S.length() < 3)
            return ans;
        int j = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (i == S.length() - 1 || S.charAt(i) != S.charAt(i + 1)) {
                if (i - j + 1 >= 3) {
                    ans.add(Arrays.asList(new Integer[] { j, i }));
                }
                j = i + 1;
            }
        }

        return ans;
    }
}
// O(n)
// O(n)
