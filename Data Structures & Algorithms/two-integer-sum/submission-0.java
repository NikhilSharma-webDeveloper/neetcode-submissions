class Solution {
    public int[] twoSum(int[] nums, int target) {
        Hashtable<Integer, Integer> data=new Hashtable<>();

        for(int i=0;i<nums.length;i++){

            int newTarget=target-nums[i];

            if(data.containsKey(newTarget)){
                return new int[]{data.get(newTarget),i};
            }else if(data.containsKey(nums[i])){
                continue;
            }else{
                data.put(nums[i],i);
            }
        }

        return new int[]{};
    }
}
