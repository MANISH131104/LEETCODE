class Solution {
    public int maxDepth(String s) {
        int n = s.length();
        int count = 0;
        int ans = 0;
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='('){
                count ++;
                ans =  Math.max(count, ans);
            }
            if(s.charAt(i)==')') count--;
        }
        return ans;
    }
}