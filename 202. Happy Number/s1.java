class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int square = 0, remain = 0;
        while(set.add(n)){
            square = 0;
            while(n > 0){
                remain = n % 10;
                square += remain * remain;
                n /= 10;
            }
            if(square == 1) return true;
            else n = square;
        }
        return false;
    }
}
