class Main {
    public static void printMatrix(int[][] matrix){
        int k = 0, l = 0, m = matrix.length, n = matrix[0].length;
        while(k < m && l < n){
            for(int i = l; i < n; ++i){
                System.out.println(matrix[k][i]);
            }
            k++;
            for(int i = k; i < m; ++i){
                System.out.println(matrix[i][n - 1]);
            }
            n--;
            if(k < m){
                for(int i = n - 1; i >= l; --i){
                    System.out.println(matrix[m - 1][i]);
                }
                m--;
            }
            if(l < n){
                for(int i = m - 1; i >= k; --i){
                    System.out.println(matrix[i][l]);
                }
                l++;
            }            
        }        
    }
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
            {1,  2,  3,  4,  5},
         {6,  7,  8,  9,  10},
         {11, 12, 13, 14, 15},
         {16, 17, 18, 19, 20}
        };
        
        printMatrix(matrix);
    }
}