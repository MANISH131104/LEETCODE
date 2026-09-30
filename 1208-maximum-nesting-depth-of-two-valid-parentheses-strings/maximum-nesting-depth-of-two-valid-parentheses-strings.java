class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] ans = new int[n];
        int depth = 0;
        for(int i=0; i<n; i++){
            if(seq.charAt(i)=='('){
                depth++;
                if(depth%2==0) ans[i]=0;
                else ans[i]=1;
            }
            else{
                if(depth%2==0) ans[i]=0;
                else ans[i]=1;
                depth--;
            }
            
        }
        return ans;
    }
}