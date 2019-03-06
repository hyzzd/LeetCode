class Main {
    public static int[] findSingleElement(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int result = arr[0];
        int x = 0, y = 0, setBit = 0;
        for (int i = 1; i < arr.length; i++) {
            result = result ^ arr[i];
        }

        setBit = result & ~(result - 1);
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & setBit) != 0) {
                x = x ^ arr[i];
            } else {
                y = y ^ arr[i];
            }
        }

        return new int[] { x, y };
    }

    public static void main(String[] args) {
        int arr[] = { 2, 4, 6, 8, 10, 2, 6, 10 };
        System.out.println(findSingleElement(arr)[0]);
        System.out.println(findSingleElement(arr)[1]);
    }
}