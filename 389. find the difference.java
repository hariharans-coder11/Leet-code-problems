class Solution {
    public char findTheDifference(String s, String t) {
        char[] top = t.toCharArray(); 
        char[] aop = s.toCharArray(); // Changed 'a' to 's'
        
        long sum = 0; 
        long diff = 0; // Added variable type 'long'
        
        for (char c : top) {
            sum += c; 
        }
        
        for (char c : aop) {
            diff += c; 
        }
        
        return (char) (sum - diff); 
    }
}
