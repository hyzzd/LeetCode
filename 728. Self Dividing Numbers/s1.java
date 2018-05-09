class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList();
        for(int i = left; i <= right; ++i){
            if(isDivide(i))  list.add(i);
        }
        return list;
    }
    public boolean isDivide(int num){
        int k = num;
        while(k % 10 != 0){
            if(num % (k % 10) == 0) k /= 10;
            else return false;
        }
        if(k == 0) return true;
        else return false;
    }
}
// brute force
// O(nlogR) n is the number, R is the right value
// O(n) length
