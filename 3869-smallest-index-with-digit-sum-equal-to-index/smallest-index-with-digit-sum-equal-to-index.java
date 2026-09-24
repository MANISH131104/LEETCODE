class Solution {
    public int smallestIndex(int[] nums) {
        int smallestIndex = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            int n = nums[i];
            int sum = 0;
            while(n>0){
                int digit = n%10;
                sum += digit;
                n = n/10;
            }
            if(sum==i){
                smallestIndex = Math.min(smallestIndex,i);
            }
        }
        if(smallestIndex == Integer.MAX_VALUE) return -1;
        else return smallestIndex;
    }
}