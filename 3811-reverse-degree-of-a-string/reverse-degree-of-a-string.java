class Solution {
    public int reverseDegree(String s) {
        int degree = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            int position = 'z'-ch+1;
            degree += position*(i+1);

        }
        return degree;
    }
}