class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int maxArea = 0;
        while (l < r) {
            int height = Math.min(heights[l], heights[r]);
            int width = r - l;
            int area = height * width;
            maxArea = Math.max(maxArea, area);

            if (heights[l] < heights[r]){
                l ++;
            } else {
                r --;
            }
        }
        return maxArea;
    }
}

// input: int[] heights
// Choose two bars that form a container with the maximum area.

// i,j are the vertical heights
// (j>i) j - i is the width of the container
// Return the MAX amount of water that a container can store.

// Index:           0 1 2 3 4 5 6 7
// Input: height = [1,7,2,5,4,7,3,6]
//                    i
//                            j
// Height * Width
// Height = Min(Height[i], Height[j]) = 7
// Width = J - I = 4
// CurrentArea = 28
// MaxArea = 36
// Output: 36
