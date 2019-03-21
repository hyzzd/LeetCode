import java.util.List;

class Main {
    public List<String> findStrobogrammatic(int n) {
        List<String> answer = new ArrayList<String>();
        helper(n, "", answer);
        return answer;
    }

    private void helper(int n, String s, List<String> answer) {
        String[] s1 = new String[] { "0", "1", "8" };
        String[] s2 = new String[] { "00", "11", "88", "69", "96" };

        if (n == 0) {
            answer.add(s);
            return;
        }

        if (n == 1) {
            for (int i = 0; i < s1.length; i++)
                answer.add(s.substring(0, s.length() / 2) + s1[i] + s.substring(s.length() / 2));

            return;
        }

        if (s != "") {
            helper(n - 2, s.substring(0, s.length() / 2) + s2[0] + s.substring(s.length() / 2), answer);
        }
        for (int i = 1; i < s2.length; i++) {
            helper(n - 2, s.substring(0, s.length() / 2) + s2[i] + s.substring(s.length() / 2), answer);
        }
    }
}