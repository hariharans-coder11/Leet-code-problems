class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // Early exit: ransomNote cannot be formed if it's longer than magazine
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] charCounts = new int[26];

        // Count frequencies of each character in magazine
        for (char c : magazine.toCharArray()) {
            charCounts[c - 'a']++;
        }

        // Validate character availability for ransomNote
        for (char c : ransomNote.toCharArray()) {
            if (charCounts[c - 'a'] == 0) {
                return false; // Character missing or insufficient quantity
            }
            charCounts[c - 'a']--;
        }

        return true;
    }
}
