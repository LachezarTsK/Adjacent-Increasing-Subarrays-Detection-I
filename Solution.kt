
class Solution {

    var minLengthOfIncreasingSubarray = 0

    fun hasIncreasingSubarrays(input: List<Int>, minLengthOfIncreasingSubarray: Int): Boolean {
        this.minLengthOfIncreasingSubarray = minLengthOfIncreasingSubarray
        var currentIncreasingCount = 1
        var previousIncreasingCount = 0

        for (i in 1..<input.size) {
            if (foundTwoAdjacentIncreasingSubarraysWithMinLength(currentIncreasingCount, previousIncreasingCount)) {
                return true
            }

            if (input[i - 1] >= input[i]) {
                previousIncreasingCount = currentIncreasingCount
                currentIncreasingCount = 1
                continue
            }
            ++currentIncreasingCount
        }
        return foundTwoAdjacentIncreasingSubarraysWithMinLength(currentIncreasingCount, previousIncreasingCount)
    }

    private fun foundTwoAdjacentIncreasingSubarraysWithMinLength(currentIncreasingCount: Int, previousIncreasingCount: Int): Boolean {
        return currentIncreasingCount >= 2 * minLengthOfIncreasingSubarray
               || (currentIncreasingCount >= minLengthOfIncreasingSubarray
               && previousIncreasingCount >= minLengthOfIncreasingSubarray)
    }
}
