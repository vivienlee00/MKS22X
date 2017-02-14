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
	clearBoard();
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
    public void solve()
    {
	this.solveH(0);
    }

    private boolean solveH(int col){

	
	if(numQueens == boardSize){
	    System.out.println(toString());
	    return true;
	}
	
	
	if(col >= board.length){
	    return false;
	}

	for(int row = 0; row < board.length; row++){
	    if(addQueen(row,col)){
		solveH(col+1);
		removeQueen(row,col);
	    }
	}
	
	return false;
    }

    private boolean addQueen(int r, int c){
	if(board[r][c] == 0){
	numQueens += 1;



	for(int col = 0; col < board[0].length; col++){
		board[r][col] += 1;
	}

	for(int row = 0; row < board.length; row++){
		board[row][c] += 1;
	}

	for(int row = r,     col = c; row < board.length && col < board.length; row++, col++){
		board[row][col] += 1;
	}

	for(int row = r,     col = c; row > -1 && col > -1; row--, col--){
	    board[row][col] += 1;
	}

	for(int row = r,     col = c; row > -1 && col < board.length; row--, col++){
	    board[row][col] += 1;
	}

	for(int row = r,     col = c; col > -1 && row < board.length; row++, col--){
	    board[row][col] += 1;
	}

	board[r][c] = -1;
	return true;
	}
	else{
	    return false;
	}
    }

    private boolean removeQueen(int r, int c){
	if(board[r][c] == -1){
	board[r][c] = 0;

	numQueens -= 1;
	for(int col = 0; col < board[0].length; col++){
		board[r][col] -= 1;
	    
	}

	for(int row = 0; row < board.length; row++){
		board[row][c] -= 1;
	    
	}

	for(int row = r,     col = c; row < board.length && col < board.length; row++, col++){
		board[row][col] -= 1;
	}

	for(int row = r,     col = c; row > -1 && col > -1; row--, col--){
	    board[row][col] -= 1;
	}

	for(int row = r,     col = c; row > -1 && col < board.length; row--, col++){
	    board[row][col] -= 1;
	}

	for(int row = r,     col = c; col > -1 && row < board.length; row++, col--){
	    board[row][col] -= 1;
	}

	board[r][c] = 0;

	return true;
	}
	else{
	    return false;
	}
    }


    public void countSolutions(){
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
    	String str = "1 [";
	
	for (int i = 0; i < board.length; i++) {
	    
	    for (int j = 0; j < board[i].length; j++) {
		str += board[i][j];
		str += "| ";
	    }
	    
	    str += "\b" + "\b" + "]";
	    str += "\n";

	    if (i < board.length - 1) {

		if(i < 8){
	      	str += (i + 2) + " [";
		}
		else{
		    str += (i + 2) + "[";
		}
	    }
	}

	return str;
    }

    public void clearBoard(){
	for (int i = 0; i < board.length; i++) {
	    
	    for (int j = 0; j < board[i].length; j++) {
		board[i][j] = 0;
	    }
	}
    }

    public static void main(String[] args){
	QueenBoard J = new QueenBoard(4);
	J.solve();
	System.out.println(J);
    }
}
