class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> openToClose = new HashMap<>();
        openToClose.put('[', ']');
        openToClose.put('(', ')');
        openToClose.put('{', '}');

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (openToClose.containsKey(c)) {
                // Is open bracket -> Put in stack
                stack.push(c);
            } else {
                // Is closing bracket -> See if it matches with what's in the stack.
                if (stack.isEmpty() || openToClose.get(stack.peek()) != c) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        // Means everything is valid so far... Ret true if stack is empty...
        return stack.isEmpty();
    }
}

// Understand question:
// Given an input string s, consisting of () {} [].
// It is valid IFF
// 1. Every open bracket is closed by the same type of closing bracket (pair)
// 2. Open brackets are closed in the correct order...
// 3. Every close bracket has a corrosponding open bracket of the same type...

// Return true if S is a valid string else false...

// Input: s = "[(])"
//               ^
// Stack: [(
// Output: false
