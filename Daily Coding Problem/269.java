import java.util.*;

class Main {
    public String getOrientation(String[] dominos) {
        List<String> arr = new ArrayList<>(Arrays.asList(dominos));
        arr = helper(arr);
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }
        return sb.toString();
    }

    private List<String> helper(List<String> dominos) {
        int changes = 0;
        List<String> new_dominos = dominos.copy();

        for (int i = 0; i < dominos.size(); i++) {
            if (dominos.get(i) == "L" && i > 0 && dominos.get(i - 1) == "." && dominos(i - 2) != "R") {
                new_dominos.set(i - 1, "L");
                changes += 1;
            } else if (dominos.get(i) == 'R' && i < dominos.size() - 1 && dominos.get(i + 1) == "."
                    && dominos.get(i + 2) != "L") {
                new_dominos.set(i + 1, "R");
                changes += 1;
            }
        }

        return changes ? helper(new_dominos) : dominos;
    }
}