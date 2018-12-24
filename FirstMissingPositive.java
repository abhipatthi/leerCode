/*Problem Description:
	Given an array of integers, find the first missing positive integer in linear time and constant space. 
	In other words, find the lowest positive integer that does not exist in the array. The array can contain 
	duplicates and negative numbers as well.

	For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.

*/

class FirstMissingPositive{
	
	public static void main(String[] args){

		int[] inputArray = {2,3,7,6,8,-1,-10,15};
		//int[] inputArray = {1,2,3,6,8,1,2};
		for(int index = 0; index < inputArray.length; index++){
			while(inputArray[index] != index + 1){

				//do not swap if the value is out of range

				if(inputArray[index] <= 0 || inputArray[index] >= inputArray.length){
					break;
				}

				//check for duplicate
				if(inputArray[index] == inputArray[inputArray[index] - 1]){
					break;
				}

				int temp = inputArray[index];
				inputArray[index] = inputArray[temp-1];
				inputArray[temp - 1] = temp;
			}
		}

		int smallestMissingNumber = 0;

		for(int index = 0; index < inputArray.length; index++){
			if(inputArray[index] != index + 1){
				smallestMissingNumber = index + 1;
				break;
			}
		}

		System.out.println(smallestMissingNumber);
	}	
}

