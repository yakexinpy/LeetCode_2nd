public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        if(num == null || num.length < 3) return new ArrayList<List<Integer>>();
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        
        for(int i = num.length - 1; i > 1; i--){
            if( i < num.length - 1 && num[i] == num[i + 1]) continue;
            List<List<Integer>> tmp = twoSum(-num[i], i, num);
            ret.addAll(tmp);
        }
        return ret;
    }
    
    private List<List<Integer>> twoSum(int target, int end, int[] num){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int l = 0, r = end - 1;
        while(l < r){
            if(num[l] + num[r] == target){
                List<Integer> tmp = new ArrayList<Integer>();
                tmp.add(num[l]);
                tmp.add(num[r]);
                tmp.add(num[end]);
                res.add(tmp);
                l++;
                r--;
                while(l < r && num[l] == num[l - 1])
                    l++;
                while(l < r && num[r] == num[r + 1])
                    r--;
            }    
            else if(num[l] + num[r] < target)
                l++;
            else 
                r--;
        }
        return res;
    }
}
