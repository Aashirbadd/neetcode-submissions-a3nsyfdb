class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        HashMap<Character, Character> openToClose = new HashMap<>();     // Maps an opening bracket to closing bracket
        openToClose.put('[', ']');
        openToClose.put('{', '}');
        openToClose.put('(', ')');

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (openToClose.containsKey(curr)) {
                // Opening bracket...
                stack.push(curr);
            } else {
                // Closing bracket...
                if (stack.isEmpty() || openToClose.get(stack.peek()) != curr) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        // Input: "([{}])"
        //              i
        // Stack: {  }
        // If stack is empty then its fully valid, if in the end there's something in the stack it means we have
        // extra opening brackets...

        return stack.size() == 0;
    }
}

// Input string contains: '(', ')', '{', '}', '[' and ']'.

// It is valid iff:
// 1. Every open bracket is closed by the same type of close bracket.
// 2. Open brackets are closed in the correct order.
// 3. Every close bracket has a corresponding open bracket of the same type.

// Test Cases:
// Input: s = "[]" --> True
// Input: s = "([{}])" --> true --> Keep in mind that this is a nested case..
// Input: s = "[(])" --> False --> (] are not the correct order of open and close mate....

// Input: "([{}])"
//               ^

// Stack: {  }
// If the stack is empty by the end of the scan, it's valid
// Else invalid. Also if there was the wrong type of closing bracket, it was also invalid.

