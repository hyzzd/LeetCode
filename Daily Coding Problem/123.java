class Main {
    public static boolean isNumber(String toTest) {
        boolean isNegativeFoundAlready = false;
        boolean isDecimalPointFoundAlready = false;
        boolean isScientificFoundAlready = false;
        for (int i = 0; i < toTest.length(); i++) {
            if (!"0123456789-.e".contains(new String(new char[] { toTest.charAt(i) }))) {
                return false;
            } else {
                if ('-' == toTest.charAt(i) && i != 0) {
                    return false;
                }
                if ('-' == toTest.charAt(i) && (i == toTest.length() - 1)) {
                    return false;
                }
                if ('-' == toTest.charAt(i) && isNegativeFoundAlready) {
                    return false;
                }
                if ('-' == toTest.charAt(i)) {
                    isNegativeFoundAlready = true;
                }
                if ('.' == toTest.charAt(i) && isDecimalPointFoundAlready) {
                    return false;
                }
                if ('.' == toTest.charAt(i)) {
                    isDecimalPointFoundAlready = true;
                }
                if ('.' == toTest.charAt(i) && (i == toTest.length() - 1)) {
                    return false;
                }
                if ('e' == toTest.charAt(i) && isScientificFoundAlready) {
                    return false;
                }
                if ('e' == toTest.charAt(i)) {
                    isScientificFoundAlready = true;
                    return isNumber(toTest.substring(i + 1));
                }
            }
        }
        return true;
    }

    public static void main(String args[]) {
        System.out.println(isNumber("10"));
        System.out.println(isNumber("-10"));
        System.out.println(isNumber("10.1"));
        System.out.println(isNumber("-10.1"));
        System.out.println(isNumber("1e5"));
        System.out.println(isNumber("a"));
        System.out.println(isNumber("x 1"));
        System.out.println(isNumber("a -2"));
        System.out.println(isNumber("-"));
    }
}