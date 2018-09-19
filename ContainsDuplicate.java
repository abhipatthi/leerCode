class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int n : nums) {
            if(!set.add(n)) return true;
        }
        
        return false;
    }
}