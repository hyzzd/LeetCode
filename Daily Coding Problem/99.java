import java.util.HashSet;
import java.util.Set;

class Main {
    public int longestSeq(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currNum = num;
                int currStreak = 1;

                while (set.contains(currNum + 1)) {
                    currNum += 1;
                    currStreak += 1;
                }

                longest = Math.max(longest, currStreak);
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}