class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap();

        for (String s: strs){
            // Get its sorted form, have it as a key, and put its original value as value
            char[] sArray = s.toCharArray();
            Arrays.sort(sArray);
            String sSorted = new String(sArray);    // Key
            String key = sSorted;
            List<String> value = map.getOrDefault(key, new ArrayList<String>());
            value.add(s);

            map.put(key, value);
            // map.put(sSorted, map.getOrDefault(sSorted, new ArrayList<String>()).add(s));
        }

        return new ArrayList(map.values());
        
    }
}


// input: String[] strs = ["act","pots","tops","cat","stop","hat"]
// Group anagrams together into sublists, return outputs in any order.

// Input: strs = ["act","pots","tops","cat","stop","hat"]
//                                                   ^
// Process: {act: [act, cat], opst: [pots, tops, stop], aht: [hat]}}
// Process: {sortedValue: [vals]}

// Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]

// Anagram --> Same characters (possibly in different order)
// Sorted --> They are the same! (Unique)
    // Two different anagrams sorted are equal
    // Impossible for two different sorted strings to be anagrams
    // Good Key --> Sorted Form