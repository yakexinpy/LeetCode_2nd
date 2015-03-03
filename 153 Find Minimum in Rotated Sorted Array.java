public class Solution {
    public int findMin(int[] num) {
        if(num == null) return -1;
        
        int left = 0, right = num.length - 1, mid = 0;
        while(right - left > 1){
            mid = (left + right) / 2;
            if(num[mid] > num[right])
                left = mid;
            else 
                right = mid;
        }
        return Math.min(num[left], num[right]);
    }
}
