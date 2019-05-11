import java.util.*;

class Main {
    public static int sevenish(int n) {
        // 1 -- 1
        // 1 7 8 -- 3
        // 1 7 8 49 50 56 57 -- 7
        // 2 * (n + 1) - 1
        int power = 0;
        List<Integer> nums = new ArrayList<>();
        while (nums.size() < n) {
            int num = (int) Math.pow(7, power);
            List<Integer> curr = new ArrayList<>();
            curr.add(num);
            for (Integer old : nums) {
                if (nums.size() + curr.size() == n)
                    return curr.get(curr.size() - 1);

                curr.add(num + old);
            }

            nums.addAll(curr);
            power++;
        }

        return nums.get(nums.size() - 1);
    }

    public static void main(String[] args) {
        System.out.println(sevenish(1));
        System.out.println(sevenish(2));
        System.out.println(sevenish(3));
        System.out.println(sevenish(7));
        // 1 7 8 57
    }
}