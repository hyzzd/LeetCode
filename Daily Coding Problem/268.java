class Main {
    public static boolean isPowerOfFour(int x) {
        return ((x & -x) & 0x55555554) == x;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(1024));
    }
}