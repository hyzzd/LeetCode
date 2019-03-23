class Main {
    class Pair {
        int start;
        int end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    class Entry {
        int timestamp;
        int count;
        boolean enter;
    }

    public Pair findMaxPpl(Set<Entry> set) {
        int num = 0, max = 0;
        boolean fresh = false;
        Pair res = new Pair();
        for (Entry entry : set) {
            if (entry.enter) {
                num += entry.count;

                if (max < num) {
                    max = num;
                    res.start = entry.timestamp;
                    fresh = true;
                }
            } else {
                num -= entry.count;

                if (fresh) {
                    res.end = entry.timestamp;
                }
            }
        }

        return res;
    }
}