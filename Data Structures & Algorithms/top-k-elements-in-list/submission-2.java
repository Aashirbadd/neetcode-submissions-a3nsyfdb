class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // First generate frequency map with {number:frequency}
        HashMap<Integer, Integer> frequency = new HashMap();

        for (int num: nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        // Just grab the top k values from frequency
        // Convert to ArrayList, sort, return the top k
        List<Integer> sortedKeys = new ArrayList(frequency.keySet());
        sortedKeys.sort((a,b) -> frequency.get(b).compareTo(frequency.get(a)));
        // Descending order (highest numbers first)

        // now we want to put only the top k elements in the output array, and return them!
        int[] output = new int[k];
        for (int i = 0; i < k; i++){
            output[i] = sortedKeys.get(i);
        }

        return output;
    }
}


// Input: int[] nums = [1,2,2,3,3,3], int k = 2
//                                
// frequency = {1:1, 2:2, 3:3}
// [3,2]
// int[] Output: [2,3]
