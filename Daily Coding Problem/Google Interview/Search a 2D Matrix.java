class Main {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0;
        int end = row * col - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid / col][mid % col] == target) {
                return true;
            } else if (matrix[mid / col][mid % col] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (matrix[0][0] == target || matrix[row - 1][col - 1] == target) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String args[]) {
        Main m = new Main();
        int[][] matrix = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
        System.out.print(m.searchMatrix(matrix, 3));
    }
}