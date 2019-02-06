class Main {
    public int solution(int N, int X) {
        int result = 0;

        for (int i = 1; i <= N; ++i) {
            for (int j = 1 * i; j <= N * i; j += i) {
                if (j == X)
                    result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}