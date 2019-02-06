class Main {
    static boolean isRotation(String s1, String s2) {
        return (s1.length() == s2.length()) && ((s1 + s1).indexOf(s2) > -1);
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}