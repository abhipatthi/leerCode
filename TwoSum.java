import java.util.HashMap;

public class Solution 
{
    public int[] twoSum(int[] nums,int target) 
    {
        // Create a HashMap to store numbers and their indices
        HashMap<Integer, Integer> map = new HashMap<>();    
        // Iterate through the array
        for (int i=0;i<nums.length;i++) 
        {
            int complement = target-nums[i];
            // Check if the complement exists in the map
            if (map.containsKey(complement)) 
            {
                // Return the indices of the two numbers
                return new int[] {map.get(complement),i};
            } 
            // If not, add the current number and its index to the map
            map.put(nums[i],i);
        }
        // If no solution is found,return an empty array
        throw new IllegalArgumentException("No two sum solution");
    }
}
