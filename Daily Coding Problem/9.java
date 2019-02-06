class Main {
    public int largestSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int pick = arr[0];
        int notpick = 0;

        for (int i = 1; i < arr.length; ++i) {
            int temp = pick > notpick ? pick : notpick;
            pick = notpick + arr[i];
            notpick = temp;
        }

        return Math.max(pick, notpick);
    }

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.largestSum(new int[] { 2, 4, 6, 2, 5 }));
        System.out.println(m.largestSum(new int[] { 5, 1, 1, 5 }));
    }
}