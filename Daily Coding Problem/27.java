import java.util.Stack;

class Main {
    public boolean balanced(String s){
        if(s == null || s.length() == 0)
            return true;
        
        Stack<Character> stack = new Stack();
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }else if(ch == ')'){
                if(stack.peek() != '(')
                    return false;
                stack.pop();
            }else if(ch == ']'){
                if(stack.peek() != '[')
                    return false;
                stack.pop();
            }else if(ch == '}'){
                if(stack.peek() != '{')
                    return false;
                stack.pop();
            }
        }
        
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        Main m = new Main();
        
        System.out.println(m.balanced("([)]"));
    }
}