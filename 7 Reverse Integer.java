public class Solution {
    public int reverse(int x) {
        boolean isNeg = x < 0;
        x = Math.abs(x);
        
        int ret = 0;
        while(x > 0){
            int d = x % 10;
            if(!isNeg && ret > (Integer.MAX_VALUE - d)/ 10) return 0;
            if(isNeg && ret > (Integer.MIN_VALUE + d) / 10 * -1) return 0;
            ret = ret * 10 + d;
            x = x / 10;
        }
        
        if(isNeg)
            return 0 - ret;
        return ret;
    }
}
