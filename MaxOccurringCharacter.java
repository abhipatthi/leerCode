import java.util.*;


/*Problem Description
    Given a string, return the character that appears the maximum number of times in the string. 
    The string will contain only ASCH characters .If there is a tie in the maximum number of times
    a character appears in the string, return the character that appears first in the string. 
    For example, given the string text= abbaacc both 'a' and 'c' occurs 3 times in text. Since 'a'
    occur earlier in the  the answer is 'a'
*/

public class MaxOccurringCharacter{
    public static void main(String args[]){
        String input = "aaaaabcccdddeeeeefffff";
        HashMap<Character, Integer> charCount = new HashMap<>();
        for(Character c: input.toCharArray()){
            if(charCount.containsKey(c)){
                charCount.put(c, charCount.get(c)+1);
            }else {
                charCount.put(c,1);
            }
        }
        
        char winner = 0;
        int maxVal = Integer.MIN_VALUE;
        for(Map.Entry<Character, Integer> entry : charCount.entrySet()){
            
            if(entry.getValue() > maxVal){
                maxVal= entry.getValue();
                winner = entry.getKey();
            }
            
            else if(entry.getValue() == maxVal && winner>entry.getKey()){
                winner = entry.getKey();
            }
        }
        
        System.out.println(winner);
        
    }
}