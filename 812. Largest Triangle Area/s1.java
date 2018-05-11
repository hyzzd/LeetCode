class Solution {
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double ans = 0;
        for(int i = 0; i < n; ++i){
            for(int j = i+1; j < n; ++j){
                for(int k = j+1; k < n; ++k)
                    ans = Math.max(ans, area(points[i], points[j], points[k]));
            }
        }
        return ans;
    }
    
    public double area(int[] p, int[] q, int[] r){
        return 0.5*Math.abs(p[0]*q[1]+q[0]*r[1]+r[0]*p[1]
                            -p[1]*q[0]-q[1]*r[0]-r[1]*p[0]);
    }
}
// is it just about math?
// O(n^3)
// O(1)
