class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> temp = new HashSet<>();

        for(int n: nums){
            if(!temp.add(n))
                return true;
        }
        return false;
    }
}