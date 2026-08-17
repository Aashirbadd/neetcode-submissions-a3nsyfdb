class Solution {
    private HashMap<Character, char[]> digitMap = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        
        digitMap.put('2', new char[] {'a', 'b', 'c'});
        digitMap.put('3', new char[] {'d', 'e', 'f'});
        digitMap.put('4', new char[] {'g', 'h', 'i'});
        digitMap.put('5', new char[] {'j', 'k', 'l'});
        digitMap.put('6', new char[] {'m', 'n', 'o'});
        digitMap.put('7', new char[] {'p', 'q', 'r', 's'});
        digitMap.put('8', new char[] {'t', 'u', 'v'});
        digitMap.put('9', new char[] {'w', 'x', 'y', 'z'});
        
        List<String> output = new ArrayList<>();

        dfs(digits, 0, "", output);
        
        return output;
    }
    // Input: digits = "34"
    //                  ^
    // 
    private void dfs(String digits, int i, String curr, List<String> output) {
        // base case
        if (i >= digits.length()) {
            if (curr.length() > 0)  output.add(curr);
            return;
        }

        // Everything in the adjacency list hit it.
        char[] characters = digitMap.get(digits.charAt(i));

        for (char character : characters) {
            dfs(digits, i + 1, curr + character, output);
        }
    }
}

// digits = "34"
// 3 = def, 4 = ghi

// Return all combinations of those digits...

// This can be represented as a decision tree
//          "34"
//          d e f
//      g h i  g h i     g h i

// DFS