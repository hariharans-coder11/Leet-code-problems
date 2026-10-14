import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> currentList, int[] nums) {
        // Base case: if the current permutation is complete
        if (currentList.size() == nums.length) {
            result.add(new ArrayList<>(currentList));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            // Skip if the number is already included in the current permutation
            if (currentList.contains(nums[i])) {
                continue;
            }
            
            // Choose
            currentList.add(nums[i]);
            
            // Explore
            backtrack(result, currentList, nums);
            
            // Un-choose (Backtrack)
            currentList.remove(currentList.size() - 1);
        }
    }
}