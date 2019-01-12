/*Problem

This problem was asked by Uber.

Given an array of integers, return a new array such that each element at index i of the new array is the product of 
all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. 
If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can’t use division?
*/

import java.util.Arrays;

public class ProductArrayPuzzle{

    static int[] findProductArray(int[] inputArray){
        
        int countZero = 0;
        int result = 1;
        for(int number : inputArray){
            if(number == 0){
                countZero++;
                continue;
            }
            
            result *= number;
        }
        
        if(countZero > 1){
            Arrays.fill(inputArray, 0);
            return inputArray;
        }
        
        for(int index = 0; index < inputArray.length; index++){
            if(inputArray[index] == 0){
                inputArray[index] = result;
                continue;
            }
            
            if(countZero == 1){
                inputArray[index] = 0;
                continue;
            }
            
            inputArray[index] = result / inputArray[index]; 
        }
        return inputArray;
        
    }
     public static void main(String []args){
        int[] inputArray = {1,2,0,4,0};
        
        findProductArray(inputArray);
        for(int number  : inputArray){
            System.out.print(number+", ");
        }
     }
}