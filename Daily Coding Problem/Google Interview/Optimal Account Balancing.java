import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Main {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] i : transactions) {
            map.put(i[0], map.getOrDefault(i[0], 0) + i[2]);
            map.put(i[1], map.getOrDefault(i[1], 0) - i[2]);
        }
        List<Integer> acct = new ArrayList<>();
        for (int p : map.keySet()) {
            if (map.get(p) != 0) {
                acct.add(map.get(p));
            }
        }
        return dfs(0, 0, acct);
    }

    private int dfs(int idx, int num, List<Integer> acct) {
        int res = Integer.MAX_VALUE;
        int siz = acct.size();
        while (idx < siz && acct.get(idx) == 0) {
            idx++;
        }
        for (int i = idx + 1; i < siz; i++) {
            if (acct.get(i) * acct.get(idx) < 0) {
                acct.set(i, acct.get(i) + acct.get(idx));
                res = Math.min(res, dfs(idx + 1, num + 1, acct));
                acct.set(i, acct.get(i) - acct.get(idx));
            }
        }
        return res == Integer.MAX_VALUE ? num : res;
    }
}