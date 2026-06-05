class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> temp = new HashSet<>();

        for(int n: nums){
            if(temp.contains(n)){
                return true;
            }else{
                temp.add(n);
            }
        }
        return false;
    }
}