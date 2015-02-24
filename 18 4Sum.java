public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        
        for(int i = num.length - 1; i > 2; i--){
            if(i < num.length - 1 && num[i] == num[i + 1]) continue;
            threeSum(ret, num, i, target - num[i]);
        }
        return ret;
    }
    
    private void threeSum(List<List<Integer>> ret, int[] num, int end, int tgt){
        //List<List<Integer>> mid = new ArrayList<List<Integer>>();
        for(int i = end - 1; i > 1; i--){
            if(i < end - 1 && num[i] == num[i + 1]) continue;
            List<List<Integer>> mid = twoSum(num, i, tgt - num[i]);
            for(int j = 0; j < mid.size(); j++){
                List<Integer> tmp = mid.get(j);
                tmp.add(num[end]);
            }
            ret.addAll(mid);
        }
    }
    
    private List<List<Integer>> twoSum(int[] num, int end, int tgt){
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        int l = 0, r = end - 1;
        while(l < r){
            if(num[l] + num[r] == tgt){
                List<Integer> tmp = new ArrayList<Integer>();
                tmp.add(num[l]);
                tmp.add(num[r]);
                tmp.add(num[end]);
                ret.add(tmp);
                l++;
                r--;
                while(l < r && num[l] == num[l - 1])
                    l++;
                while(l < r && num[r] == num[r + 1])
                    r--;
            }
            else if(num[l] + num[r] > tgt)
                r--;
            else 
                l++;
        }
        return ret;
    }
}
