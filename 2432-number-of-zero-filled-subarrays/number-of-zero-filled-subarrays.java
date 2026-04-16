class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long totalSubarrays = 0; // Use long to prevent integer overflow
        long currentStreak = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                currentStreak++;               // Our streak of zeros grows
                totalSubarrays += currentStreak; // Add the streak to our total
            } else {
                currentStreak = 0;             // We hit a non-zero, reset the streak
            }
        }
        
        return totalSubarrays;
    }
}