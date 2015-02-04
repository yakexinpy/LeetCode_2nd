public class Solution {
    public int sqrt(int x) {
        int left = 0, right = x / 2 + 1;
        while(right - left >= 0){
            long mid = (left + right) / 2;
            if(mid * mid == (long)x) return (int)mid;
            if(mid * mid > (long)x)
                right = (int)mid - 1;
            else
                left = (int)mid + 1;
        }
        return right;
    }
}
