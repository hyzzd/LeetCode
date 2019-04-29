class Main {
    // consider removing the character one by one from the ending
    // if there is common char, remove it from strings and append to LCS
    public static int longestCS(String[] list) {
        int dp[][][] = new int[list[0].length() + 1][list[1].length() + 1][list[2].length() + 1];
        for (int i = 1; i <= list[0].length(); i++) {
            for (int j = 1; j <= list[1].length(); j++) {
                for (int k = 1; k <= list[2].length(); k++) {
                    if (list[0].charAt(i - 1) == list[1].charAt(j - 1)
                            && list[1].charAt(j - 1) == list[2].charAt(k - 1)) {
                        dp[i][j][k] = 1 + dp[i - 1][j - 1][k - 1];
                    } else {
                        dp[i][j][k] = Math.max(Math.max(dp[i - 1][j][k], dp[i][j - 1][k]), dp[i][j][k - 1]);
                    }
                }
            }
        }

        return dp[list[0].length()][list[1].length()][list[2].length()];
    }

    public static void main(String[] args) {
        String[] str = { "epidemiologist", "refrigeration", "supercalifragilisticexpialodocious" };
        System.out.println(longestCS(str));
    }
}