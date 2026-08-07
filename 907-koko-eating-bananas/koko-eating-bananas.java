class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for(int ele: piles){
            max = Math.max(max,ele);
        }
        int lo = 1;
        int hi = max;
        int speed = max;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(hours(mid,piles)<=h){
                hi=mid-1;
                speed=mid;
            }
            else lo=mid+1;
        }
        return speed;
    }
    private static long hours(int speed, int[] arr){
        long h=0;
        for(int ele: arr){
            h += (ele + (long)speed - 1) / speed;
        }
        return h;
    }
}