class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(ans,n,0,0,"");
        return ans;
    }
    public void generate(List<String> ans, int n, int l, int r, String s){
        if(l==n && r==n){
            ans.add(s);
            return;
        }
        if(l<n) generate(ans,n,l+1,r,s+"(");
        if(r<l) generate(ans,n,l,r+1,s+")");
    }
}