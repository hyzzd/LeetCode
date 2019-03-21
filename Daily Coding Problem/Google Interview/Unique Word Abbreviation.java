class Main {
    HashMap<String, String> map;

    public Main(String[] dictionary) {
        map = new HashMap<String, String>();
        for (String str : dictionary) {
            String abb = getAbb(str);
            if (map.containsKey(abb)) {
                if (!map.get(abb).equals(str)) {
                    map.put(abb, "");
                }
            } else {
                map.put(abb, str);
            }
        }
    }

    public boolean isUnique(String word) {
        return !map.containsKey(getAbb(word)) || map.get(getAbb(word)).equals(word);
    }

    private String getAbb(String word) {
        if (word.length() <= 2) {
            return word;
        }
        String abb = word.charAt(0) + Integer.toString(word.length() - 2) + word.charAt(word.length() - 1);
        return abb;
    }
}