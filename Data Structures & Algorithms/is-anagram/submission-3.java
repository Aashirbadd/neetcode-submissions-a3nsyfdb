class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> sMap = new HashMap();
        HashMap<Character, Integer> tMap = new HashMap();

        // Fill sMap
        for (int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }
        // Fill tMap
        for (int i = 0; i < t.length(); i++){
            Character c = t.charAt(i);
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        if(sMap.equals(tMap))
            return true;
        else
            return false;
    }
}

// If S&T are anagrams, return true
// Else, return false

// Anagram --> Contains the same characters (possibly in different order)
// To be an anagram they just need to contain the same characters.

// Input: s = "racecar", t = "carrace"
//                                  ^
// Output: true
// charsInS = {r:2, a:2, c:2, e:1,}
// charsInT = {c:2, a:2, r:2, e:1 }
// 
// Time  = O(s+t)
// Space = O(1)