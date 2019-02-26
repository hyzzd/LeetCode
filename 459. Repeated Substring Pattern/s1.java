class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int l = s.length();
        for (int i = 1; i <= l / 2; i++) {
            if (l % i == 0) {
                int n = l / i;
                String subS = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++)
                    sb.append(subS);
                if (sb.toString().equals(s))
                    return true;
            }
        }
        return false;
    }
}
