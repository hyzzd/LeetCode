private LinkedList<Integer> q1 = new LinkedList<>();

// Push element x onto stack.
public void push(int x) {
    q1.add(x);
    int sz = q1.size();
    while (sz > 1) {
        q1.add(q1.remove());
        sz--;
    }
}

// Removes the element on top of the stack.
public void pop() {
    q1.remove();
}

// Return whether the stack is empty.
public boolean empty() {
    return q1.isEmpty();
}

// Get the top element.
public int top() {
    return q1.peek();
}
