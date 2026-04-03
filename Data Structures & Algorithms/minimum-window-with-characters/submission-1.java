class Solution {
    public String minWindow(String s, String t) {
        // i= 0123456789012
        // s="ADOBECODEBANC" , t="ABC"
        //      ^  ^

        // Input: s = "OUZODYXAZV", t = "XYZ"
        //             ^^
        // NeedMap: {t.freqmap}, HaveMap: {substring.freqmap}
        // Need: t.length, Have: 0
        // Output: "YXAZ"

        // Initialize havemap and needmap
        HashMap<Character, Integer> haveMap = new HashMap<>(), needMap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            needMap.put(c, needMap.getOrDefault(c, 0) + 1);
            // System.out.printf("c: %c, freq: %d",c,needMap.get(c));
        }

        int have = 0, need = needMap.size();
        int l = 0, r = 0;
        int solL = l, solR = Integer.MAX_VALUE;
        while (r < s.length()){
            char c = s.charAt(r);
            haveMap.put(c, haveMap.getOrDefault(c, 0) + 1);
            if (needMap.containsKey(c) && needMap.get(c) == haveMap.get(c)) {
                // Means we have a match
                have += 1;
            }
            // System.out.printf("have: %d, need: %d\n", have, need);
            while (have == need) {
                // New Solution, see how much we can push the left pointer in while still being valid.
                // System.out.printf("r: %d, l: %d\n", r, l);
                // System.out.printf("solR: %d, solL: %d\n", solR, solL);
                if (r-l < solR - solL) {
                    solR = r;
                    solL = l;
                }
                if (l < r) {
                    Character cL = s.charAt(l);
                    haveMap.put(cL, haveMap.get(cL) - 1); // decrease freq
                    if (needMap.containsKey(cL) && haveMap.get(cL) < needMap.get(cL))
                        have -= 1;  // Have one less
                    l += 1;
                } else
                    break;
            }
            // Right Pointer always moves forward
            r += 1;
        }

        if (solR > s.length()) return "";
        return s.substring(solL,solR+1);
    }
}

// 2 Lessons learnt:
// 1. In sliding window questions, always increment the r pointer, use r as a for r in xyz
// 2. Always increase the left pointer only AFTER you've done the operation on the left elements
// Otherwise if you increment it first, you will do it to the next element, and miss the current left.

// Otherwise good shit. This was a really hard problem that's now done, starting tomorrow, we will be on to
// much easier problems. (8 more easy/meds before our next hard.)
