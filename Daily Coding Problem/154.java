class Main {
    // LIFO behavior follows from the fact that every new element is pushed with a
    // priority higher than all the current elements, so it will be popped before
    // any of them.
    class Element {
        int prio;
        Key elem;
    };

    MaxPriorityQueue<Element> q;
    int top_priority = 0;

    void push(Key x) {
        q.push(Element(top_priority++, x));
    }

    Key pop() {
        top_priority--;
        return q.pop().elem;
    }
}