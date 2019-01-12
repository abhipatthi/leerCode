/*Problem: Given an array of integers, find the first missing positive integer in linear time and constant space.
In other words, find the lowest positive integer that does not exist in the array.
The array can contain duplicates and negative numbers as well.

For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
You can modify the input array in-place.
*/

public class FirstMissingPositiveNumber{

    static int missingPositive(int[] inputArray){
        
        for(int index = 0; index < inputArray.length; index++){
            while(inputArray[index] != index + 1){
                if(inputArray[index] <= 0 || inputArray[index] >= inputArray.length){
                    break;
                }
                
                if(inputArray[index] == inputArray[inputArray[index] - 1]){
                    break;
                }
                
                int temp = inputArray[index];
                inputArray[index] = inputArray[temp -1];
                inputArray[temp -1] = temp;
            }
           
        }
        
        for(int index =0; index < inputArray.length; index++){
            if(inputArray[index] != index + 1){
                return index + 1;
            }
        }
        
        return 0;
    }

    public static void main(String []args){    
        
        int[] inputArray = {3,4,-1,1};
        System.out.println(missingPositive(inputArray));
     }
}