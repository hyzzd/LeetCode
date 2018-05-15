class Solution {
    public int rotatedDigits(int N) {
        int ans = 0;
        for(int i = 1; i <= N; ++i){
            if(isValid(i)) ans++;
        }
        return ans;
    }
    
    public boolean isValid(int n){
        boolean rotate = false;
        while(n > 0){
            if(n % 10 == 2) rotate = true;
            if(n % 10 == 5) rotate = true;
            if(n % 10 == 6) rotate = true;
            if(n % 10 == 9) rotate = true;
            if(n % 10 == 3) return false;
            if(n % 10 == 4) return false;
            if(n % 10 == 7) return false;
            n /= 10;
        }
        return rotate;
    }
}
// O(log(n)^2)
// O(1)
