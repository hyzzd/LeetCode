class Main {
    public static String idToShortUrl(int n) {
        char map[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

        StringBuilder shortUrl = new StringBuilder();

        while (n > 0) {
            shortUrl.append(map[n % 62]);
            n /= 62;
        }

        return shortUrl.reverse().toString();
    }

    public static int shortUrlToId(String shortUrl) {
        int id = 0;
        char[] shortURL = shortUrl.toCharArray();

        for (int i = 0; i < shortUrl.length(); i++) {
            if ('a' <= shortURL[i] && shortURL[i] <= 'z')
                id = id * 62 + shortURL[i] - 'a';
            if ('A' <= shortURL[i] && shortURL[i] <= 'Z')
                id = id * 62 + shortURL[i] - 'A' + 26;
            if ('0' <= shortURL[i] && shortURL[i] <= '9')
                id = id * 62 + shortURL[i] - '0' + 52;
        }
        return id;
    }

    public static void main(String[] args) {
        int n = 12345;
        String shortUrl = idToShortUrl(n);
        System.out.println(shortUrlToId(shortUrl));
    }
}