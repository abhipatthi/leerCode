import java.io.*; 
import java.util.HashSet; 

class Minesweeper {


	static int[][] rule1(int rowIndex, int colIndex, int[][]inputArray) {

		int noOfAdjacentMines = adjacentToMine(rowIndex, colIndex, inputArray);
		if(noOfAdjacentMines > 0){
			inputArray[rowIndex][colIndex] = noOfAdjacentMines;
		}	
		
		return inputArray;
	}

	static int[][] rule2(int rowIndex, int colIndex, int[][] inputArray){
		
		if(rowIndex>0 && inputArray[rowIndex-1][colIndex] == -1){
			inputArray[rowIndex][colIndex] = 2;
		}
		return inputArray;
	}

	static int[][] rule3(int rowIndex, int colIndex, int[][] inputArray){
		if(colIndex>0 && inputArray[rowIndex][colIndex-1] == -1){
			inputArray[rowIndex][colIndex] = 0;
		}
		return inputArray;
	}

	static int[][] rule4(int rowIndex, int colIndex, int[][] inputArray){
		
		if(hasMinesInRow(rowIndex, inputArray)){
			inputArray[rowIndex][colIndex] = inputArray[rowIndex][colIndex] * 3;
		}

		return inputArray;
	}

	static int[][] rule5(int rowIndex, int colIndex, int[][] inputArray){
		
		

		return inputArray;
	}

	static boolean hasConter(int rowIndex, int colIndex, int[][] inputArray){
		int rows = inputArray.length;
		int cols = inputArray[0].length;
		//top left corner
		if(rowIndex > 0 && colIndex > 0 && inputArray[rowIndex-1][colIndex-1] == -1){
			return true;
		}
		//top right corner
		if(rowIndex > 0 && colIndex < (cols-1) && inputArray[rowIndex-1][colIndex+1] == -1){
			return true;
		}

		//botton left corner
		if(rowIndex < (rows-1) && colIndex > 0 && inputArray[rowIndex+1][colIndex-1] == -1){
			return true;
		}
		//bottom right corner
		if(rowIndex < (rows-1)&& colIndex < (cols-1) && inputArray[rowIndex+1][colIndex+1] == -1){
			return true;
		}

		return false;

	}


	static boolean hasMinesInRow(int rowIndex, int[][] inputArray){
		for(int colIndex=0; colIndex < inputArray[0].length; colIndex++){
			if(inputArray[rowIndex][colIndex] == -1){
				return true;
			}
		}
		return false;
	}
	

	static int adjacentToMine(int rowIndex, int colIndex, int[][]inputArray) {

		int rows = inputArray.length;
		int cols = inputArray[0].length;
		int noOfAdjacentMines = 0;
		//left
		if(colIndex > 0 && inputArray[rowIndex][colIndex-1] == -1){
			noOfAdjacentMines += 1;
		}
		//right
		if(colIndex < (cols-1) && inputArray[rowIndex][colIndex+1] == -1){
			noOfAdjacentMines += 1;
		}
		//top
		if(rowIndex > 0 && inputArray[rowIndex - 1][colIndex] == -1){
			noOfAdjacentMines += 1;
		}
		//below
		if(rowIndex < (rows - 1) && inputArray[rowIndex + 1][colIndex] == -1){
			noOfAdjacentMines += 1;
		}
		//top left
		if(rowIndex >0 && colIndex >0 && inputArray[rowIndex - 1][colIndex - 1] == -1){
			noOfAdjacentMines += 1;
		}
		//bottom left
		if(rowIndex <(rows-1) && colIndex > 0 && inputArray[rowIndex + 1][colIndex - 1] == -1){
			noOfAdjacentMines += 1;
		}	
		//top right
		if(rowIndex >0 && colIndex < (cols-1) && inputArray[rowIndex - 1][colIndex + 1] == -1){
			noOfAdjacentMines += 1;
		}
		//bottom right
		if(rowIndex <(rows-1) && colIndex <(cols-1) && inputArray[rowIndex + 1][colIndex + 1] == -1){
			noOfAdjacentMines += 1;
		}				

		return noOfAdjacentMines;

	}

	static public void printArray(int[][] inputArray){

		int noOfRows = inputArray.length;
		int noOfCols = inputArray[0].length;
		for(int rowIndex=0; rowIndex < noOfRows; rowIndex++){
			for(int colIndex=0; colIndex < noOfCols; colIndex++){
				System.out.print(inputArray[rowIndex][colIndex]+" ");
			}
			System.out.println("\n");
		}

	}

	static int[][] minesweeper(int[][] inputArray){

		for(int rowIndex=0; rowIndex < inputArray.length; rowIndex++){
			for(int colIndex=0; colIndex < inputArray[0].length; colIndex++){
				if(inputArray[rowIndex][colIndex] != -1){
					rule1(rowIndex, colIndex, inputArray);
					rule2(rowIndex, colIndex, inputArray);
					rule3(rowIndex, colIndex, inputArray);
					if(rowIndex%2 == 1){
						rule4(rowIndex, colIndex, inputArray);
					}
					rule5(rowIndex,colIndex, inputArray);
				}
			}
		}

		return inputArray;

	}

	public static void main(String[] args){
		int[][] inputArray = {
								{0,-1,0,0},
								{0,0,0,0},
								{0,0,0,-1},
								{-1,0,0,0}
							 };
		minesweeper(inputArray);
		printArray(inputArray);
	}
}