class Main {
    public boolean getFixedPoint(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == arr[i])
                return true;
        }
        return false;
    }
}