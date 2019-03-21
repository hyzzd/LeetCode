import java.util.Iterator;

class Main implements Iterator<Integer> {
    Integer next;
    Iterator<Integer> it;

    public Main(Iterator<Integer> iterator) {
        // initialize any member here.
        this.next = null;
        this.it = iterator;
        if (it.hasNext()) {
            next = it.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int res = next;
        if (it.hasNext()) {
            next = it.next();
        } else {
            next = null;
        }
        return res;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}