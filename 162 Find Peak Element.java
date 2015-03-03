public class Solution {
    public int findPeakElement(int[] num) {
        int left = 0, right = num.length - 1, mid = -1;
        
        while(left <= right){
            mid = (left + right) / 2;
            if(left == right) return left;
            if(num[mid] < num[mid + 1])
                left = mid + 1;
            else
                right = mid;
        }
        return -1;
    }
}
