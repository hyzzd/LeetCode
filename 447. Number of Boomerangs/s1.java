class Solution {
    public int numberOfBoomerangs(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>(); // only need to store the number of combines
        int ans = 0;
        for(int i = 0; i < points.length; ++i){
            for(int j = 0; j < points.length; ++j){
                if(i != j){
                    int d = dist(points[i], points[j]);
                    map.put(d, map.getOrDefault(d, 0)+1);
                }
            }
            for(Integer val: map.values()){
                ans += val*(val-1);//map.getOrDefault(i, 0);
            }
            map.clear();
        }
        
        return ans;
    }
    
    public int dist(int[] a, int[] b){
        return (a[0]-b[0])*(a[0]-b[0])+(a[1]-b[1])*(a[1]-b[1]);
    }
}
// O(n^2)
// O(n)
