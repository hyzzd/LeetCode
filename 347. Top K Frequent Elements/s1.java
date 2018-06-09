class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        List<Integer>[] bucket = new List[nums.length+1];
        for(int n:map.keySet()){
            int freq = map.get(n);
            if(bucket[freq] == null) bucket[freq] = new LinkedList<>();
            bucket[freq].add(n);
        }
        List<Integer> list = new LinkedList<>();
        for(int i = bucket.length - 1; i >= 0 && k > 0; --i){
            if(bucket[i] != null){
                list.addAll(bucket[i]);
                k -= bucket[i].size();
            }
        }
        return list;
    }
}
// use array to save in buckets
