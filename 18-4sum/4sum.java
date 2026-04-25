import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        
        // Base case: if we have less than 4 elements, we can't form a quadruplet
        if (n < 4) {
            return result;
        }

        // Step 1: Sort the array to handle duplicates and enable two-pointers
        Arrays.sort(nums);

        // Step 2: Fix the first element
        for (int i = 0; i < n - 3; i++) {
            // Skip duplicates for the very first number
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Step 3: Fix the second element
            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicates for the second number
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                // Step 4: Setup two pointers for the remaining subarray
                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    // Prevent integer overflow by casting the sum to a long
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        // We found a valid quadruplet!
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        
                        // Crucial Step: Skip duplicates for the left pointer
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        // Crucial Step: Skip duplicates for the right pointer
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        
                        // Move both pointers inward to look for other combinations
                        left++;
                        right--;
                        
                    } else if (sum < target) {
                        // Sum is too small, need a larger number, move left pointer right
                        left++;
                    } else {
                        // Sum is too large, need a smaller number, move right pointer left
                        right--;
                    }
                }
            }
        }
        
        return result;
    }
}