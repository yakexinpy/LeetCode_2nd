public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<String>();

        helper(ret, "", n, n);
        
        return ret;
    }
    
    private void helper(List<String> ret, String str, int left, int right){
        if(right == 0 && right == 0){
            ret.add(str);
            return;
        }
        
        if(left > 0)
            helper(ret, str + "(", left - 1, right);
        if(right > left)
            helper(ret, str + ")", left, right - 1);
    }
}
