class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // If s1 is a substring of s2, then ret false
        if (s1.length() > s2.length()) {
            return false;   // There's no way s1 can be a substring of s2 in this case...
        }

        HashMap<Character, Integer> s1Freq = new HashMap<>();

        // First we need to obtain the frequencymap of s1...
        for (char c : s1.toCharArray()) {
            s1Freq.put(c, s1Freq.getOrDefault(c, 0) + 1);
        }
        // Input: s1 = "abc", s2 = "lecaabee"
        // F1 = {a:1, b:1, c:1}
        // F2 = {}
        // s2 = "lecaabee"
        //         l
        //           r
        int l = 0;
        HashMap<Character, Integer> s2Freq = new HashMap<>();
        for (int r = 0; r < s2.length(); r++) {
            char rChar = s2.charAt(r);
            if (s1Freq.containsKey(rChar)) {
                // Currently valid
                s2Freq.put(rChar, s2Freq.getOrDefault(rChar, 0) + 1);
                while (s2Freq.get(rChar) > s1Freq.get(rChar)) {
                    char lChar = s2.charAt(l);
                    l += 1;
                    s2Freq.put(lChar, s2Freq.getOrDefault(lChar, 0) - 1);

                }
                int windowLength = r - l + 1;
                if (windowLength == s1.length()) {
                    return true;
                }
            } else {
                // Invalid, means we MUST push left pointer past r.
                l = r + 1;
                s2Freq = new HashMap<>();
            }
        }

        return false;
    }
}

// Given two strings (s1) and (s2) return whether s2 contains a permutation of s1. Or false otherwise???
// To be true... S1 exists as a substring of S2.
// So length of s1 <= s2 for it to even be valid...

// And for it to be a permutation it must simply have a contigious sequence of characters with the same frequencyMap...

// Input: s1 = "abc", s2 = "lecaabee"
// F1 = {a:1, b:1, c:1}
// F2 = {}
// s2 = "lecaabee"
//              l
//              r

// If invalid, we can increment the left pointer (because it's useless rn)
// If valid, we only increment the right pointer...
// Output: true