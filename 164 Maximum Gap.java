public class Solution {
    public int maximumGap(int[] num) {
        int min = 0, max = 0;
        for(int i = 0; i < num.length; i++){
            min = Math.min(min, num[i]);
            max = Math.max(max, num[i]);
        }
        
        int[] maxs = new int[num.length + 1];
        int[] mins = new int[num.length + 1];
        boolean[] isFilled = new boolean[num.length + 1];
        
        for(int i = 0; i < num.length; i++){
            int index = getIndex((num[i] - min), num.length, (max - min));
            if(!isFilled[index]){
                isFilled[index] = true;
                maxs[index] = mins[index] = num[i];
            }
            else{
                maxs[index] = Math.max(maxs[index], num[i]);
                mins[index] = Math.min(mins[index], num[i]);
            }
        }
        
        int last = -1, ret = 0;
        for(int i = 0; i < num.length + 1; i++){
            if(isFilled[i]){
                if(last < 0)
                    last = maxs[i];
                else{
                    ret = Math.max(ret, mins[i] - last);
                    last = maxs[i];
                }
            }
        }
        return ret;
    }
    
    private int getIndex(int num, int n, int d){
        long x = (long) num;
        long y = (long) n;
        return (int)(x * y / d);
    }
}
