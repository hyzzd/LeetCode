class Solution {
    public String convertToBase7(int num) {
        if(num == 0) return "0";
        StringBuilder s = new StringBuilder();
        boolean negative = false;
        if(num < 0) negative = true;
        while(num != 0){
            s.append(Math.abs(num % 7));
            num /= 7;
        }
        if(negative) s.append("-");
        return s.reverse().toString();
    }
}
// O(lg7n)
// O(n)
