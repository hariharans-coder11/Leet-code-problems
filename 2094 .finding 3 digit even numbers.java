import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        // Step 1: Count the frequency of each digit (0-9) in the input array
        int[] freq = new int[10];
        for (int digit : digits) {
            freq[digit]++;
        }

        List<Integer> result = new ArrayList<>();

        // Step 2: Iterate through all possible 3-digit even numbers (100 to 998, stepping by 2)
        for (int num = 100; num < 1000; num += 2) {
            int d1 = num / 100;         // Hundreds digit
            int d2 = (num / 10) % 10;   // Tens digit
            int d3 = num % 10;          // Units digit

            // Step 3: Count how many times each digit is needed for the current number
            int[] currentFreq = new int[10];
            currentFreq[d1]++;
            currentFreq[d2]++;
            currentFreq[d3]++;

            // Step 4: Check if the input digits contain enough of each required digit
            boolean canForm = true;
            for (int i = 0; i < 10; i++) {
                if (currentFreq[i] > freq[i]) {
                    canForm = false;
                    break;
                }
            }

            // Step 5: If valid, add to our list
            if (canForm) {
                result.add(num);
            }
        }

        // Step 6: Convert List<Integer> to int[]
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}
