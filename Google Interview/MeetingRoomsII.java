import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Main {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return -1;
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        int count = 1;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.offer(intervals[0].end);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < heap.peek()) {
                count++;
            } else {
                heap.poll();
            }
            heap.offer(intervals[i].end);
        }
        return count;
    }

    public static void main(String args[]) {
        Main m = new Main();
        Interval[] intervals = new Interval[] { new Interval(0, 30), new Interval(5, 10), new Interval(15, 20) };
        System.out.print(m.minMeetingRooms(intervals));
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