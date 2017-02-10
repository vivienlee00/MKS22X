public class QueenBoard{

    private int[][]board;

    private int solutionCount;

    private int numQueens;
    private int boardSize;

    

    public QueenBoard(int size){
	board = new int[size][size];
	boardSize = size;
	solutionCount = 0;
	numQueens = 0;
    }

    /**
     *precondition: board is filled with 0's only.
     *@return false when the board is not solveable. true otherwise.
     *postcondition: 
     *if false: board is still filled with 0's
     *if true: board is filled with the 
     *final configuration of the board after adding 
     *all n queens. Uses solveH
     */
    public boolean solve()
    {
	return solveH(0);
    }

    private boolean solveH(int col){
	if(numQueens == boardSize){    
	    return true;
	}

	for(int row = 0; row < board.length; row++){
	    if(addQueen(row,col)){
		return solveH(col++);
	    }
	}
	return false;
    }

    private boolean addQueen(r,c){
	if(board[r][c] == 0){
	board[r][c] = -1;
	numQueens += 1;

	for(int col = 0; col < board[r].length; col++){
	    if (col != c){
		board[r][col] += 1;
	    }
	}

	for(int row = 0; row < board.length; row++){
	    if (row != r){
		board[row][c] += 1;
	    }
	}

	for(int row = 0; int col = 0; row < board.length; col < board[r].length; row++; col++){
	    if (row != r && col != c){
		board[row][col] += 1;
	    }
	}
	
	return true;
	}
	else{
	    return false;
	}
    }

    private boolean removeQueen(r,c){
	if(board[r][c] == -1){
	board[r][c] = 0;

	numQueens -= 1;
	for(int col = 0; col < board[r].length; col++){
	    if (col != c){
		board[r][col] -= 1;
	    }
	}

	for(int row = 0; row < board.length; row++){
	    if (row != r){
		board[row][c] -= 1;
	    }
	}

	for(int row = 0; int col = 0; row < board.length; col < board[r].length; row++; col++){
	    if (row != r && col != c){
		board[row][col] -= 1;
	    }
	}

	return true;
	}
	else{
	    return false;
	}
    }

    /**
     *@return the number of solutions found, or -1 if the board was never solved.

     *The board should be reset after this is run.    

     */

    public int getSolutionCount(){
    	return -1;
    }

    /**toString
     *and all nunbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     */
    public String toString(){
    	return "";
    }
}
