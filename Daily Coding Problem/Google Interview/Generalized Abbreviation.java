import java.util.*;

class Main {
    public static List<String> generateAbbreviations(String word) {
        List<String> res = new LinkedList<>();
        dfs(word, new StringBuilder(), 0, res);
        return res;
    }

    private static void dfs(String word, StringBuilder sb, int idx, List<String> res) {
        if (idx == word.length()) {
            res.add(sb.toString());
            return;
        }
        String copy = sb.toString();
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) >= '0' && sb.charAt(sb.length() - 1) <= '9') {
            char previous = sb.charAt(sb.length() - 1);
            if (previous == '9') {
                sb.setCharAt(sb.length() - 1, '1');
                sb.append('0');
            } else {
                sb.setCharAt(sb.length() - 1, (char) (previous + 1));
            }
        } else {
            sb.append('1');
        }

        dfs(word, sb, idx + 1, res);

        sb = new StringBuilder(copy);
        sb.append(word.charAt(idx));
        dfs(word, sb, idx + 1, res);
    }

    public static void main(String[] args){
        List<String> list = generateAbbreviations("word");
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}