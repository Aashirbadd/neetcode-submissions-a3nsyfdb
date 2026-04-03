class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
      Deque<int[]> stack = new ArrayDeque<>();
      int[] output = new int[temperatures.length];

      for (int i = 0; i < temperatures.length; i++) {
        int curr = temperatures[i];
        
        while (!stack.isEmpty() && curr > stack.peek()[0]) {
            int j = stack.pop()[1];
            output[j] = i - j;
        }

        stack.push(new int[] {curr, i});
      }

      while (!stack.isEmpty()) {
        output[stack.pop()[1]] = 0;
      }

      return output;
    }
}

// Input: int[] temperatures (temp on ith day)
// Ret: Array result, where result [i] is the number of days after the ith day
// where a warmer temp appears. If there's no such future date, result[i] == 0.

//                        0  1  2  3  4. 5. 6
// Input: temperatures = [30,38,30,36,35,40,28]
//                           ^
// Max: [30,0],
// Output:               [1 ,4 ,1 , 2,1 ,0  , 0 ]
// Output:               [1, 4 ,1 ,2 ,1 ,0 ,0]