class Solution {
    
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Integer, ArrayList<String>> data = new HashMap<>();

        // this part is O(n)
        for(int i=0; i<strs.length; i++){
            int length = strs[i].length();

            if(data.containsKey(length)){
                data.get(length).add(strs[i]);
            }else{
                ArrayList<String> out = new ArrayList<>();
                out.add(strs[i]);
                data.put(length, out);
            }
        }

        List<List<String>> result = new ArrayList<>();

        data.forEach((key, value) -> {
           ArrayList<String> temp = value;
           boolean[] same = new boolean[temp.size()];
          
           for(int i=0; i<temp.size(); i++){
                if(same[i]){
                    continue;
                }
                List<String> tempResult = new ArrayList();
                tempResult.add(temp.get(i));

                for(int j=i+1; j<temp.size(); j++){
                    if(same[j]){
                        continue;
                    }

                    if(isSame(temp.get(i), temp.get(j))){
                        tempResult.add(temp.get(j));
                        same[j] = true;
                    }
                }

            result.add(tempResult);
           }

        });
        return result;
    }

    private boolean isSame(String first, String second){
        HashMap<Character, Integer> f = stringToMap(first);
        HashMap<Character, Integer> s = stringToMap(second);

        for (Map.Entry<Character, Integer> entry : f.entrySet()) {
            if (!s.containsKey(entry.getKey()) || !s.get(entry.getKey()).equals(entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    private HashMap<Character, Integer> stringToMap(String first){
        HashMap<Character, Integer> map = new HashMap(first.length());

        for(int i=0; i< first.length(); i++){
            char c = first.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else{
                map.put(c, 1);
            }
        }

        return map;
    }

}
