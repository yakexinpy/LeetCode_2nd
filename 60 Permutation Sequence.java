public class Solution {
    /*
    solution 2
    to calculate the first digit, we should know how many combination will be generated by the following n-1 digits
    */
    
    public String getPermutation(int n, int k) {
        List<Integer> array = new ArrayList<Integer>();
        int fact = 1;
        for(int i = 1; i <= n; i++){
            fact *= i;
            array.add(i);
        }
        fact /= n;
        
        String ret = "";
        k--;
        for(int i = n - 1; i >= 0; i--){
            int d = k / fact;
            ret += "" + array.get(d);
            array.remove(d);
            k = k % fact;
            if(i > 0) fact = fact / i;
        }
        
        return ret;
    }
    
    /* failed solution 1, cannot pass big number
    public String getPermutation(int n, int k) {
        boolean[] visited = new boolean[n];
        List<Integer> res = new ArrayList<Integer>();
        helper(res, visited, 0, n, k);
        
        String ret = "";
        for(Integer i : res){
           ret += "" + i; 
        }
        
        return ret;
    }
    
    private int helper(List<Integer> res, boolean[] visited, int count, int n, int k){
        if(res.size() == n){
            if(count == k){
                return count;
            }
            return count + 1;
        }
        
        for(int i = 0; i < n; i++){
            if(visited[i]) continue;
            res.add(i + 1);
            visited[i] = true;
            count = helper(res, visited, count, n, k);
            if(count == k)
                return count;
            visited[i] = false;
            res.remove(res.size() - 1);
        }
        
        return count;
    }*/
   
}