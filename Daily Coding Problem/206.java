import java.util.*;

class Main {
    public static String[] perm(String[] s, int[] arr) {
        List<String> list = new ArrayList<>();
        for (int i : arr) {
            list.add(s[i]);
        }

        return list.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] s = new String[] { "a", "b", "c" };
        int[] arr = new int[] { 2, 1, 0 };
        s = perm(s, arr);
        for (String ss : s) {
            System.out.println(ss);
        }
    }
}