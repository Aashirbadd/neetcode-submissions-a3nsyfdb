class Solution {
    public boolean isAnagram(String s, String t) {
        // If two different strings contains the same chars but different order, ret true.
        HashMap<Character, Integer> sMap = new HashMap<>();

        // Map them both out (Char -> Frequency)
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            sMap.put(curr, sMap.getOrDefault(curr, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char curr = t.charAt(i);
            sMap.put(curr, sMap.getOrDefault(curr, 0) - 1);
        }

        // Verify all keys map to 0.
        for (char key : sMap.keySet()) {
            if (sMap.get(key) != 0) {
                return false;
            }
        }

        // All are zeroes, ret true.
        return true;
    }
}
