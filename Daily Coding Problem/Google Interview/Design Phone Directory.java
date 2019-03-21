class Main {
    boolean[] bitSet;
    int smallestFreeIndex;

    /**
     * Initialize your data structure here
     * 
     * @param maxNumbers - The maximum numbers that can be stored in the phone
     *                   directory.
     */
    public Main(int maxNumbers) {
        bitSet = new boolean[maxNumbers];
        smallestFreeIndex = 0;
    }

    /**
     * Provide a number which is not assigned to anyone.
     * 
     * @return - Return an available number. Return -1 if none is available.
     */
    public int get() {
        if (smallestFreeIndex == bitSet.length) {
            return -1;
        }
        int num = smallestFreeIndex;
        bitSet[num] = true;
        for (int i = smallestFreeIndex + 1; i < bitSet.length; i++) {
            if (!bitSet[i]) {
                smallestFreeIndex = i;
                break;
            }
        }
        if (num == smallestFreeIndex) {
            smallestFreeIndex = bitSet.length;
        }
        return num;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return bitSet[number];
    }

    /** Recycle or release a number. */
    public void release(int number) {
        bitSet[number] = false;
        if (number < smallestFreeIndex) {
            smallestFreeIndex = number;
        }
    }
}