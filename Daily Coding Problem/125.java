import java.util.ArrayList;

class Main {
    private Node root;

    public Main() {
        root = null;
    }

    public void inorder() {
        inorderUtil(root);
    }

    private void inorderUtil(Node root) {
        if (root == null) {
            return;
        }
        inorderUtil(root.left);
        System.out.print(root.data + " ");
        inorderUtil(root.right);
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    public ArrayList<Integer> toList(Node root, ArrayList<Integer> list) {
        if (root == null) {
            return list;
        }
        toList(root.left, list);
        list.add(root.data);
        toList(root.right, list);
        return list;
    }

    public boolean isPairPresent(Node node, int target) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = toList(node, list1);
        int l = 0, r = list2.size() - 1;
        while (l < r) {
            if (list2.get(l) + list2.get(r) < target) {
                l++;
            } else if (list2.get(l) + list2.get(r) > target) {
                r--;
            } else {
                System.out.print(list2.get(l) + " " + list2.get(r));
                return true;
            }
        }
        System.out.print("Not found");
        return false;
    }

    public static void main(String[] args) {
        Main tree = new Main();
        tree.insert(15);
        tree.insert(10);
        tree.insert(20);
        tree.insert(8);
        tree.insert(12);
        tree.insert(16);
        tree.insert(25);

        tree.isPairPresent(tree.root, 33);
    }
}

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}