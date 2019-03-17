import java.util.ArrayList;
import java.util.List;

class Main {
    public List<String> findMissingRanges(int[] A, int lower, int upper) {
        List<String> list = new ArrayList<>();
        int pre = lower - 1;
        for (int i = 0; i <= A.length; i++) {
            int post = i == A.length ? upper + 1 : A[i];
            if (pre + 2 == post) {
                list.add(String.valueOf(pre + 1));
            } else if (pre + 2 < post) {
                list.add(String.valueOf(pre + 1) + "->" + String.valueOf(post - 1));
            }
            pre = post;
        }
        return list;
    }

    public static void main(String args[]) {
        Main m = new Main();
        int[] nums = new int[] { 0, 1, 3, 50, 75 };
        List<String> list = m.findMissingRanges(nums, 0, 99);
        for (String li : list) {
            System.out.print(li + " ");
        }
    }
}