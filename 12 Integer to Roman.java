 public class Solution {
    public String intToRoman(int num) {
        String[] romans = new String[4];
        int i = 3;
        while(num != 0){
            romans[i] = getRoman(num % 10, i);
            i--;
            num = num / 10;
        }
        
        String ret = "";
        for(i = 0; i < 4; i++)
            if(romans[i] != null) ret += romans[i];
        return ret;
    }
    
    private String getRoman(int num, int dig){
        if(num == 0) return "";
        String ret = "";
        char[] romans = {'M','D','C','L','X','V','I'};
        
        if(num < 4){
            while(num > 0){
                ret += "" + romans[dig * 2];
                num--;
            }
        }
        else if(num == 4){
            ret = romans[dig * 2] + "" + romans[dig * 2 - 1];
        }
        else if(num > 4 && num < 9){
            ret += romans[dig * 2 - 1] + "";
            num = num % 5;
            while(num > 0){
                ret += "" + romans[dig * 2];
                num--;
            }
        }
        else
            ret += romans[dig * 2] + "" + romans[dig * 2 - 2];
            
        return ret;
    }
}
