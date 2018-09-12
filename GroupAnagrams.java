class GroupAnagrams {
    public List<List<String>> anagrams(String[] strs) {
        
        if(strs.length == 0) {
            return new ArrayList();
        }
        
        //create a map where key is the sorted string and value is the list of string
        Map<String, List> map = new HashMap<String, List>();
        
        for(String str : strs) {
            //convert the str to character of array
            char[] ch = str.toCharArray();
            //sort the array
            Arrays.sort(ch);

            //convert the character array to a string and assign the sorted character string as a key
            String key = String.valueOf(ch);
            
            //if key is not present, add the key n value into the map
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }
            
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }
}