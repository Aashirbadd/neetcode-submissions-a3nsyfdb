class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int[] output = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
          // Prefill with zeroes...
          output[i] = 0;
        }

        for (int i = 0; i < temperatures.length; i++) {
          // If stack is empty or element is larger, push
          int curr = temperatures[i];
          if (stack.isEmpty() || stack.peek()[0] > curr) {
            stack.push(new int[] {curr, i});
          } else {
            // Else pop
            // Means that top of stack < curr.. Keep popping while this is the case
            while (!stack.isEmpty() && stack.peek()[0] < curr) {
              int[] toRemove = stack.pop();
              output[toRemove[1]] = i - toRemove[1];
            }
            stack.push(new int[] {curr, i});
          }
        }

        return output;
    }
}

// Given an array of temperatures on the ith day.
// Return an array (result) -> Where result[i] is the number of days after the ith day before a
// warmer temperature appears on a future day. If there is no such day in the future where a warmer
// temperature appears, then return 0 instead.


// Input: temperatures = [30,38,30,36,35,40,28]
// Output:               [1 , 4, 1, 2, 1, 0, 0]

