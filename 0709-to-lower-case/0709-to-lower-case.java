class Solution {
    public String toLowerCase(String s) {
        char[] chars = s.toCharArray();
        
        for (int i = 0; i < chars.length; i++) {
            // Check if character is uppercase
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                // Convert uppercase to lowercase using ASCII offset
                chars[i] = (char) (chars[i] + ('a' - 'A'));
            }
        }
        
        return new String(chars);
    }
}