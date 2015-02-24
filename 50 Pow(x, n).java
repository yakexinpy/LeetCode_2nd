public class Solution {
    public double pow(double x, int n) {
        if(n < 0)
            return 1 / helper(x, -n);
        else
            return helper(x, n);
    }
    
    public double helper(double x, int n){
        if(n == 0) return 1;
        double tmp = helper(x, n / 2);
        if(n % 2 != 0)
            return tmp * tmp * x;
        else
            return tmp * tmp;
    }
}
