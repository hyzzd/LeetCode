class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String domain : cpdomains) {
            String[] info = domain.split("\\s+");
            String[] frag = info[1].split("\\.");
            int count = Integer.valueOf(info[0]);
            String str = "";
            for (int i = frag.length - 1; i >= 0; --i) {
                str = frag[i] + (i < frag.length - 1 ? "." : "") + str;
                map.put(str, map.getOrDefault(str, 0) + count);
            }
        }

        List<String> ans = new ArrayList();
        for (String domain : map.keySet())
            ans.add("" + map.get(domain) + " " + domain);
        return ans;
    }
}
// First, use hashmap to store all the domain sets
// add the counts for each domain
// O(N) total length of the cpdomains
// O(N)
