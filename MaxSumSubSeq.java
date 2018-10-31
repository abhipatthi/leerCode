/*
	Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. 
	Numbers can be 0 or negative.
	Example:
		[2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. 
		[5, 1, 1, 5] should return 10, since we pick 5 and 5.
*/

class MaxSumSubSeq{

	static int maxSumSubseq(int[] input){
		int n = input.length;
		
		int pre = Integer.max(input[0], input[1]);
		int pre_pre = input[0];
		
		for(int index=2; index < n; index++){
			int curr = Integer.max(input[index], Integer.max(pre, pre_pre+input[index]));
			pre_pre = pre;
			pre = curr;
		}

		return pre;
	}


	public static void main(String[] args){

		int[] input = {2,3,1,5};
		System.out.println(maxSumSubseq(input));

	}
}