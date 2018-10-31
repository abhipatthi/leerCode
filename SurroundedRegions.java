class SurroundedRegions {
    static void solve(char[][] board) {

        int noOfRows = board.length;
        int noOfCols = 0;
        if(noOfRows > 0){
            noOfCols = board[0].length;
        }
        if(noOfCols < 0){
            return;
        }
        
        boolean flip = true;
        for(int rowIndex=0; rowIndex<noOfRows; rowIndex++){
            for(int colIndex=0; colIndex < noOfCols; colIndex++){
                if(board[rowIndex][colIndex] == 'O'){
                    if(isOnBorder(rowIndex, colIndex, board)){
                        flip = false;
                    }else if(hasAdjacentO(rowIndex, colIndex, board)){
                        flip = false;
                    }else{
                        flip = true;
                    }
                    
                    if(flip){
                        board[rowIndex][colIndex] = 'X';
                    }
                }
            }
        }

        printOutput(board);
    }
    
    
    static boolean isOnBorder(int rowIndex, int colIndex, char[][] board){
        int noOfRows = board.length;
        int noOfCols = board[0].length;
        boolean onBorder = false;
        if(rowIndex == 0){
            onBorder = true;
            return onBorder;
        }
        if(rowIndex == (noOfRows-1)){
            onBorder = true;
            return onBorder;
        }
        if(colIndex == 0){
            onBorder = true;
            return onBorder;
        }
        if(colIndex == (noOfCols -1)){
            onBorder = true;
            return onBorder;
        }
        
        return false;     
    }
    
    
    static boolean hasAdjacentO(int rowIndex, int colIndex, char[][] board){
        boolean adjacentO = false;
        //top
        if(board[rowIndex-1][colIndex] == 'O'){
            adjacentO = isOnBorder(rowIndex-1, colIndex, board);
            if(adjacentO){
              return adjacentO;  
            }
            //
        }
        //bottom
        if(board[rowIndex+1][colIndex] == 'O'){
            adjacentO = isOnBorder(rowIndex+1, colIndex, board);
            if(adjacentO){
              return adjacentO;  
            }
        }
        //left
        if(board[rowIndex][colIndex-1] == 'O'){
            adjacentO = isOnBorder(rowIndex, colIndex-1, board);
            if(adjacentO){
              return adjacentO;  
            }
        }
        //right
        if(board[rowIndex][colIndex+1] == 'O'){
            adjacentO = isOnBorder(rowIndex, colIndex+1, board);
            if(adjacentO){
              return adjacentO;  
            }
        }
        
        return adjacentO;
    }

    static void printOutput(char[][] board){
        for(int rowIndex=0; rowIndex< board.length; rowIndex++){
            for (int colIndex=0; colIndex < board[0].length; colIndex++) {
                System.out.print(board[rowIndex][colIndex]+" ");
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args){
        char[][] board = {
                            {'O','X','X','O','X'},
                            {'X','O','O','X','O'},
                            {'X','O','X','O','X'},
                            {'O','X','O','O','O'},
                            {'X','X','O','X','O'}
                        };

        solve(board);

    }
}