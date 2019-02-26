class Solution {
    public String toHex(int num) {
        if (num == 0)
            return String.valueOf(num);
        StringBuilder sb = new StringBuilder();

        while (num != 0) {
            int digit = num & 0xf;
            sb.append(digit < 10 ? (char) (digit + '0') : (char) (digit - 10 + 'a'));
            num >>>= 4;
        }

        return sb.reverse().toString();
    }
}
