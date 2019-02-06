class Main {
    // the problem is simplyfied to be checking if one line of letters is ordered or
    // not
    public boolean isOrdered(String s) {
        char temp = 'a';
        for (char c : s.toCharArray()) {
            if (temp > c) {
                return false;
            }

            temp = c;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}