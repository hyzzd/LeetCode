class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList<>();
        if(S == null || S.length() == 0){
            ans.add("");
            return ans;    
        } // I forgot to check the edge condition
        
        List<String> results = letterCasePermutation(S.substring(1));
        for(String result: results){
            if(Character.isLetter(S.charAt(0))){
                ans.add(S.substring(0,1).toLowerCase()+result);
                ans.add(S.substring(0,1).toUpperCase()+result);
            }else
                ans.add(S.substring(0,1)+result);
        }
        return ans;
    }
}
// recursive method
// O(n)
// O(n)
