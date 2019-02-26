class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> m1 = new HashMap<>();
        Map<String, Integer> m2 = new HashMap<>();
        for (int i = 0; i < list1.length; ++i) {
            m1.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; ++i) {
            m2.put(list2[i], i);
        }
        int min = Integer.MAX_VALUE;
        for (String s : m1.keySet()) {
            if (m2.containsKey(s)) {
                if (min == m1.get(s) + m2.get(s)) {
                    ans.add(s);
                } else if (min > m1.get(s) + m2.get(s)) {
                    ans.clear();
                    min = m1.get(s) + m2.get(s);
                    ans.add(s);
                }
            }
        }
        return ans.toArray(new String[0]);
    }
}
// O(l1+l2)
// O(l1+l2)
