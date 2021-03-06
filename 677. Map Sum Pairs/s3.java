class MapSum {

    Map<String, Integer> map;
    TrieNode root;

    /** Initialize your data structure here. */
    public MapSum() {
        map = new HashMap<String, Integer>();
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        int delta = val - map.getOrDefault(key, 0);
        map.put(key, val);
        TrieNode cur = root;
        cur.score += delta;
        for (char c : key.toCharArray()) {
            cur.children.putIfAbsent(c, new TrieNode());
            cur = cur.children.get(c);
            cur.score += delta;
        }
    }

    public int sum(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            cur = cur.children.get(c);
            if (cur == null)
                return 0;
        }
        return cur.score;
    }
}

class TrieNode {
    Map<Character, TrieNode> children = new HashMap();
    int score;
}
/**
 * Your MapSum object will be instantiated and called as such: MapSum obj = new
 * MapSum(); obj.insert(key,val); int param_2 = obj.sum(prefix);
 */

// Trie Tree
// O(k)
// O(n)
