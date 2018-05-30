class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        return sourceToTarget(graph, 0);
    }
    public List<List<Integer>> sourceToTarget(int[][] graph, int node){
        int n = graph.length;
        List<List<Integer>> ans = new ArrayList<>();
        if(node == n - 1){
            List<Integer> path = new ArrayList<>();
            path.add(n - 1);
            ans.add(path);
            return ans;
        }
        for(int neighbor : graph[node]){
            for(List<Integer> path : sourceToTarget(graph, neighbor)){
                path.add(0, node);
                ans.add(path);
            }
        }
        return ans;
    }
}
// O(2^N*N^2)
// O(2^N*N)
