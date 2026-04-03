class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // First create a map {sum:indices[][]}
        HashMap<Integer,List<Integer[]>> map = new HashMap();
        // Fill the map O(n^2)
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++){
                int sum = nums[i] + nums[j];
                List<Integer[]> indexList = map.getOrDefault(sum, new ArrayList<Integer[]>());
                indexList.add(new Integer[]{i, j});
                // System.out.println("Sum: " + sum + " IndexList: " + indexList.toString());
                map.put(sum, indexList);
            }
        }
        // Generate Triplets in sorted order in a set 
        HashSet<List<Integer>> set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            int compliment = -1 * nums[i];
            if (map.containsKey(compliment)){
                List<Integer[]> jkList = map.get(compliment);
                for (int index = 0; index < jkList.size(); index++){
                    Integer[] jkIndices = jkList.get(index);
                    int j = jkIndices[0];
                    int k = jkIndices[1];

                    if (i != j && i != k){
                        List<Integer> triplet = new ArrayList(List.of(nums[i],nums[j],nums[k]));
                        triplet.sort((a,b) -> a.compareTo(b));
                        set.add(triplet);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
}


// Given an int[] nums
// Return ALL triplets (indices of nums) which sum to 0, i,j,k should all be distinct.

// Indices:        0 1 2 3  4  5
// Input: nums = [-1,0,1,2,-1,-4]
//                 i
//                 
// -1,0,1 --> Sort it (for the same triplet edgecase) and store into a set

// map: {sum:indices} {-1:[[0,1],[1,4]], 0:[0,2], 1:[[0,3],[1,2]], -2:[0,4], -5:[0,5]} 
// Output: [[-1,0,1], [-1,-1,2]]

// Time: n * n-1 * n-2 = O(n^3)
// Storage: O(1)

// Prob: How to enforce distinct triplets? --> Store them in a set in sorted order.
// Output: [[-1,-1,2],[-1,0,1]]
