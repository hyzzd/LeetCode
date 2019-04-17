class Main {
    public static int countMatrix(int[][] mat, int i1, int j1, int i2, int j2) {
        if (mat == null)
            return 0;
        int res = 0, m = mat.length, n = mat[0].length;
        res += (i1 + 1) * (j1 + 1) - 1;
        res += findRes(mat, i1, j1, true);
        res += (m - i2) * (n - j2);
        res += findRes(mat, i2, j2, false);
        return res;
    }

    private static int findRes(int[][] mat, int i, int j, boolean reverse) {
        int m = mat.length, n = mat[0].length;
        int res = 0;

        for (int p = 0; p < i; p++) {
            for (int q = j + 1; q < n; q++) {
                if (reverse) {
                    if (mat[p][q] < mat[i][j])
                        res++;
                } else {
                    if (mat[p][q] > mat[i][j])
                        res++;
                }

            }
        }

        for (int p = i + 1; p < m; p++) {
            for (int q = 0; q < j; q++) {
                if (reverse) {
                    if (mat[p][q] < mat[i][j])
                        res++;
                } else {
                    if (mat[p][q] > mat[i][j])
                        res++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] mat = { { 1, 3, 7, 10, 15, 20 }, { 2, 6, 9, 14, 22, 25 }, { 3, 8, 10, 15, 25, 30 },
                { 10, 11, 12, 23, 30, 35 }, { 20, 25, 30, 35, 40, 45 } };
        System.out.println(countMatrix(mat, 1, 1, 3, 3));
    }
}