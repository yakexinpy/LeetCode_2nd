public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new ArrayList<Integer>();
        ret.add(1);
        for(int i = 1; i <= rowIndex; i++){
            for(int j = i; j > 0; j--){
                if(j == i) ret.add(ret.get(i - 1));
                else ret.set(j, ret.get(j) + ret.get(j - 1));
            }
        }
        return ret;
    }
}
