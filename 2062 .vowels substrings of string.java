import java.util.HashSet;
import java.util.Set;

class Solution {
    public int countVowelSubstrings(String word) {
        int count = 0;
        int n = word.length();
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        // Loop through each potential starting index of the substring
        for (int i = 0; i < n; i++) {
            Set<Character> seenVowels = new HashSet<>();
            
            // Expand the substring rightwards from start index i
            for (int j = i; j < n; j++) {
                char ch = word.charAt(j);
                
                // If the character is a consonant, stop expanding this substring
                if (!vowels.contains(ch)) {
                    break;
                }
                
                // Add the vowel to our set of seen vowels
                seenVowels.add(ch);
                
                // If all 5 vowels are present, increment our total count
                if (seenVowels.size() == 5) {
                    count++;
                }
            }
        }

        return count;
    }
}
