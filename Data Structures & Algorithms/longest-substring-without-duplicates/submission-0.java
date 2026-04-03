class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;


        int maxLength = 1;
        int l = 0;
        int r = 1;
        map.put(s.charAt(l), l);

        while (r < s.length()) {
            Character currChar = s.charAt(r);
            if (map.containsKey(currChar) && map.get(currChar) >= l) {
                l = map.get(currChar) + 1;
            }
            
            map.put(currChar, r);
            
            int currLength = r - l + 1;
            maxLength = Math.max(currLength, maxLength);
            r += 1;
        }
        
        return maxLength;
    }
}

// Indices:    0123456
// Input: s = "xyzzxyz"
//                   ^
//                    ^
// Map = {[x:4],[y:5],[z:6]}
// Repeat? = f
// Length  = 3
// MaxLength = 3
// Output: 3