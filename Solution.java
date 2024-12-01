
import java.util.List;

public class Solution {

    private int minLengthOfIncreasingSubarray;

    public boolean hasIncreasingSubarrays(List<Integer> input, int minLengthOfIncreasingSubarray) {
        this.minLengthOfIncreasingSubarray = minLengthOfIncreasingSubarray;
        int currentIncreasingCount = 1;
        int previousIncreasingCount = 0;

        for (int i = 1; i < input.size(); ++i) {
            if (foundTwoAdjacentIncreasingSubarraysWithMinLength(currentIncreasingCount, previousIncreasingCount)) {
                return true;
            }

            if (input.get(i - 1) >= input.get(i)) {
                previousIncreasingCount = currentIncreasingCount;
                currentIncreasingCount = 1;
                continue;
            }
            ++currentIncreasingCount;
        }
        return foundTwoAdjacentIncreasingSubarraysWithMinLength(currentIncreasingCount, previousIncreasingCount);
    }

    private boolean foundTwoAdjacentIncreasingSubarraysWithMinLength(int currentIncreasingCount, int previousIncreasingCount) {
        return currentIncreasingCount >= 2 * minLengthOfIncreasingSubarray
               || (currentIncreasingCount >= minLengthOfIncreasingSubarray
               && previousIncreasingCount >= minLengthOfIncreasingSubarray);
    }
}
