class Main {
    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String s, int n) {
            for (char c : s.toCharArray()) {
                if (root.nodes[c - 'a'] == null) {
                    root.nodes[c - 'a'] = new TrieNode();
                    root.nodes[c - 'a'].count = n;
                } else {
                    root.nodes[c - 'a'].count += n;
                }
                root = root.nodes[c - 'a'];
            }
        }

        public int sum(String s) {
            for (char c : s.toCharArray()) {
                if (root.nodes[c - 'a'] == null) {
                    return -1;
                } else {
                    root = root.nodes[c - 'a'];
                }
            }
            return root.count;
        }
    }

    class TrieNode {
        TrieNode[] nodes;
        int count;
    }
}