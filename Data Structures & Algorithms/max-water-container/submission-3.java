class Solution {
    //                  0 1 2 3 4 5 6 7   8  9 0 1 2 3 4
    // Input: height = [1,7,2,5,12,3,500,500,7,8,4,7,3,6]
    //                                l                              
    //                                     r

    // Return the max area that the container can store...
    // Move the smaller one everytime in hopes to find a taller container that's narrower...

    public int maxArea(int[] heights) {
        int max = 0, l = 0, r = heights.length - 1;

        while (l < r) {
            // System.out.printf("Left : %d, Right: %d", l, r);
            int height = Math.min(heights[l], heights[r]);
            int width = r - l;

            int currArea = height * width;
            max = Math.max(max, currArea);

            if (heights[r] <= heights[l]) {
                r -= 1;
            } else {
                l += 1;
            }
        }

        return max;
    }
}
