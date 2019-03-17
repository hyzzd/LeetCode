import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, zeros = 0, zeroIdx = -1;
        for (int l = 0, r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                zeros++;
                if (zeros == 1) {
                    zeroIdx = r;
                }
            }
            if (zeros == 2) {
                l = zeroIdx + 1;
                zeros--;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
        // int max = 0, k = 1;
        // Queue<Integer> q = new LinkedList<>();
        // for (int l = 0, r = 0; r < nums.length; r++) {
        // if (nums[r] == 0) {
        // q.offer(r);
        // }
        // if (q.size() > k) {
        // l = q.poll() + 1;
        // }
        // max = Math.max(max, r - l + 1);
        // }
        // return max;
    }

    public static void main(String[] args) {
        System.out.print(findMaxConsecutiveOnes(new int[] { 1, 0, 1, 1, 0, 1 }));
    }
}