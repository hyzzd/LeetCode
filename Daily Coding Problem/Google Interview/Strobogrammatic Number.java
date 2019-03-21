class Main {
    public boolean isStrobogrammatic(String num) {
        int left = 0, right = num.length() - 1;
        while (left <= right) {
            if (!"00 11 88 696".contains(num.charAt(left) + "" + num.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}