public List<String> letterCasePermutation(String S) {
    List<String> ans = new ArrayList<>(Arrays.asList(S));
    for (int i = 0; i < S.length(); ++i) { // Traverse string S.
        for (int j = 0, sz = ans.size(); S.charAt(i) > '9' && j < sz; ++j) { // S.charAt(i) > '9': letter, not digit.
            char[] ch = ans.get(j).toCharArray(); // transform to char[] the string @ j of ans.
            ch[i] ^= (1 << 5); // toggle case of charAt(i).
            ans.add(String.valueOf(ch)); // append to the end of ans.
        }
    }
    return ans;
}
