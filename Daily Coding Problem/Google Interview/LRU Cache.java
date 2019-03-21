import java.util.HashMap;
import java.util.Map;

class Main {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DLinkedNode> map;
    private int capacity;
    private DLinkedNode head;
    private DLinkedNode tail;

    public Main(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        DLinkedNode temp = map.get(key);
        remove(temp);
        setHead(temp);
        return temp.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DLinkedNode temp = map.get(key);
            remove(temp);
            temp.value = value;
            setHead(temp);
        } else {
            if (map.size() >= capacity) {
                map.remove(tail.key);
                remove(tail);
            }

            DLinkedNode temp = new DLinkedNode(key, value);
            map.put(key, temp);
            setHead(temp);
        }
    }

    private void remove(DLinkedNode node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }

    private void setHead(DLinkedNode node) {
        if (head != null) {
            head.prev = node;
        }

        node.next = head;
        node.prev = null;
        head = node;

        if (tail == null) {
            tail = node;
        }
    }
}