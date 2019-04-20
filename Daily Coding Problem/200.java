import java.util.*;

class Main {
    public static List<Integer> stabs(List<int[]> intervals) {
        Collections.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0])
                    return b[1] - a[1];
                else
                    return a[0] - b[0];
            }
        });

        Set<Integer> set = new HashSet<>();
        int min = 0;
        for (int i = intervals.size() - 1; i >= 0; i--) {
            if (set.size() == 0) {
                set.add(intervals.get(i)[0]);
                min = intervals.get(i)[0];
            } else if (intervals.get(i)[1] < min) {
                set.add(intervals.get(i)[0]);
                min = Math.min(min, intervals.get(i)[0]);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i : set) {
            res.add(i);
        }

        return res;
    }

    public static void main(String[] args) {
        List<int[]> intervals = new ArrayList<>();
        intervals.add(new int[] { 1, 4 });
        intervals.add(new int[] { 4, 5 });
        intervals.add(new int[] { 7, 9 });
        intervals.add(new int[] { 9, 12 });
        List<Integer> res = stabs(intervals);
        for (int i : res) {
            System.out.println(i);
        }
    }
}