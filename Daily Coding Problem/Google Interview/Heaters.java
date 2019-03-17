import java.util.Arrays;

class Main {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);

        int res = Integer.MIN_VALUE;
        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) {
                // convert insertion point
                index = -(index + 1);
            }
            int left = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
            int right = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
            res = Math.max(res, Math.min(left, right));
        }

        return res;
    }
}