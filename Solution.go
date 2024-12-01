
package main

import "fmt"

var minLengthOfIncreasingSubarray int

func hasIncreasingSubarrays(input []int, minimumLengthOfIncreasingSubarray int) bool {
    minLengthOfIncreasingSubarray = minimumLengthOfIncreasingSubarray
    currentIncreasingCount := 1
    previousIncreasingCount := 0

    for i := 1; i < len(input); i++ {
        if foundTwoAdjacentIncreasingSubarraysWithMinLength(currentIncreasingCount, previousIncreasingCount) {
            return true
        }

        if input[i-1] >= input[i] {
            previousIncreasingCount = currentIncreasingCount
            currentIncreasingCount = 1
            continue
        }
        currentIncreasingCount++
    }
    return foundTwoAdjacentIncreasingSubarraysWithMinLength(currentIncreasingCount, previousIncreasingCount)
}

func foundTwoAdjacentIncreasingSubarraysWithMinLength(currentIncreasingCount int, previousIncreasingCount int) bool {
    return currentIncreasingCount >= 2 * minLengthOfIncreasingSubarray ||
              (currentIncreasingCount >= minLengthOfIncreasingSubarray &&
              previousIncreasingCount >= minLengthOfIncreasingSubarray)
}
