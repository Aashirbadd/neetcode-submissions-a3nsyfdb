class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int n = words.length;
        int[] prefix = new int[n+1];

        for (int i = 0; i < n; i++) {
            String w = words[i];
            boolean valid = vowels.contains(w.charAt(0)) && vowels.contains(w.charAt(w.length() - 1));
            prefix[i+1] = prefix[i] + (valid ? 1 : 0);
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            ans[i] = prefix[r+1] - prefix[l];
        }

        return ans;
    }
}