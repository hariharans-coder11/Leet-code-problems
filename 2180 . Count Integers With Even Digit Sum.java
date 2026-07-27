class Solution {
    public int countEven(int num) {
        int temp = num;
        int digitSum = 0;
        
        // Calculate the digit sum of num
        while (temp > 0) {
            digitSum += temp % 10;
            temp /= 10;
        }
        
        // If the digit sum of num is even, num / 2 numbers qualify.
        // If odd, (num - 1) / 2 numbers qualify.
        return (digitSum % 2 == 0) ? num / 2 : (num - 1) / 2;
    }
}
