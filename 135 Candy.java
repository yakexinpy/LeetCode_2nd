public class Solution {
    public int candy(int[] ratings) {
        int[] l2r = new int[ratings.length];
        l2r[0] = 1;
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] > ratings[i - 1])
                l2r[i] = l2r[i - 1] + 1;
            else
                l2r[i] = 1;
        }
        
        int[] r2l = new int[ratings.length];
        r2l[ratings.length - 1] = 1;
        for(int i = ratings.length - 2; i >= 0; i--)
            if(ratings[i] > ratings[i + 1])
                r2l[i] = r2l[i + 1] + 1;
            else
                r2l[i] = 1;
        
        int sum = 0;
        for(int i = 0; i < ratings.length; i++)
            sum += Math.max(r2l[i], l2r[i]);
        return sum;
    }
}
