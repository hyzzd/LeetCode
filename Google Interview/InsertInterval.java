import java.util.ArrayList;
import java.util.List;

class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            result.add(newInterval);
            return result;
        }
        int index = 0;
        boolean inserted = false;
        while (index < intervals.size()) {
            Interval current = intervals.get(index);
            if (newInterval.start < intervals.get(index).start) {
                if (newInterval.end < current.start) {
                    result.add(newInterval);
                    inserted = true;
                    break;
                } else {
                    if (newInterval.end <= current.end) {
                        result.add(new Interval(newInterval.start, current.end));
                        index++;
                        inserted = true;
                        break;
                    } else {
                        index++;
                    }
                }
            } else {
                if (newInterval.start > current.end) {
                    result.add(current);
                    index++;
                } else {
                    if (index == intervals.size() - 1) {
                        result.add(new Interval(current.start, newInterval.end));
                        inserted = true;
                    } else {
                        newInterval.start = current.start;
                    }
                    index++;
                }
            }
        }
        while (index < intervals.size()) {
            result.add(intervals.get(index));
            index++;
        }
        if (!inserted) {
            result.add(newInterval);
        }
        return result;
    }

    public static void main(String args[]) {
        InsertInterval m = new InsertInterval();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(6, 9));
        Interval newInterval = new Interval(2, 5);
        List<Interval> results = m.insert(intervals, newInterval);
        for (Interval result : results) {
            System.out.print("[" + result.start + ", " + result.end + "] ");
        }
    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}