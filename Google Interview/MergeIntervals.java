import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if (intervals == null || intervals.size() < 2) {
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        for (int i = 0; i < intervals.size(); i++) {
            if (result.size() == 0) {
                result.add(intervals.get(i));
                continue;
            }
            if (intervals.get(i).start <= result.get(result.size() - 1).end) {
                result.get(result.size() - 1).end = Math.max(result.get(result.size() - 1).end, intervals.get(i).end);
            } else {
                result.add(intervals.get(i));
            }
        }
        return result;
    }

    public static void main(String args[]) {
        MergeIntervals m = new MergeIntervals();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));
        List<Interval> results = m.merge(intervals);
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
