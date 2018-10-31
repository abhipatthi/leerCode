import java.io.*; 
import java.util.HashSet; 

class PairSum {
	
	static void findPair(int[] inputArray, int sumToFind) {

		HashSet<Integer> mySet = new HashSet<Integer>();

		for(int index=0; index < inputArray.length; index++){
			int difference = sumToFind - inputArray[index];

			if(mySet.contains(difference)){
				System.out.println(inputArray[index] + ","+ difference);
			}

			mySet.add(inputArray[index]);
		}
	}

	public static void main(String args[]){

		int[] inputArray = {10,15,3,7,25};
		int sum = 13;

		findPair(inputArray, sum);
	}
}