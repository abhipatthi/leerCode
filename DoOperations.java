import java.io.*; 

class DoOperations{

	static long arrayManipulation(int n, int[][] queries) {
		int[] outputArray = new int[n];
		long maxValue = 0;
		int noOfRows = queries.length;
		int noOfCols = queries[0].length;

		for(int rowIndex=0; rowIndex<noOfRows; rowIndex++){
				maxValue = Math.max(maxValue, dooperation(queries[rowIndex][0], queries[rowIndex][1], queries[rowIndex][2], outputArray));
				printArray(outputArray);
		}

		return maxValue;

    }


    static void printArray(int[] array){
    	for(int index=0; index<array.length; index++){
    		System.out.print(array[index]+" ");
    	}
    	System.out.println("");
    }

    static int dooperation(int leftIndex, int rightIndex, int valueToAdd, int[] outputArray){
    	int max = 0;
    	for(int index=leftIndex-1; index<rightIndex; index++){
    		outputArray[index] += valueToAdd;
    		max = Math.max(max,outputArray[index]);
    	}

    	return max;
    }

	public static void main(String args[]){
		int[][] queries = {
							{1, 2, 100},
							{2, 5, 100},
							{3, 4, 100}
						  };

		long output = arrayManipulation(5,queries);
		System.out.println(output);
	}
}