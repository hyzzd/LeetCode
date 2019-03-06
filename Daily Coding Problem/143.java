class Main {
    // or using three lists and finally concat together
    public static void qSort(int[] arr, int pivot) {
        if (arr == null || arr.length == 0)
            return;
        int index = 0;
        int end = arr.length - 1;
        while (arr[end] == pivot) {
            end--;
        }
        for (; index < end; index++) {
            if (arr[index] == pivot) {
                swap(arr, index, end);
                end--;
            }
        }

        int l = 0, r = end;
        while (l <= r) {
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }
            if (l < r) {
                swap(arr, l, r);
                l++;
                r--;
            }
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > pivot && arr[i - 1] < pivot) {
                while (end + 1 < arr.length) {
                    swap(arr, i, end + 1);
                    i++;
                    end++;
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 9, 12, 3, 5, 14, 10, 10 };
        qSort(arr, 10);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}