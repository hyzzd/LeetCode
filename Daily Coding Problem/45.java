class Main {
    public int rand7(){
        int[][] vals = new int[][]{
            { 1, 2, 3, 4, 5 },
            { 6, 7, 1, 2, 3 },
            { 4, 5, 6, 7, 1 },
            { 2, 3, 4, 5, 6 },
            { 7, 0, 0, 0, 0 }
        };

        int result = 0;
        while (result == 0)
        {
            int i = rand5();
            int j = rand5();
            result = vals[i-1][j-1];
        }
        return result;
    }
    
    private int rand5() {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}