class Solution {
    public boolean increasingTriplet(int[] nums) {
        // Initialize them to the maximum possible integer value
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        
        for (int num : nums) {
            if (num <= first) {
                // We found a new smallest number
                first = num;
            } else if (num <= second) {
                // We found a number bigger than 'first' but smaller than 'second'
                second = num;
            } else {
                // We found a number bigger than BOTH 'first' and 'second'
                // This means we have a valid triplet!
                return true; 
            }
        }
        
        // If we get through the whole array without returning true, no triplet exists
        return false;
    }
}