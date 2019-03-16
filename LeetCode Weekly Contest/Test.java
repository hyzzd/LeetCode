import java.util.*;

class Main {
    public static void main(String[] args) {
        String s = "AaaAAaCCccBB";

        if (s == null || s.length() == 0) {
            System.out.println("invalid input");
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b) {
                return -a.getValue().compareTo(b.getValue());
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> tt : list) {
            sb.append(tt.getKey().toString()).append(":").append(tt.getValue().toString()).append(";");
        }

        System.out.println(sb.toString());
    }
}