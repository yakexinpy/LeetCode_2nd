public class Solution {
    public String convertToTitle(int n) {
        String title = "";
        int add = 0;
        
        while(n > 0){
            add = n % 26;
            if(add == 0){
                title = 'Z' + title;
                n = n / 26 - 1;
            }
            else{
                title = (char)(add + 'A' - 1) + title;
                n = n / 26;
            }
        }
        return title;
    }
}
