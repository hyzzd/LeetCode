import java.util.*;

class Main {
    public List<Integer> getSubSetBldgs(int[] buildings) {
        List<Integer> sbs = new ArrayList<>();

        for (int height : buildings) {
            if (sbs.size() > 0 && sbs.get(sbs.size() - 1) < height) {
                sbs.remove(sbs.size() - 1);
            }
            sbs.add(height);
        }
        return sbs;
    }
}