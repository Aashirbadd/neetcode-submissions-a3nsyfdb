class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int r = 0; r < tokens.length; r++) {
            String curr = tokens[r];
            if (Character.isDigit(curr.charAt(curr.length() - 1))) {
                stack.push(Integer.parseInt(curr));
            } else {
                String operand = tokens[r];
                int rVal = stack.pop();
                int lVal = stack.pop();

                if (operand.equals("+")) {
                    lVal += rVal;
                }
                else if (operand.equals("-")) {
                    lVal -= rVal;
                }
                else if (operand.equals("*")) {
                    lVal *= rVal;
                }
                else if (operand.equals("/")) {
                    lVal /= rVal;
                }
                stack.push(lVal);
            }
        }

        return stack.peek();
    }
}

// Input: tokens = ["1","2","+","3","*","4","-"]
//                               l
//                                       r
//                                           o
// Output: 5

// Explanation: ((1 + 2) * 3) - 4 = 5