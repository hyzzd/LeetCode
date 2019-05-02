class Main {
    public static String alpha(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int rem = n % 26;
            if (rem == 0) {
                sb.append("Z");
                n = (n / 26) - 1;
            } else {
                sb.append((char)((rem - 1) + 'A'));
                n /= 26;
            }
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(alpha(1));
        System.out.println(alpha(26));
        System.out.println(alpha(27));
        System.out.println(alpha(51));
        System.out.println(alpha(52));
        System.out.println(alpha(80));
        System.out.println(alpha(676));
        System.out.println(alpha(702));
        System.out.println(alpha(705));
    }
}