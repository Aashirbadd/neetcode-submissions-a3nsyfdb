class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Put into hashmap keyed by sorted form...
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] characters = s.toCharArray();
            Arrays.sort(characters);
            String sorted = new String(characters);

            map.computeIfAbsent(sorted, k -> new ArrayList()).add(s);
        }


        return new ArrayList(map.values());
    }
}

// Input: strs = ["act","pots","tops","cat","stop","hat"]
// Key: Sorted form, value ArrayList of values...
// Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]
