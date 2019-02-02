import java.util.ArrayList;
import java.util.List;

class Main {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList();
        
        int curWidth = 0;
        List<String> line = new ArrayList();
        for (String s : words) {
            
            if (curWidth == 0) {
                curWidth += s.length();
                line.add(s);
                continue;
            } 
            
            // add Line
            if (curWidth + s.length() + 1 > maxWidth) {
                addLine(res, line, maxWidth);
                line = new ArrayList();
                line.add(s);
                curWidth = s.length();
            } else {
                curWidth += s.length() + 1;
                line.add(s);
            }
        }
        
        // process last line
        if (line.size() == 0) return res;
        
        if (line.size() == 1) 
            addOneWord(res, line.get(0), maxWidth);
        
        if (line.size() > 1) {
            StringBuilder build = new StringBuilder();
            build.append(line.get(0));
            for (int i = 1; i < line.size(); i++) {
                build.append(" ").append(line.get(i));
            }
            addSpace(build, maxWidth - build.toString().length());
            res.add(build.toString());
        }       
        
        return res;
    }
    private void addOneWord(List<String> res, String word, int maxWidth) {
        StringBuilder build = new StringBuilder();
        build.append(word);
        addSpace(build, maxWidth - word.length());
        res.add(build.toString());
        return;
    }
    private void addLine(List<String> res, List<String> line, int maxWidth) {
        StringBuilder build = new StringBuilder();
        if (line.size() == 1) {
            addOneWord(res, line.get(0), maxWidth);
            return;
        }
            
        int wordlen = 0;
        for (String s : line) {
            wordlen += s.length();
        }
        
        int emptySpace = maxWidth - wordlen;
        int extraSpace = emptySpace % (line.size()-1);
        int everySpace = emptySpace / (line.size()-1);
        
        for (int i = 0; i < line.size()-1; i++) {
            build.append(line.get(i));
            addSpace(build, everySpace);
            if (extraSpace-- > 0) 
                addSpace(build, 1);
            
        }
        if (line.size() > 1) build.append(line.get(line.size()-1));
        
        res.add(build.toString());
    }
    private void addSpace(StringBuilder build, int n) {
        for (int i = 0; i < n; i++) {
            build.append(" ");
        }
    }
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}