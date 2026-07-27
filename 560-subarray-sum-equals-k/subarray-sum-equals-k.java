class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int preSum = 0;
        int count = 0;

       for(int i=0; i<n; i++){
        preSum += nums[i];
        int remove = preSum-k;
        count += map.getOrDefault(remove,0);
        map.put(preSum, map.getOrDefault(preSum,0) + 1);
       }
       return count;
    }
}