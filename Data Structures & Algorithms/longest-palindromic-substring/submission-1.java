class Solution {
    public String longestPalindrome(String s) {
        String currLongest = "";

        for (int i = 0; i < s.length(); i++) {
            // Odd Length
            String longestOdd = findLongest(i, i, s);
            if (longestOdd.length() > currLongest.length()) {
                currLongest = longestOdd;
            }
            // Even length
            String longestEven = findLongest(i, i+1, s);
            if (longestEven.length() > currLongest.length()) {
                currLongest = longestEven;
            }
        }

        return currLongest;
    }

    private String findLongest(int l, int r, String s) {
        String currLongest = "";

        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            // Valid, mean update currLongest, and expand pointers
            int len = r - l + 1;
            // System.out.printf("Len: %d, currSSLen: %d\n", len, currLongest.length());
            if (len > currLongest.length()) {
                // System.out.printf("ss: %s, len: %d\n", s.substring(l, r + 1), len);
                currLongest = new String(s.substring(l, r + 1));
            }
            l -= 1;
            r += 1;
        }

        return currLongest;
    }
}

// Input: s = "ababd"

// Center, expansion type of flow... 

// Given a string s, return the longest substring within s that's a palindrome...
// 