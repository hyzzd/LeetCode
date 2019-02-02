class Main {
    public static int swapBits(int x){
        int evenBits = x & 10101010;
        int oddBits = x & 01010101;
        evenBits >>= 1;
        oddBits <<= 1;
        return (evenBits | oddBits);
    }
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}