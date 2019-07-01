class Main {
    public int throwDice(int num, int faces, int total) {
        if (num < 1 || total < 1) {
            return 0;
        } else if (num == 1 && 1 <= total && total <= faces) {
            return 1;
        }

        int sum = 0;
        for (int x = 1; x <= faces; x++) {
            sum += throwDice(num - 1, faces, total - x);
        }
        return sum;
    }
}