class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // first step we are checking which element appear how many times
        HashMap<Integer, Integer> data = new HashMap<>();

        for(int i=0;i< nums.length;i++){
           if(data.containsKey(nums[i])){
            data.put(nums[i], data.get(nums[i])+1);
           }else{
            data.put(nums[i], 1);
           }
        }

        // now we are creating buckets could have used 
        // priority Queue too but not as it will jump our
        // TC O(n log n)
        List<Integer>[] buckets = new List[nums.length+1];

        data.forEach((key, value)->{
            if(buckets[value]== null){
                buckets[value] = new ArrayList<>();
            }

            buckets[value].add(key);
        });

       // now just going reverse and picking up the elements

       int[] result = new int[k];
       int counter = 0;

       for(int i=nums.length; i>=0; i--){
            if(buckets[i]!=null){
                for (int num : buckets[i]) {
                    result[counter++] = num;
                    if (counter == k) {
                        return result;
                    }
                }
            }
       }

        return result;
    }
}
