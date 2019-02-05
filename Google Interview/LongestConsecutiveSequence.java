import java.util.HashSet;
import java.util.Set;

class Main {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int result = 1;
        for (int i : nums) {
            int left = i - 1;
            int right = i + 1;
            int count = 1;
            while (set.contains(left)) {
                count++;
                set.remove(left);
                left--;
            }
            while (set.contains(right)) {
                count++;
                set.remove(right);
                right++;
            }
            result = Math.max(result, count);
        }
        return result;
    }

    public static void main(String args[]) {
        Main m = new Main();
        int[] nums = new int[] { 100, 4, 200, 1, 3, 2 };
        System.out.print(m.longestConsecutive(nums));
    }
}