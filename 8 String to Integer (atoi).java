public class Solution {
    public int atoi(String str) {
        str = str.trim();
        if(str == null || str.length() < 1) return 0;
        
        boolean isNeg = false;
        if(str.charAt(0) == '-'){
            isNeg = true;
            str = str.substring(1, str.length());
        }
        else if(str.charAt(0) == '+')
            str = str.substring(1, str.length());
        
        int res = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) > '9' || str.charAt(i) < '0') 
                return isNeg ? -res : res;
            
            if(!isNeg && res > (Integer.MAX_VALUE - (str.charAt(i) - '0')) / 10)
                return Integer.MAX_VALUE;
            if(isNeg && res > -((Integer.MIN_VALUE + (str.charAt(i) - '0')) / 10))
                return Integer.MIN_VALUE;
            res = res * 10 + (str.charAt(i) - '0');
        }
        
        return isNeg ? - res : res;
    }
}
