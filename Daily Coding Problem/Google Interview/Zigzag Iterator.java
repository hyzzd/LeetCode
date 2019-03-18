import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class Main {
    Iterator<Integer> it1;
    Iterator<Integer> it2;
    int turns;

    public Main(List<Integer> v1, List<Integer> v2) {
        this.it1 = v1.iterator();
        this.it2 = v2.iterator();
        turns = 0;
    }

    public boolean hasNext() {
        return it1.hasNext() || it2.hasNext();
    }

    public int next() {
        if (!hasNext()) {
            return 0;
        }
        turns++;
        if ((turns % 2 == 1 && it1.hasNext()) || (!it2.hasNext())) {
            return it1.next();
        } else if ((turns % 2 == 0 && it2.hasNext()) || (!it1.hasNext())) {
            return it2.next();
        }
        return 0;
    }
}