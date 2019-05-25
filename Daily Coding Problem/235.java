class Main {
    public int[] findMaxMin(int[] arr) {
        int max = arr[0], min = arr[1];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
            else if (arr[i] < min)
                min = arr[i];
        }

        return new int[] { max, min };
    }
}