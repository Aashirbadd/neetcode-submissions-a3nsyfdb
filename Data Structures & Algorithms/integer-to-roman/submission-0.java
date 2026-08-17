class Solution {
    public String intToRoman(int num) {
        // Hardcode subtractive forms to avoid edgecases...
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                result.append(symbols[i]);
            }
        }

        return result.toString();
    }
}

// 7 Different symbols represent roman numerals...
// We're converting from decimal to roman, so here are the rules:

// If the value does not start with 4 or 9, find the max value we can subtract from input
// Append that symbol to the result...

// If it DOES start with 4 or 9, use the subtractive form... Represented by 1 subtracted from one more
// For instance 4 is I V, 9 is I X

// 