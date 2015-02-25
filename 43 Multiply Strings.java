public class Solution {
    public String multiply(String num1, String num2) {
        int[] A = new int[num1.length()];
        int[] B = new int[num2.length()];
        int[] rest = new int[num1.length() + num2.length()];
        
        for(int i = 0; i < num1.length(); i++)
            A[i] = num1.charAt(i) - '0';
        for(int j = 0; j < num2.length(); j++)
            B[j] = num2.charAt(j) - '0';
            
        int carry = 0;
        for(int j = B.length - 1; j >= 0; j--){
            for(int i = A.length - 1; i >= 0; i--){
                int p = A[i] * B[j] + carry;
                p += rest[rest.length - A.length - B.length + i + j + 1];
                carry = p / 10;
                rest[rest.length - A.length - B.length + i + j + 1] = p % 10;
            }
            rest[rest.length - A.length - B.length + j] += carry;
            carry = 0;
        }
        
        int i = 0;
        for(; i < rest.length; i++)
            if(rest[i] != 0) break;
            
        String ret = "";
        if(i >= rest.length) return "0";
        for(; i < rest.length; i++)
            ret += rest[i];
        return ret;
    }
}
