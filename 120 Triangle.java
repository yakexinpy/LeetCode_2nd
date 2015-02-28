public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] min = new int[size];
        for(int i = 0; i < size; i++)
            min[i] = triangle.get(size - 1).get(i);
        for(int i = size - 2; i >= 0; i--){
            for(int j = 0; j <= i; j++)
                min[j] = triangle.get(i).get(j) + Math.min(min[j], min[j + 1]);
        }
        
        return min[0];
    }
}
