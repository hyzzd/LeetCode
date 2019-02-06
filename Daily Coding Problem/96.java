import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Main {
    public List<List<Integer>> permut(int[] nums) {
        List<List<Integer>> result = new LinkedList();
        ArrayList<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }

        int n = nums.length;
        backtrack(n, numsList, result, 0);
        return result;
    }

    public void backtrack(int n, ArrayList<Integer> numsList, List<List<Integer>> result, int first) {
        if (first == n) {
            result.add(numsList);
        }
        for (int i = first; i < n; i++) {
            Collections.swap(numsList, first, i);
            backtrack(n, numsList, result, first + 1);
            Collections.swap(numsList, first, i);
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}