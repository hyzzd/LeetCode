class Main {
    public boolean isPalin(int num) {
        if (num < 0)
            return false;
        if (num == 0)
            return true;
        int numRe = 0;
        while (num > 0) {
            numRe += num % 10;
            num /= 10;
        }

        return num == numRe;
    }
}