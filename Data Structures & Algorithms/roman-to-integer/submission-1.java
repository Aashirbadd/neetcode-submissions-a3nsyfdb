class Solution {
    public int romanToInt(String s) {
        // Map for roman to int
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        // Main algorithm, go letter by letter, and compute the sum
        int sum = 0;
        for (int l = 0; l < s.length(); l++) {
            int leftInt = romanMap.get(s.charAt(l));
            if (l == s.length() - 1) {
                sum += leftInt;
                break;
            }

            int r = l + 1;
            int rightInt = romanMap.get(s.charAt(r));

            if (leftInt >= rightInt) {
                sum += leftInt;
            } else {
                sum -= leftInt;
            }
        }

        return sum;
    }
}

// Okay so two main things. Usually you want largest to smallest
// If left > right + left and keep it moving.
// if left < right, then - left and keep it moving...

// XLIX
// 10 50 1 10
//          l   r

// Sol = -10 +50 -1 + 10 = 49 -> Dingdingding...
