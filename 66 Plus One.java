public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1, sum = 0;
        for(int i = digits.length - 1; i >= 0; i--){
            if(carry == 0) break;
            sum = carry + digits[i];
            carry = (sum > 9) ? sum / 10 : 0;
            digits[i] = sum % 10;
        }
        if(carry == 0) return digits;
        int[] ret = new int[digits.length + 1];
        ret[0] = carry;
        for(int i = 1; i <= digits.length; i++)
            ret[i] = digits[i - 1];
        return ret;
    }
}
