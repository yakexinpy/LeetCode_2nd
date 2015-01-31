public class Solution {
    public void nextPermutation(int[] num) {
        int end = num.length - 1;
        while(end > 0 && num[end] <= num[end - 1]) end--;
        
        if(end > 0){
            int j = num.length - 1;
            while(j > end && num[j] <= num[end - 1]) j--;
            
            int tmp = num[j];
            num[j] = num[end - 1];
            num[end - 1] = tmp;
        }
        
        int m = num.length - 1;
        while(end < m){
            int tmp = num[end];
            num[end] = num[m];
            num[m] = tmp;
            end ++;
            m--;
        }
    }
}
