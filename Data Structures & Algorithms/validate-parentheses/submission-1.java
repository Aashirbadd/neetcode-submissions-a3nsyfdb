class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        HashMap<Character, Character> map = new HashMap<>(); // Close maps to open bracket
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);

            if (currChar == '(' || currChar == '{' || currChar == '[') {
                stack.push(currChar); // Opening bracket
            } else {
                // Must mean we have a closing bracket
                char open = map.get(currChar);
                if (!stack.isEmpty() && stack.peek() == open) {
                    stack.pop();    // Correct closing bracket, remove unclosed open.
                } else {
                    return false;   // Wrong closing bracket for what's open
                }
            }
        }

        return stack.size() == 0;
        // 0 len means no open brackets left, else means there are unclosed brackets.
    }
}

// Given a string s consisting of the following characters: 
// '(', ')', '{', '}', '[' and ']'

// Return true iff every open bracked is closed by the same type of close bracket
// Open brackets are closed in the correct order
// Every close bracket has a corresponding open bracket of the same type.

// Examples:
// Input: s = "[(])"
//               ^
// Stack: [( --> Ret false.
// Stack only stores opening brackets, and we will only pop if it has the correct
// closing bracket, else retur false.
// If we've gone through the whole string s, and there's nothing left in the stack then ret true
// Else it means there is an unclosed bracket, so we return false.
// Output: true