import java.util.*;

class Main {
    public static List<Integer> maxSet(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i : arr) {
            if (list.size() == 0) {
                list.add(new ArrayList<Integer>(Arrays.asList(i)));
                continue;
            }

            boolean found = false;
            for (List<Integer> li : list) {
                int t = li.get(li.size() - 1);
                if (i % t == 0 || t % i == 0) {
                    if (i < t) li.add(0, i);
                    else li.add(i);
                    found = true;
                    break;
                }
            }

            if (!found) {
                list.add(new ArrayList<Integer>(Arrays.asList(i)));
            }
        }

        int max = 0;
        List<Integer> res = new ArrayList<>();
        for (List<Integer> li : list) {
            if (max < li.size()) {
                max = li.size();
                res = li;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] a1 = { 3, 5, 10, 20, 21 };
        int[] a2 = { 1, 3, 6, 24 };
        List<Integer> res1 = maxSet(a1);
        for (int i : res1) {
            System.out.print(i + " ");
        }
        System.out.println();

        List<Integer> res2 = maxSet(a2);
        for (int i : res2) {
            System.out.print(i + " ");
        }
    }
}