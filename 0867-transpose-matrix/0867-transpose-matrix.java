class Solution {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        // Create a new matrix with swapped dimensions (n x m)
        int[][] result = new int[n][m];
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                result[c][r] = matrix[r][c];
            }
        }
        
        return result;
    }
}