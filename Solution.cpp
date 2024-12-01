
#include <vector>
using namespace std;

class Solution {

    int minLengthOfIncreasingSubarray = 0;

public:
    bool hasIncreasingSubarrays(const vector<int>& input, int minLengthOfIncreasingSubarray) {
        this->minLengthOfIncreasingSubarray = minLengthOfIncreasingSubarray;
        int currentIncreasingCount = 1;
        int previousIncreasingCount = 0;

        for (size_t i = 1; i < input.size(); ++i) {
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
    }

private:
    bool foundTwoAdjacentIncreasingSubarraysWithMinLength(int currentIncreasingCount, int previousIncreasingCount) const {
        return currentIncreasingCount >= 2 * minLengthOfIncreasingSubarray
               || (currentIncreasingCount >= minLengthOfIncreasingSubarray
               && previousIncreasingCount >= minLengthOfIncreasingSubarray);
    }
};
