import java.util.Stack;

class Main {
    public static int countMinReversals(String expr){
        int len = expr.length();
        if(len % 2 != 0){
            return -1;
        }
        
        Stack<Character> stack = new Stack<>();
        for(char c : expr.toCharArray()){
            if(c == '}' && !stack.empty()){
                if(stack.peek() == '{')
                    stack.pop();
                else
                    stack.push(c);
            }else
                stack.push(c);
        }        
        
        int red_len = stack.size();
        int n = 0;
        while(!stack.empty() && stack.peek() == '{'){
            stack.pop();
            n++;
        }
        
        return red_len/2 + n % 2;
    }
    public static void main(String[] args) {
        String expr = "}}{{";
        System.out.println(countMinReversals(expr));
    }
}