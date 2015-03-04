public class Solution {
    public String countAndSay(int n) {
        String ret = "1";
        n--;
        
        while(n > 0){
            int count = 1;
            String tmp = "";
            for(int i = 1; i <= ret.length(); i++){
                if(i < ret.length() && ret.charAt(i) == ret.charAt(i - 1)){
                    count++;
                }
                else{
                    tmp =  tmp + count + ret.charAt(i - 1);
                    count = 1;
                }
            }
            ret = tmp;
            n--;
        }
        
        return ret;
    }
}
