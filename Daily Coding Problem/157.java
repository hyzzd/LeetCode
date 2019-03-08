class Main {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int[] arr = new int[26];
        for (char c : s.toLowerCase().toCharArray()) {
            arr[c - 'a'] += 1;
        }
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {
                if (s.length() % 2 == 1) {
                    if (!flag) {
                        flag = true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}