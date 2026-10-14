class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        
        // If the starting pixel is already the target color, no change is needed
        if (originalColor != color) {
            dfs(image, sr, sc, originalColor, color);
        }
        
        return image;
    }
    
    private void dfs(int[][] image, int r, int c, int originalColor, int newColor) {
        // Base case: check bounds and whether the current pixel matches the original color
        if (r < 0 || c < 0 || r >= image.length || c >= image[0].length || image[r][c] != originalColor) {
            return;
        }
        
        // Update the pixel with the new color
        image[r][c] = newColor;
        
        // Recursively visit all 4 adjacent directions
        dfs(image, r - 1, c, originalColor, newColor); // Up
        dfs(image, r + 1, c, originalColor, newColor); // Down
        dfs(image, r, c - 1, originalColor, newColor); // Left
        dfs(image, r, c + 1, originalColor, newColor); // Right
    }
}