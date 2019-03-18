import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class Main {
    List<Iterator<Integer>> itlist;
    int turns;

    public Main(List<Iterator<Integer>> list) {
        this.itlist = new LinkedList<>();
        for (Iterator<Integer> it : list) {
            if (it.hasNext()) {
                itlist.add(it);
            }
        }
        turns = 0;
    }

    public boolean hasNext() {
        return itlist.size() > 0;
    }

    public int next() {
        if (!hasNext()) {
            return 0;
        }
        int res = 0;
        int pos = turns % itlist.size();
        Iterator<Integer> curr = itlist.get(pos);
        res = curr.next();
        if (!curr.hasNext()) {
            itlist.remove(pos);
            turns = pos - 1;
        }
        turns++;
        return res;
    }
}