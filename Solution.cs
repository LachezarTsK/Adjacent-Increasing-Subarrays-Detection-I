
using System;

public class Solution
{
    private int minLengthOfIncreasingSubarray;

    public bool HasIncreasingSubarrays(IList<int> input, int minLengthOfIncreasingSubarray)
    {
        this.minLengthOfIncreasingSubarray = minLengthOfIncreasingSubarray;
        int currentIncreasingCount = 1;
        int previousIncreasingCount = 0;

        for (int i = 1; i < input.Count; ++i)
        {
            if (FoundTwoAdjacentIncreasingSubarraysWithMinLength(currentIncreasingCount, previousIncreasingCount))
            {
                return true;
            }

            if (input[i - 1] >= input[i])
            {
                previousIncreasingCount = currentIncreasingCount;
                currentIncreasingCount = 1;
                continue;
            }
            ++currentIncreasingCount;
        }
        return FoundTwoAdjacentIncreasingSubarraysWithMinLength(currentIncreasingCount, previousIncreasingCount);
    }

    private bool FoundTwoAdjacentIncreasingSubarraysWithMinLength(int currentIncreasingCount, int previousIncreasingCount)
    {
        return currentIncreasingCount >= 2 * minLengthOfIncreasingSubarray
               || (currentIncreasingCount >= minLengthOfIncreasingSubarray
               && previousIncreasingCount >= minLengthOfIncreasingSubarray);
    }
}
