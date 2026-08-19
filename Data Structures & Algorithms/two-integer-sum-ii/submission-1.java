class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Input: numbers = [1,2,3,4], target = 3
        //                   l
        //                          r

        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[] {l+1, r+1};
            }
            else if (sum > target) {
                r -= 1;
            }
            else {
                l += 1;
            }
        }


        return new int[] {};
    }
}