class Solution {
    public int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            // Odd case
            int l = i, r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                count += 1;
                r += 1;
                l -= 1;
            }

            // Even Case
            l = i;
            r = i+1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                count += 1;
                r += 1;
                l -= 1;
            }
        }

        return count;
    }
}
