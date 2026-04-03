class Solution {
    public boolean isPalindrome(String s) {
        // Strip first (remove alphanumerics, make lowercase)
        // Remove anything not (0-9, a-z, A-Z)
        String stripped = s.replaceAll("[^0-9a-zA-Z]", "").toLowerCase();

        // Now all we have to check is if it's the same back to front or front to back
        // "wasitacaroracatisaw"
        //           l                 
        //           r
        int l = 0;
        int r = stripped.length()-1;

        while (l <= r) {
            if (stripped.charAt(l) != stripped.charAt(r)) {
                return false;
            }
            l += 1;
            r -= 1;
        }

        return true;
    }
}


// Return true if a string is a palindrome, otherwise return false
// Palindrome is a string that's read front to back the same way back to front.

// Input: s = "Was it a car or a cat I saw?"
// Strip it = "wasitacaroracatisaw"
// Reverse =  "wasitacaroracatisaw"
// Reverse the palindrome and see if the reverse is the same as the og.

// Condition:
// 1. ignores all non-alphanumeric characters. (things not A-Z, a-z, 0-9, even spaces)
// Output: true

// Input: s = "tab a cat"
// Strip: "tabacat"
// Rev  : "tacabat"
// Output: false