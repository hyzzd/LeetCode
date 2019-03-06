class Main {
    // Boyer-Moore Voting
    public int majorityElement(int[] num) {
        int result = 0;
        int count = 0;
        for (int i : num) {
            if (count == 0) {
                result = i;
            }
            count += (i == result) ? 1 : -1;
        }
        return result;
    }
}