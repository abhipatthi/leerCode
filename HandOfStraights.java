class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int W) {
        
        if(hand.length % W != 0){
            return false;
        }
    TreeMap<Integer,Integer> map =new TreeMap();
        
        for(int card : hand) {
            if(!map.containsKey(card)){
                map.put(card,1);
            }
            else{
                map.put(card,map.get(card)+1);
            }
        }
        
        
        while(map.size() > 0) {
			//firstKey will return the smalled key in the map
            int firstCard = map.firstKey();
            for(int card = firstCard; card<firstCard+W; card++) {
                if(!map.containsKey(card)) {
                    return false;
                }
                if(map.get(card) == 1) {
                   map.remove(card);
                }else{
                    map.put(card,map.get(card)-1);    
                }
                
            }
        }
        
        return true;
    }  
}