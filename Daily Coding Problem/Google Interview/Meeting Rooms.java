import java.util.Arrays;
import java.util.Comparator;

class Main {
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i].end > intervals[i + 1].start) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        Main m = new Main();
        Interval[] intervals = new Interval[] { new Interval(0, 30), new Interval(5, 10), new Interval(15, 20) };
        System.out.print(m.canAttendMeetings(intervals));
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