import java.awt.List;
import java.util.Map;

class Main {
    Map<Integer, Integer> map;
    List<Integer> vals;

    /** Initialize your data structure here. */
    public Main() {
        map = new HashMap<>();
        vals = new ArrayList<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain
     * the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, vals.size());
        vals.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified
     * element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        // not the last one than swap the last one with this val
        int last = vals.get(vals.size() - 1);
        vals.set(map.get(val), last);
        map.put(last, map.get(val));

        map.remove(val);
        vals.remove(vals.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random rand = new Random();
        int r = rand.nextInt(vals.size());
        return vals.get(r);
    }
}