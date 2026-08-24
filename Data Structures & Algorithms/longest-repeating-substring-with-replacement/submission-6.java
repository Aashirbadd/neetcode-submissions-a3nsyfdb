class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();

        int maxLen = 0, l = 0;

        for (int r = 0; r < s.length(); r++) {
            int windowSize = r - l + 1;
            char currChar = s.charAt(r);
            map.put(currChar, map.getOrDefault(currChar, 0) + 1);
            int maxFreq = Collections.max(map.values());

            if (windowSize - maxFreq <= k) {
                // Valid window, check if that's the maxLen
                maxLen = Math.max(windowSize, maxLen);
            } else {
                // Keep shrinking window till it's valid again...
                while (windowSize - maxFreq > k && l < r) {
                    // Reduce frequency of the number at L
                    char lChar = s.charAt(l);
                    map.put(lChar, map.get(lChar) - 1);
                    // Then reduce window size, and recalculate maxFrequency
                    l += 1;
                    windowSize = r-l+1;
                    maxFreq = Collections.max(map.values());
                }
            }
        }

        return maxLen;
    }
}

// Input: s = "XYYX", k = 1
//              l
//                 r
// Output = 4 because? MaxFreq = 2, + 2 = 4!
// Main formula of this equasion is while windowSize - maxFreq < k it's valid. thus that could be a proper answer!