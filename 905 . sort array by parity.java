class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            // If left is already even, move left forward
            if (nums[left] % 2 == 0) {
                left++;
            } 
            // If right is already odd, move right backward
            else if (nums[right] % 2 != 0) {
                right--;
            } 
            // Left is odd AND right is even -> swap them!
            else {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                
                left++;
                right--;
            }
        }

        return nums;
    }
}
