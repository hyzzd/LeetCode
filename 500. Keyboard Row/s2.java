// ???
// Java 1-Line Solution via Regex and Stream
class Solution {
    public String[] findWords(String[] words) {
        return Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*"))
                .toArray(String[]::new);
    }
}
// not sure about this
