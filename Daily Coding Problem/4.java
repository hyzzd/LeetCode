class Main {
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[] { 3, 4, -1, 1 }));
        System.out.println(firstMissingPositive(new int[] { 1, 2, 0 }));
    }

    public static void bucketSort(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            while (arr[i] != i + 1 && arr[i] > 0) {
                swap(arr, i, arr[i] - 1);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int firstMissingPositive(int[] arr) {
        bucketSort(arr);
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }
        return arr.length;
    }
}