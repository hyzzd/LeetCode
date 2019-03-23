import java.util.*;

class Main {
    public static List<List<String>> findPath(String start, String end, Set<String> dict) {
        List<List<String>> res = new LinkedList<>();
        if (start.length() != end.length()) {
            return res;
        }
        dfs(start, end, dict, new HashSet<String>(), new LinkedList<String>(), res);
        return res;
    }

    private static void dfs(String curr, String end, Set<String> dict, Set<String> visited, List<String> path,
            List<List<String>> res) {
        if (curr.equals(end)) {
            List<String> sec = new LinkedList<>();
            for(int i = 0; i < path.size(); i++){
                sec.add(path.get(i));
            }
            res.add(sec);
            return;
        }

        for (String s : dict) {
            if (diff(s, curr) && !visited.contains(s)) {
                visited.add(s);
                path.add(s);
                dfs(s, end, dict, visited, path, res);
                visited.remove(s);
                path.remove(path.size() - 1);
            }
        }
    }

    private static boolean diff(String s1, String s2) {
        boolean flag = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i) && !flag) {
                flag = true;
            } else if (s1.charAt(i) != s2.charAt(i) && flag) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("dot");
        set.add("dop");
        set.add("dat");
        set.add("cat");
        List<List<String>> res = findPath("dog", "cat", set);
        for (List<String> sl : res) {
            for (String s : sl) {
                System.out.println(s);
            }
            System.out.println();
        }
    }
}