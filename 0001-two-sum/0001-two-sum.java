import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Map to store: value -> index
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // If the complement already exists in map, we found the pair
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            
            // Otherwise, store current element and its index
            map.put(nums[i], i);
        }
        
        return new int[] {}; // Fallback return
    }
}