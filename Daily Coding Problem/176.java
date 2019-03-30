import java.util.*;

class Main {
    public static boolean oneToOneMapping(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            if (map.containsKey(s1.charAt(i))) {
                if (map.get(s1.charAt(i)) != s2.charAt(i)) {
                    return false;
                }
            } else {
                map.put(s1.charAt(i), s2.charAt(i));
            }
        }
        return true;
    }

    public static void main(String[] args){
        System.out.print(oneToOneMapping("foo", "bar"));
    }
}