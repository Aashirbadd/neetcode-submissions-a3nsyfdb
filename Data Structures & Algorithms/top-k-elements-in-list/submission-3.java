class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // First generate frequency map with {number:frequency}
        HashMap<Integer, Integer> frequency = new HashMap();
        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        for (int i = 0; i <= nums.length; i++){
            bucket[i] = new ArrayList<Integer>();
        }

        for (int num: nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        // frequency: [values, , , ...]
        for (Integer key: frequency.keySet()) {
            bucket[frequency.get(key)].add(key);
        }

        int index = 0;
        int[] output = new int[k];
        for (int i = nums.length; i > 0 && index <k; i--) {
            for (int num: bucket[i]){
                output[index++] = num;
                if (index >= k)
                    return output;
            }
        }

        // Just grab the top k values from frequency
        // Convert to ArrayList, sort, return the top k

        return output;
    }
}


// Input: int[] nums = [1,2,2,3,3,3], int k = 2
//                                
// frequency = {1:1, 2:2, 3:3}
// [3,2]
// int[] Output: [2,3]
