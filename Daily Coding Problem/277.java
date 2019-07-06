import java.util.Map;

class Main {
    int BLEN = 8;
    Map<Integer, Integer> SHIFT_RES = new HashMap<>();
    int TAIL_SHIFT = 6;
    int TAIL_SHIFT_RES = 2;

    Main() {
        SHIFT_RES.put(2, 6);
        SHIFT_RES.put(3, 14);
        SHIFT_RES.put(4, 30);
    }

    public boolean isValidUTF8(int[] arr) {
        int ln = arr.length;
        if (ln == 1)
            return arr[0] < 128;

        int first = arr[0];

        int sfirst = first >> (BLEN - ln - 1);
        if (SHIFT_RES.get(ln) != sfirst)
            return false;

        for (int i = 1; i < arr.length; i++) {
            int snum = arr[i] >> TAIL_SHIFT;
            if (snum != TAIL_SHIFT_RES)
                return false;
        }

        return true;
    }
}