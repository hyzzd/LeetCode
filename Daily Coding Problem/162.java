import java.util.Arrays;

class Main {
    public String[] uniquePrefix(String[] arr) {
        int size = arr.length;
        String[] res = new String[size];
        Arrays.sort(arr);

        int j = computePrefix(arr[0], arr[1]);
        int idx = 0;
        res[idx++] = arr[0].substring(0, j + 1);
        String tmp = arr[1].substring(0, j + 1);
        for (int i = 1; i < size - 1; i++) {
            j = computePrefix(arr[i], arr[i + 1]);
            String nwe = arr[i].substring(0, j + 1);
            if (tmp.length() > nwe.length()) {
                res[idx++] = tmp;
            } else {
                res[idx++] = nwe;
            }

            tmp = arr[i + 1].substring(0, j + 1);
        }

        j = computePrefix(arr[size - 1], arr[size - 2]);
        res[idx] = arr[size - 1].substring(0, j + 1);
        return res;
    }

    private int computePrefix(String s1, String s2) {
        int j = 0;
        while (j < Math.min(s1.length() - 1, s2.length() - 1)) {
            if (s1.charAt(j) != s2.charAt(j)) {
                break;
            } else {
                j++;
            }
        }

        return j;
    }
}