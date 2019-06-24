import java.util.*;

class Main {
    public List<Integer> getPaid(int[] nums) {
        return getPaidUtil(nums, 0, nums.length - 1);
    }

    public List<Integer> getPaidUtil(int[] nums, int start, int end) {
        List<Integer> res = new ArrayList<>();

        if (end - start == 0)
            return res;
        if (end - start == 1)
            return res.add(1);

        int min = Integer.MAX_VALUE, mini = -1;
        for (int i = start; i <= end; i++) {
            if (nums[i] < min) {
                min = nums[i];
                mini = i;
            }
        }

        int i = mini - 1, j = mini + 1;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int prev = nums[mini], count = 0;
        while (i >= start && nums[i] > prev) {
            left.add(0, ++count);
        }
        prev = nums[mini];
        count = 0;
        while (j <= end && nums[j] > prev) {
            right.add(++count);
        }

        if (i != start - 1) {
            res.addAll(getPaidUtil(nums, start, i));
        }
        res.addAll(left);
        res.add(1);
        res.addAll(right);
        if (j != end + 1) {
            res.addAll(getPaidUtil(nums, j, end));
        }

        return res;
    }
}