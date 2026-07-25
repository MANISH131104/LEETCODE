class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        int longest = 1;

        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++){
            set.add(nums[i]);
        }

        for(int ele : set){
            if(!set.contains(ele-1)){
                int current = ele;
                int length = 1;

                while(set.contains(current+1)){
                    current++;
                    length++;
                }
                longest = Math.max(longest,length);
            }

        }
        return longest;
    }
}