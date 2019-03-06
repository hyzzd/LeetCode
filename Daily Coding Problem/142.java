class Main {
    public static boolean isBalanced(String str) {
        int lo = 0, hi = 0;// smallest and largest possible number of open left brackets
        for (char c : str.toCharArray()) {
            lo += c == '(' ? 1 : -1;
            hi += c != ')' ? 1 : -1;
            if (hi < 0)
                break;
            lo = Math.max(lo, 0);
        }
        return lo == 0;
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("(()*"));
        System.out.println(isBalanced(")*("));
    }
}