class Main {
    public static void printZigZag(String s, int k) {
        StringBuilder[] sb = new StringBuilder[k];
        for (int i = 0; i < k; i++) {
            sb[i] = new StringBuilder();
        }

        int crow = 0;
        int dir = -1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < k; j++) {
                if (j == crow) {
                    sb[j].append(s.charAt(i));
                } else {
                    sb[j].append(" ");
                }
            }

            if (crow == k - 1 || crow == 0) {
                dir *= -1;
            }

            crow += dir;
        }

        for (int i = 0; i < k; i++) {
            System.out.println(sb[i].toString());
        }
    }
}