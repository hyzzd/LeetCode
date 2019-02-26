class MovingAverage {

    Queue<Integer> q;
    int s;
    double sum;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        q = new LinkedList<>();
        s = size;
        sum = 0;
    }

    public double next(int val) {
        q.offer(val);
        sum += (double) val;
        if (q.size() > s) {
            sum -= (double) q.poll();
        }
        return sum / (double) q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size); double param_1 = obj.next(val);
 */
