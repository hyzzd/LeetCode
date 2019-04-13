class Main {
    public static int maxSubarray(int[] arr) {
        int res = 0;
        int[] array = new int[arr.length * 2];
        for (int i = 0; i < array.length; i++) {
            array[i] = arr[i % arr.length];
        }
        int len = 0, cur = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 0 && len < arr.length) {
                cur += array[i];
                len++;
            } else if (array[i] < 0) {
                res = Math.max(res, cur);
                cur = 0;
                len = 0;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = {8, -1, 3, 4};
        int[] arr2 = {-4, 5, 1, 0};
        System.out.println(maxSubarray(arr1));
        System.out.println(maxSubarray(arr2));
    }
}