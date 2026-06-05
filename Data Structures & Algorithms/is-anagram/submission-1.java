class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> data = new HashMap<>();

        if(s.length() != t.length()){
            return false;
        }

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(data.containsKey(c)){
                data.put(c, data.get(c)+1);
            }else{
                data.put(c,1);
            }
        }

        for(int i=0; i<t.length(); i++){
            char c = t.charAt(i);
            if(data.containsKey(c)){
                data.put(c, data.get(c)-1);
                if(data.get(c)==0){
                    data.remove(c);
                }
            }
        }

        return data.size()==0? true:false; 

    }
}
