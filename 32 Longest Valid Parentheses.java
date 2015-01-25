public class Solution {
    public int longestValidParentheses(String s) {
        //solution 1: count[i] = count[i - 1] + count[l - 1] + 2;
        
        int[] count = new int[s.length()];
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();  
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(')
                stack.push(i);
            else{
                if(stack.isEmpty()) continue;
                int l = stack.pop();
                count[i] = ((l > 0) ? count[l - 1] : 0) + ((i > 0) ? count[i - 1] : 0) + 2;
                max = Math.max(max, count[i]);
            }
        }
        return max;
        
        
        /*
        //solution 2: traverse from left and traverse from right
        if(s == null || s.length() < 2) return 0;
        
        int max = 0, count = 0, len = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                count ++;
                len++;
            }
            else{
                count--;
                if(count < 0){
                    len = 0;
                    count = 0;
                }
                else if(count == 0){
                    max = Math.max(max, len + 1);
                    len++;
                }
                else
                    len++;
            }
        }
        
        count = 0;
        len = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) == ')'){
                count++;
                len++;
            }
            else{
                count--;
                if(count < 0){
                    len = 0;
                    count = 0;
                }
                else if(count == 0){
                    max = Math.max(max, len + 1);
                    len++;
                }
                else 
                    len++;
            }
        }
        return max;*/
    }
}
