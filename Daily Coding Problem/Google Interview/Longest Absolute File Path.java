class Main {
    public int lengthLongestPath(String input) {
        String[] files = input.split("\n");
        int maxLength = 0;
        int[] stack = new int[files.length + 1];
        stack[0] = 0;
        for (String s : files) {
            int level = s.lastIndexOf("\t") + 1;
            int curLength = stack[level] + s.length() - level + 1;
            stack[level + 1] = curLength;
            if (s.contains(".")) {
                maxLength = Math.max(maxLength, curLength - 1);
            }
        }

        return maxLength;
    }
}