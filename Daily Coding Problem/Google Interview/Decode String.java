class Main {
    public String decodeString(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<String> result = new Stack<>();
        result.push("");
        int i = 0;
        while (i < s.length()) {
            if (Character.isDigit(ch)) {
                int start = i;
                while (Character.isDigit(ch)) {
                    i++;
                }
                count.push(Integer.parseInt(s.substring(start, i + 1)));
            } else if (ch == '[') {
                result.push("");
            } else if (ch == ']') {
                StringBuilder sb = new StringBuilder();
                String str = result.pop();
                int index = count.pop();
                for (int j = 0; j < index; j++) {
                    sb.append(result.pop());
                }
                result.push(result.pop() + sb.toString());
            } else {
                result.push(result.pop(), s.charAt(i));
            }
            i++;
        }

        return result.pop();
    }
}