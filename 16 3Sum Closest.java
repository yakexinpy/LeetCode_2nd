public class Solution {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int min = num[0] + num[1] + num[2] - target;
        for(int i = num.length - 1; i > 1; i--){
            int dif = twoSum(num, i - 1, target - num[i]);
            if(Math.abs(dif) < Math.abs(min))
                min = dif;
        }
        return min + target;
    }
    
    private int twoSum(int[] num, int end, int tgt){
        int l = 0, r = end;
        int diff = num[end] + num[end - 1] - tgt;
        while(l < r){
            if(num[l] + num[r] == tgt)
                return 0;
            int d = num[l] + num[r] - tgt;
            if(Math.abs(diff) > Math.abs(d))
                diff = d;
            if(d > 0) r--;
            else l++;
        }
        return diff;
    }
    
}
