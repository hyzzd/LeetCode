import java.util.Map;

class Main {
    private Map<Integer, Integer> map;
    private int size;

    public void init(int size) {
        this.map = new HashMap<>();
        this.size = size;
    }

    public boolean set(int i, int val) {
        if (i < size) {
            map.getOrDefault(i, val);
            return true;
        }

        return false;
    }

    public int get(int i) {
        return map.getOrDefault(i, 0);
    }
}