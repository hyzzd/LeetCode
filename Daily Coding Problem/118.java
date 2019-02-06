class Main {
    public int[] sortSquaredArray(int[] arr) {
        if (arr == null || arr.length == 0)
            return null;

        int idx = 1;
        for (; idx < arr.length; idx++) {
            if (arr[idx - 1] < 0 && arr[idx] >= 0) {
                break;
            }
        }

        int[] a1 = new int[idx];
        int[] a2 = new int[arr.length - idx];
        for (int i = idx - 1; i >= 0; i--) {
            a1[i] = arr[idx - 1 - i] * arr[idx - 1 - i];
        }

        for (int i = 0; i < arr.length - idx; i++) {
            a2[i] = arr[idx + i] * arr[idx + i];
        }

        return mergeArrs(a1, a2);
    }

    private int[] mergeArrs(int[] a1, int[] a2) {
        int l1 = a1.length, l2 = a2.length;
        int len = l1 + l2;
        int[] result = new int[len];
        int i = 0, j = 0, k = 0;
        while (i < l1 && j < l2) {
            if (a1[i] < a2[i]) {
                result[k] = a1[i];
                i++;
                k++;
            } else {
                result[k] = a2[j];
                j++;
                k++;
            }
        }
        while (i < l1) {
            result[k] = a1[i];
            i++;
            k++;
        }
        while (j < l2) {
            result[k] = a2[j];
            j++;
            k++;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}