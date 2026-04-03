class Solution {
    int HEIGHT = 0;
    int INDEX = 1;
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> stack = new ArrayDeque<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            // Tip of the stack should have the largest height else pop
            int curr = heights[i];
            int beginningIndex = i;
            while (!stack.isEmpty() && curr <= stack.peek()[HEIGHT]) {
                int[] prev = stack.pop();
                int currArea = prev[HEIGHT] * (i - prev[INDEX]);
                maxArea = Math.max(maxArea, currArea);
                beginningIndex = prev[INDEX];
            }
            stack.push(new int[] {curr, beginningIndex});
        }
        int maxWidth = heights.length;
        while (!stack.isEmpty()) {
            int[] prev = stack.pop();
            int barArea = prev[HEIGHT] * (maxWidth - prev[INDEX]);
            maxArea = Math.max(maxArea, barArea);
        }

        return maxArea;
    }
}

// Input: int[] heights, heights[i] = height of bar (w) = 1
// Return the largest rectangle that can be formed among bars
// heights = [7,1,7,2,2,4]
// sortedH = [1,
// wallL = 7
// wallR = 7
// wallT = 5
// wallB = 4
// Area = w * height
// 7*4 = 28
// Output: 8
