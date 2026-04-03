class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<Integer>();

        for (String s : tokens) {
            if (!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/")) {
                stack.push(Integer.parseInt(s));
            } else {
                // Means it's an operand, and we need to do an operation.
                int sol = 0;
                int b = stack.pop();
                int a = stack.pop();
                if (s.equals("+"))       sol = a + b;
                else if (s.equals("-"))  sol = a - b;
                else if (s.equals("/"))  sol = a / b;
                else if (s.equals("*"))  sol = a * b;
                // System.out.printf("sol: %d, a: %d, b: %d, s: %s\n", sol, a, b, s);
                stack.push(sol);
            }
        }
        return stack.pop();
    }
}

// Input: String[] tokens --> Represents a valid arithmetic expression in (reverse polish notation)

// What's RPN? 
// Order where operations follow the operands.
// ie: 4 5 + instead of 4 + 5
// Solution: Store the numbers on a stack, and compute things as the tokens come in.