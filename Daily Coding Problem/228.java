import java.util.*;

class Main {
    public static long largestPossibleInteger(String[] arr) {
        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return -(s1 + s2).compareTo(s2 + s1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String a : arr) {
            sb.append(a);
        }
        return Long.parseLong(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(largestPossibleInteger(new String[] { "10", "7", "76", "415" }));
    }
}