class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                swap(matrix,i,j);
            }
        }
        for(int i=0; i<n; i++){
            reverse(matrix[i]);
        }
    }
    void reverse(int[] matrix){
        int i=0;
        int j=matrix.length-1;
        while(i<j){
            int temp = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = temp;
            i++;
            j--;
        }
    }
    void swap(int[][] matrix, int i, int j){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
}