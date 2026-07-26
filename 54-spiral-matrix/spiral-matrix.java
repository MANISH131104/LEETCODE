class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int sRow = 0;
        int sCol = 0;
        int eRow = m-1;
        int eCol = n-1;

        while(sRow<=eRow && sCol<=eCol){
            // top
            for(int j=sCol; j<=eCol; j++){
                ans.add(matrix[sCol][j]);
            }
            // right
            for(int i=sRow+1; i<=eRow; i++){
                ans.add(matrix[i][eCol]);
            }
            // bottom
            for(int j=eCol-1; j>=sCol; j--){
                if(sRow==eRow) break;
                ans.add(matrix[eRow][j]);
            }
            // left
            for(int i=eRow-1; i>=sRow+1; i--){
                if(sCol==eCol) break;
                ans.add(matrix[i][sCol]);
            }
            sRow++;
            eRow--;
            sCol++;
            eCol--;
        }
        return ans;
    }
}