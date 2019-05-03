import java.util.*;

class Main {
    public static List<String> ip(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<String> t = new ArrayList<String>();
        dfs(result, s, 0, t);

        ArrayList<String> finalResult = new ArrayList<String>();

        for (ArrayList<String> l : result) {
            StringBuilder sb = new StringBuilder();
            for (String str : l) {
                sb.append(str + ".");
            }
            sb.deleteCharAt(sb.length() - 1);
            finalResult.add(sb.toString());
        }

        return finalResult;
    }

    private static void dfs(ArrayList<ArrayList<String>> result, String s, int i, ArrayList<String> t) {
        if (t.size() >= 4 && i != s.length())
            return;
        if (t.size() + s.length() - i + 1 < 4)
            return;
        if (t.size() == 4 && i == s.length()) {
            ArrayList<String> tmp = new ArrayList<>(t);
            result.add(tmp);
            return;
        }
        for (int j = 1; j <= 3; j++) {
            if (i + j > s.length())
                break;
            String sub = s.substring(i, i + j);
            if (j > 1 && s.charAt(i) == '0')
                break;
            if (Integer.parseInt(sub) > 255)
                break;
            t.add(sub);
            dfs(result, s, i + j, t);
            t.remove(t.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> list = ip("2542540123");
        for (String s : list) {
            System.out.println(s);
        }
    }
}