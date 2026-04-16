class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char currLeft = s.charAt(left);
            char currRight = s.charAt(right);

            // Skip non-alphanumeric characters from the left
            if (!Character.isLetterOrDigit(currLeft)) {
                left++;
            } 
            // Skip non-alphanumeric characters from the right
            else if (!Character.isLetterOrDigit(currRight)) {
                right--;
            } 
            // Both characters are alphanumeric, so we compare them
            else {
                if (Character.toLowerCase(currLeft) != Character.toLowerCase(currRight)) {
                    return false;
                }
                left++;
                right--;
            }
        }

        return true;  
    }
}