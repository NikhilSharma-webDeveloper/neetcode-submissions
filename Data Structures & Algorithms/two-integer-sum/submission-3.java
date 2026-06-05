class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Calculate initial capacity to prevent resizing overhead
        // capacity = length / load_factor + 1
        int initialCapacity = (int) (nums.length / 0.75f) + 1;
        HashMap<Integer, Integer> temp = new HashMap<>(initialCapacity);

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int complement = target - num;

            // ContainsKey + Get can be optimized, but containsKey is fast.
            if (temp.containsKey(complement)) {
                return new int[] { temp.get(complement), i };
            }
            
            temp.put(num, i);
        }

        return new int[] { -1, -1 };
    }
}