class Solution {
    public boolean isPalindrome(String s) {
        String clean = s.toLowerCase();
        clean = clean.replaceAll("[^a-zA-Z0-9]", "");

        System.out.println(clean);
        // do a 2 pointer with left and right elements...
        int l = 0, r = clean.length() - 1;
        while (l < r) {
            if (clean.charAt(l) != clean.charAt(r)) {
                // System.out.printf("Left: %s, Right: %s", s.charAt(l), s.charAt(r));
                return false;
            }

            l += 1;
            r -= 1;
        }

        return true;
    }
}

// Input: s = "Was it a car or a cat I saw?"

// Output: true

// First, lowercase, remove spaces, and then remove alphanumerics, then do a 2pointer...