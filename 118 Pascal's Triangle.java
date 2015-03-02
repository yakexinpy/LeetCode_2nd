public class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(n < 1) return ret;
        ret.add(new ArrayList<Integer>());
        ret.get(0).add(1);
        for(int i = 1; i < n; i++){
            List<Integer> tmp = new ArrayList<Integer>();
            for(int j = 0; j < i + 1; j++){
                if(j == 0) tmp.add(ret.get(i - 1).get(0));
                else if(j == i) tmp.add(ret.get(i - 1).get(i - 1));
                else tmp.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
            }
            ret.add(tmp);
        }
        return ret;
    }
}
