import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        // If endWord is not in the dictionary, no sequence is possible
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(beginWord, 1));
        
        while (!queue.isEmpty()) {
            Pair<String, Integer> current = queue.poll();
            String word = current.getKey();
            int steps = current.getValue();
            
            // If we reached the target word, return the step count
            if (word.equals(endWord)) {
                return steps;
            }
            
            // Try changing each character in the current word
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char originalChar = chars[i];
                
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == originalChar) continue;
                    
                    chars[i] = c;
                    String neighbor = new String(chars);
                    
                    if (wordSet.contains(neighbor)) {
                        wordSet.remove(neighbor); // Mark as visited by removing it
                        queue.offer(new Pair<>(neighbor, steps + 1));
                    }
                }
                
                chars[i] = originalChar; // Restore character for the next position
            }
        }
        
        return 0; // If BFS finishes without reaching endWord
    }
}

// Simple Pair helper class (or use int[] / custom wrapper)
class Pair<K, V> {
    private K key;
    private V value;
    
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    
    public K getKey() { return key; }
    public V getValue() { return value; }
}