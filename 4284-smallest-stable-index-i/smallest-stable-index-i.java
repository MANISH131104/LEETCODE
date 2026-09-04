class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        for(int i=0; i<n; i++){
            int max = maximum(nums,0,i);
            int min = minimum(nums,i,n-1);

            int value = max-min;
            if(value<=k) return i;
        }
        return -1;
    }
    public int maximum(int[] arr,int start, int end){
        int max = arr[start];
        for(int i=start; i<=end; i++){
           max = Math.max(max, arr[i]);
        }
        return max;
    }
    public int minimum(int[] arr, int start, int end){
        int min = arr[start];
        for(int i=start; i<=end; i++){
            min = Math.min(min,arr[i]);
        }
        return min;
    }
}