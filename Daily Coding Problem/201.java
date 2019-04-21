import java.util.*;

class Main {
    static class Pair {
        int idx;
        int lvl;
        int val;

        Pair(int idx, int lvl, int val) {
            this.idx = idx;
            this.lvl = lvl;
            this.val = val;
        }
    }

    private static int max;

    public static int maxWeight(List<List<Integer>> tri) {
        max = tri.get(0).get(0);
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, 0, tri.get(0).get(0)));
        while (!q.isEmpty()) {
            Pair node = q.poll();
            int value = node.val;
            if (node.lvl + 1 < tri.size()) {
                List<Integer> list = tri.get(node.lvl + 1);
                q.offer(new Pair(node.idx, node.lvl + 1, list.get(node.idx) + value));
                q.offer(new Pair(node.idx + 1, node.lvl + 1, list.get(node.idx + 1) + value));
                value += Math.max(list.get(node.idx), list.get(node.idx + 1));
            }
            max = Math.max(max, value);
        }

        return max;
    }

    public static void main(String[] args) {
        List<List<Integer>> tri = new ArrayList<>();
        List<Integer> li1 = new ArrayList<>();
        li1.add(1);
        tri.add(li1);
        List<Integer> li2 = new ArrayList<>();
        li2.add(2);
        li2.add(3);
        tri.add(li2);
        List<Integer> li3 = new ArrayList<>();
        li3.add(1);
        li3.add(5);
        li3.add(2);
        tri.add(li3);
        System.out.println(maxWeight(tri));
    }
}