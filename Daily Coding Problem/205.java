import java.util.Arrays;

class Main {
    public static int[] nextPerm(int[] arr) {
        int i = arr.length - 2;
        int index = 0;
        for (; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                continue;
            } else {
                index = i;
                break;
            }
        }

        swap(arr, index, arr.length - 1);
        if (index != arr.length - 1) {
            Arrays.sort(arr, index + 1, arr.length);
        }

        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 4, 6, 5 };
        nextPerm(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}