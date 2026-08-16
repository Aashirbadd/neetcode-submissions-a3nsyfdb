class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Group elements that are anagrams into sublists, and return the 2d array.
        // Order? Any order can be returned:
        // Visualise?
        // Input: strs = ["act","pots","tops","cat","stop","hat"]
        // Map = {act:"act", cat, opst: {"pots", "tops"}, }
        // Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]

        // Way to do it:
        // First -> Sort it into lexographical order (key) -> And put it in the value as such...

        HashMap<String, List<String>> anagramMap = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            // Put string S into the list of values with key "sorted"
            anagramMap.computeIfAbsent(sorted, k -> new ArrayList<String>()).add(s);
        }

        return new ArrayList<>(anagramMap.values());
    }
}
