class FirstMissingPositive{
	
	static int firstMissingPositive(int[] inputArray){
		int arrayLength = inputArray.length;
		int val;
		int nextVal;
		for(int index=0; index<arrayLength; index++){
			val = inputArray[index];

			if(inputArray[index] <= 0 || inputArray[index] > arrayLength){
				continue;
			}

			while(inputArray[val-1] != val){
				nextVal = inputArray[val-1];
				inputArray[val-1] = val;
				val = nextVal;
				if(val<=0 || val > arrayLength){
					break;
				}
			}
		}


		for(int index=0; index<arrayLength; index++){
			if(inputArray[index] != index+1){
				return index+1;
			}
		}

		return arrayLength+1;
	}

	public static void main(String[] args){

		int[] inputArray = {2,3,7,6,8,-1,-10,15};
		System.out.println(firstMissingPositive(inputArray));
	}	
}

