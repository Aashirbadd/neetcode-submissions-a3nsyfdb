class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Given a string s, find the length of the longest substring without duplicates...

        // Seen: 
        // Index:      0123456
        // Input: s = "zxyzxyz"
        //                l
        //                   r
        // Output: 3
        int l = 0;
        int maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();  // Has Character, and its index...
        for (int r = 0; r < s.length(); r++) {
            // Case that r already exists
            char curr = s.charAt(r);
            if (map.containsKey(curr) && map.get(curr) >= l) {
                l = map.get(curr) + 1;
            }

            map.put(curr, r);
            int len = r - l + 1;
            maxLen = Math.max(len, maxLen);
        }

        return maxLen;
    }
    // s="abcabcbb"
    //    l
    //       r
}
