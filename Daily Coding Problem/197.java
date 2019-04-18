class Main {
    public static void rotateArr(int[] arr, int k) {
        swap(arr, 0, k - 1);
        swap(arr, k, arr.length - 1);
        swap(arr, 0, arr.length - 1);
    }

    private static void swap(int[] arr, int i, int j) {
        while (i < j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        rotateArr(arr, 3);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}