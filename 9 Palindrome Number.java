public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        if(x < 10) return true;
        
        int size = String.valueOf(x).length();
        
        int div = 1;
        for(int i = 1; i < size; i++)
            div *= 10;
            
        while(x > 0){
            int left = x / div;
            int right = x % 10;
            
            if(left != right) return false;
            
            x = (x % div) / 10;
            div /= 100;
            
        }
        return true;
    }
}
