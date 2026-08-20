class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        int n = s.length();
        if(s.isEmpty()) return 0;
        int i=0;
        int sign = 1;
        long num = 0;
        if(s.charAt(i)=='-'){
            sign = -1;
            i++;
        }
        else if(s.charAt(i) == '+') {
            i++;
        }
        while(i<n && Character.isDigit(s.charAt(i))){
            num = (num*10)+(s.charAt(i)-'0');
            if((sign*num)>Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if((sign*num)<Integer.MIN_VALUE) return Integer.MIN_VALUE;
            i++;
        }
        return (int) (sign*num);
    }
}