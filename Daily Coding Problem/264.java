class Main {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        String deBruijn = "";
        for (int i = 0; i < n; i++)
            deBruijn = deBruijn + "0";

        for (int i = n; i < (1 << n); i++) {
            String suffix = deBruijn.substring(i - n + 1);
            if (deBruijn.indexOf(suffix + "1") == -1)
                deBruijn = deBruijn + "1";
            else
                deBruijn = deBruijn + "0";
        }
        StdOut.println(deBruijn);

    }
}