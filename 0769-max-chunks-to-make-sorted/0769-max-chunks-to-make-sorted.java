class Solution {
    public int maxChunksToSorted(int[] arr) {
        int maxSoFar = 0;
        int chunks = 0;

        for (int i = 0; i < arr.length; i++) {
            // Track the maximum element seen so far
            maxSoFar = Math.max(maxSoFar, arr[i]);

            // If the maximum value seen equals the current index,
            // we can form a valid sorted chunk here
            if (maxSoFar == i) {
                chunks++;
            }
        }

        return chunks;
    }
}