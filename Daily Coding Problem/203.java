class Main {
    public static int findMin(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] > arr[l] && arr[m] > arr[r]) {
                return arr[m + 1];
            } else if (arr[m] > arr[l] && arr[m] < arr[r]) {
                r = m;
            } else if (arr[m] < arr[l] && arr[m] > arr[r]) {
                l = m + 1;
            } else {
                return arr[m];
            }
        }

        return arr[l];
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 5, 7, 10, 3, 4 };
        System.out.println(findMin(arr));
    }
}