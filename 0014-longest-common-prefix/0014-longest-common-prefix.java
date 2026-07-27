class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Start with the first string as the initial candidate
        String prefix = strs[0];

        // Compare against each remaining string in the array
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                // Shorten the prefix by one character from the end
                prefix = prefix.substring(0, prefix.length() - 1);
                
                // If there's no common prefix left, return empty string
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }
}