public boolean selfDividing(int n) {
    for (char c: String.valueOf(n).toCharArray()) {
        if (c == '0' || (n % (c - '0') > 0))
            return false;
    }
    return true;
}
// alternative implementation
