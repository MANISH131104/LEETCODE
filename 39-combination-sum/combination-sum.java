class Solution {
    HashSet<Integer> set = new HashSet<>();
    public void getAllCombinations(int[] arr, int target, int idx, List<List<Integer>> ans, List<Integer> comb){
        if(idx==arr.length || target<0){
            return;
        }
        if(target==0){
            ans.add(new ArrayList<>(comb));
            return;
        }


        comb.add(arr[idx]);
        // multiple
       getAllCombinations(arr, target - arr[idx], idx, ans, comb);
        // exclusion
        comb.remove(comb.size() - 1);
        getAllCombinations(arr,target,idx+1,ans,comb);

    }
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();

        getAllCombinations(arr,target,0,ans,comb);
        return ans;
    }
}