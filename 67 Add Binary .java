public class Solution {
    public String addBinary(String a, String b) {
        String ret = "";
        int carry = 0;
        int i = a.length() - 1, j = b.length() - 1;
        while(i >= 0 || j >= 0){
            int digit = carry;
            if(i >= 0)
                digit += (a.charAt(i--) - '0');
            if(j >= 0)
                digit += (b.charAt(j--) - '0');
            
            if(digit == 0){
                ret = "0" + ret;
                carry = 0;
            }
            else if(digit == 1){
                ret = "1" + ret;
                carry = 0;
            }
            else if(digit == 2){
                ret = "0" + ret;
                carry = 1;
            }
            else{
                ret = "1" + ret;
                carry = 1;
            }
            
        }
        if(carry > 0)
            ret = "1" + ret;
        return ret;
    }
}
