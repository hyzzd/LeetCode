import java.util.*;

class Main {
    public int findDist(int target, Map<Integer, List<Node>> dict) {
        if (target == 0) {
            return 0;
        }

        List<Node> candidate = dict.get(target);
        List<Integer> dists = new ArrayList<>();
        for (int i = 0; i < candidate.size(); i++) {
            int dist = candidate.get(i).dist + findDist(candidate.get(i).start, dict);
            dists.add(dist);
        }

        return Collections.min(dists);
    }

    public int getShortestTrip(int[][] edges, int count) {
        Map<Integer, List<Node>> dict = new HashMap<>();
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            int dist = edge[2];
            if (!dict.containsKey(end)) {
                dict.put(end, new ArrayList<>());
            }
            dict.get(end).add(new Node(start, dist));
        }

        List<Integer> dists = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            int dist = findDist(target, dict);
            dists.add(dist);
        }
        return Collections.max(dists);
    }
}

class Node {
    int start;
    int dist;
}