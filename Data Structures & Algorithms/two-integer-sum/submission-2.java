class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> temp = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int newTarget = target - nums[i];

            if(temp.containsKey(newTarget)){
                return new int[]{temp.get(newTarget),i};
            }else{
                temp.put(nums[i], i);
            }
        }

        return new int[]{-1,-1};
    }
}
