public class Solution {
    public List<Integer> grayCode(int n) {
        int size = 1 << n;
        List<Integer> ret = new ArrayList<Integer>();
        
        for(int i = 0; i < size; i++){
            ret.add(i ^ (i >> 1));
        }
        return ret;
    }
}
