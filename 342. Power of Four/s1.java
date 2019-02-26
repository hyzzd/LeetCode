public class Solution {
    public boolean isPowerOfFour(int num) {
        if (num == 0)
            return false;
        while (num != 0) {
            if (num == 1)
                return true;
            if (num % 4 != 0) {
                System.out.print(num);
                return false;
            } else {
                num = num / 4;
            }
        }
        return true;
    }
}

/*
 * public class Solution { public boolean isPowerOfFour(int num) { if(num <= 0)
 * return false; return ((num - 1) & num) == 0 && (num & 0x55555555) != 0; //
 * 注意 & 的优先级比 == 低 }
 */
