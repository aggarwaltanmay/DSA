class Solution {
public int maxScoreSightseeingPair(int[] values) {
    // Initialize max_left with first element
    int maxLeft = values[0] + 0;
    int result = 0;

    for (int j = 1; j < values.length; j++) {
        // Calculate score using decomposed formula
        // score = (values[i] + i) + (values[j] - j)
        int rightComponent = values[j] - j;
        int score = maxLeft + rightComponent;

        // Update result if better score found
        result = Math.max(result, score);

        // Update max_left for next iteration
        // maxLeft represents max(values[i] + i) for all i < j
        int leftComponent = values[j] + j;
        maxLeft = Math.max(maxLeft, leftComponent);
    }

    return result;
}
}