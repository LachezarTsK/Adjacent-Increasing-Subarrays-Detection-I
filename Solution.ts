
function hasIncreasingSubarrays(input: number[], minLengthOfIncreasingSubarray: number): boolean {
    this.minLengthOfIncreasingSubarray = minLengthOfIncreasingSubarray;
    let currentIncreasingCount = 1;
    let previousIncreasingCount = 0;

    for (let i = 1; i < input.length; ++i) {
        if (foundTwoAdjacentIncreasingSubarraysWithMinLength(currentIncreasingCount, previousIncreasingCount)) {
            return true;
        }

        if (input[i - 1] >= input[i]) {
            previousIncreasingCount = currentIncreasingCount;
            currentIncreasingCount = 1;
            continue;
        }
        ++currentIncreasingCount;
    }
    return foundTwoAdjacentIncreasingSubarraysWithMinLength(currentIncreasingCount, previousIncreasingCount);
};


function foundTwoAdjacentIncreasingSubarraysWithMinLength(currentIncreasingCount: number, previousIncreasingCount: number): boolean {
    return currentIncreasingCount >= 2 * this.minLengthOfIncreasingSubarray
           || (currentIncreasingCount >= this.minLengthOfIncreasingSubarray
           && previousIncreasingCount >= this.minLengthOfIncreasingSubarray);
}
