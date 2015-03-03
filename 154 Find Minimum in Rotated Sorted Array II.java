public class Solution {
    public int findMin(int[] num) {
        if(num == null) return -1;
        
        int left = 0, right = num.length - 1, mid = -1;
        
        while(right - left > 1){
            while(right - left > 1 && num[left] == num[left + 1])
                left++;
            while(right - left > 1 && num[right] == num[right - 1])
                right--;
            mid = (left + right) / 2;
            if(num[mid] > num[right])
                left = mid;
            else
                right = mid;
        }
        
        return Math.min(num[left], num[right]); 
    }
}
