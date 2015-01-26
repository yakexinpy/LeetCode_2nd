public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<String>();
        if(digits == null || digits.length() < 1){
            ret.add("");
            return ret;
        }
        
        char[] chs = digits.toCharArray();
        for(int i = 0; i < chs.length; i++){
            String str = getChars(chs[i]);
            ArrayList<String> tmp = new ArrayList<String>();
            if(ret.size() < 1){
                String s = "";
                for(int k = 0; k < str.length(); k++){
                    tmp.add(s + "" + str.charAt(k));
                }
                ret.clear();
                ret.addAll(tmp);
                continue;
            }
            for(int j = 0; j < ret.size(); j++){
                String s = ret.get(j);
                for(int k = 0; k < str.length(); k++){
                    tmp.add(s + "" + str.charAt(k));
                }
            }
            ret.clear();
            ret.addAll(tmp);
        }
        
        return ret;
    }
    
    private String getChars(char ch){
        switch(ch){
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            default:
                return "";
        }
    }
}
