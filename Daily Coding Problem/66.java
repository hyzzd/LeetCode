class Main {
    public int myFun() {
        int val1 = toss_biased();
        int val2 = toss_biased();

        if (val1 == 1 && val2 == 0)
            return 0;
        if (val1 == 0 && val2 == 1)
            return 1;

        return myFun();
    }

    private int toss_biased() {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}