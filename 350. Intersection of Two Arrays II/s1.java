class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        for(int i: nums1){
            map1.put(i, map1.getOrDefault(i, 0)+1);
        }
        for(int i: nums2){
            if(map1.getOrDefault(i, 0) > 0){
                ans.add(i);
                map1.put(i, map1.getOrDefault(i, 0)-1);
            }
        }        
        int[] result = new int[ans.size()];
        for(int i = 0; i < ans.size(); ++i){
            result[i] = ans.get(i);
        }
        return result;
    }
}
// O(n)
// O(n)
