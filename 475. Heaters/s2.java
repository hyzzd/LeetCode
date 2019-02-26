class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        Arrays.sort(houses);

        int i = 0, res = 0;
        for (int house : houses) {
            while (i < heaters.length - 1 && heaters[i] + heaters[i + 1] <= 2 * house)
                i++;
            res = Math.max(res, Math.abs(heaters[i] - house));
        }
        return res;
    }
}
