class Main {
    // Pancake sorting
    public static void pancakeSort(int[] arr) {
        int n = arr.length;
        for (int i = n; i > 1; i--) {
            int max = findMax(arr, i);
            if (max != i - 1) {
                flip(arr, max);
                flip(arr, i - 1);
            }
        }
    }

    private static int findMax(int arr[], int n) {
        int mi, i;
        for (mi = 0, i = 0; i < n; ++i)
            if (arr[i] > arr[mi])
                mi = i;
        return mi;
    }

    /* Reverses arr[0..i] */
    private static void flip(int arr[], int i) {
        int temp, start = 0;
        while (start < i) {
            temp = arr[start];
            arr[start] = arr[i];
            arr[i] = temp;
            start++;
            i--;
        }
    }

    public static void main(String args[]) {
        int[] arr = { 9, 12, 3, 5, 14, 10, 10 };
        pancakeSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}