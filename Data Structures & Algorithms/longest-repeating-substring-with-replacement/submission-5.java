class Solution {
    public HashMap<Character, Integer> frequency = new HashMap<>();

    public int getMaxFreq(){
        int maxFreq = 0;
        for (Character ch : frequency.keySet()) {
            int currFreq = frequency.get(ch);
            maxFreq = Math.max(currFreq, maxFreq);
        }
        return maxFreq;
    }

    public int characterReplacement(String s, int k) {

        if (s.length() <= 1) return s.length();

        int l = 0;
        int r = 0;
        int longest = 0;

        while (r < s.length()) {
            // s="AABABBA", k=1
            //      l
            //          r
            // freq={A:2,B:3}
            // windowSize = 5, maxFreq=3, currLength = 4, maxLength = 4
            Character cr = s.charAt(r);
            frequency.put(cr, frequency.getOrDefault(cr,0) + 1);
            int maxFreq = getMaxFreq();

            int currLength = r - l + 1;
            if (currLength - maxFreq <= k) {
                // Valid case
                longest = Math.max(currLength, longest);
            } else {
                // Invalid case
                while ((r-l+1) - maxFreq > k) {
                    // System.out.println("r:" + r);
                    // System.out.println(r-l+1);
                    // System.out.println(s.charAt(l));
                    frequency.put(s.charAt(l), frequency.get(s.charAt(l)) -1); // Reduce freq
                    l += 1;
                    maxFreq = getMaxFreq();
                }
            }
            r ++;
        }

        return longest;
        
    }
}


// Input: s = "AAABABB", k = 1
// L              ^
// R                 ^
// Frequency = {A:1, B:3}
// MaxFrequency = 3
// WindowSize =   4
// MaxFreq - WindowSize = 1 == K
// MaxWindow = 5
// Window == Valid if WindowSize - MaxFrequency > K, else not valid.
// Output: 5