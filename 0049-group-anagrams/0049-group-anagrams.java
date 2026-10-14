import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            // Convert string to char array, sort it, and convert back to string for the key
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            
            // If the key doesn't exist, initialize a new list
            map.putIfAbsent(sortedStr, new ArrayList<>());
            
            // Add the original string to its corresponding anagram group
            map.get(sortedStr).add(s);
        }
        
        // Return all grouped lists from the map values
        return new ArrayList<>(map.values());
    }
}