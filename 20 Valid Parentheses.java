public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        int cur = 0;
        while(cur < s.length()){
            if(s.charAt(cur) == '(' || s.charAt(cur) == '[' || s.charAt(cur) == '{'){
                stack.push(s.charAt(cur));
            }
            else{
                if(stack.isEmpty()) return false;
                char ch = stack.pop();
                if(ch == '(' && s.charAt(cur) != ')') return false;
                if(ch == '[' && s.charAt(cur) != ']') return false;
                if(ch == '{' && s.charAt(cur) != '}') return false;
            }
            cur++;
        }
        if(stack.isEmpty()) return true;
        else return false;
    }
}
