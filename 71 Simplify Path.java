public class Solution {
    public String simplifyPath(String path) {
        String[] strs = path.split("/");
        Stack<String> stack = new Stack<String>();
        
        for(int i = 0; i < strs.length; i++){
            if(strs[i].equals(".") || strs[i].length() < 1) continue;
            if(strs[i].equals("..")){
                if(!stack.isEmpty())
                    stack.pop();
            }
            else
                stack.push(strs[i]);
        }
        
        String ret = "/";
        while(!stack.isEmpty())
            ret = "/" + stack.pop() + ret;
        if(ret.length() > 1)
            ret = ret.substring(0, ret.length() - 1);
        
        return ret;
    }
}
