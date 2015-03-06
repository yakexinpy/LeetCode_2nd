public class Solution {
    public int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        
        int max = 0;
        for(int i = 0; i < height.length; i++){
            if(stack.isEmpty())
                stack.push(i);
            else{
                while(!stack.isEmpty() && height[i] < height[stack.peek()]){
                    int h = height[stack.pop()];
                    max = Math.max(max, h * (i - 1 - (stack.isEmpty() ? -1 : stack.peek())));
                }
                stack.push(i);
            }
        }
        
        while(!stack.isEmpty()){
            int h = height[stack.pop()];
            max = Math.max(max, h * (height.length - 1 - (stack.isEmpty() ? -1 : stack.peek())));
        }
        return max;
    }
}
