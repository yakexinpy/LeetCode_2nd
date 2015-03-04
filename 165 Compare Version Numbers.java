public class Solution {
    public int compareVersion(String version1, String version2) {
        char[] chs1 = version1.toCharArray();
        char[] chs2 = version2.toCharArray();
        
        for(int i = 0, j = 0; i < chs1.length || j < chs2.length; i++, j++){
            int num1 = 0, num2 = 0;
            while(i < chs1.length && chs1[i] != '.'){
                num1 = num1 * 10 + (chs1[i] - '0');
                i++;
            }
            
            while(j < chs2.length && chs2[j] != '.'){
                num2 = num2 * 10 + (chs2[j] - '0');
                j++;
            }
            
            if(num1 < num2) return -1;
            if(num1 > num2) return 1;
        }
        return 0;
    }
}
