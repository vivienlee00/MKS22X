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
    public boolean solve() //change to void later
    {
	return solveH(0);
    }

    private boolean solveH(int col){

	System.out.println(toString());
	if(numQueens == boardSize){    
	    return true;
	}
	if(col > board.length || col == 3){
	    return false;
	}

	for(int row = 0; row < board.length; row++){
	    if(addQueen(row,col)){
		return solveH(col++);
	    }
	}
	return false;
    }

    private boolean addQueen(int r, int c){
	if(board[r][c] == 0){
	board[r][c] = -1;
	numQueens += 1;



	for(int col = 0; col < board[0].length; col++){
	    if (col != c){
		board[r][col] += 1;
	    }
	}

	for(int row = 0; row < board.length; row++){
	    if (row != r){
		board[row][c] += 1;
	    }
	}
	//fix this part ageuhiauh WHY DOESNT THIS WORK?????

	int row = r;
	int col = c;
	while(row < board.length && col < board[0].length){
	    if (row != r && col != c){
		board[row][col] += 1;
		row+=1;
		col+=1;
	    }
	}
	System.out.println(toString());
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
	    if (col != c){
		board[r][col] -= 1;
	    }
	}

	for(int row = 0; row < board.length; row++){
	    if (row != r){
		board[row][c] -= 1;
	    }
	}


	int row = r;
	int col = c;
	while(row < board.length && col < board[0].length){
	    if (row != r && col != c){
		board[row][col] -= 1;
		row++;
		col++;
	    }
	}
	

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


    public static void main(String[] args){
	QueenBoard J = new QueenBoard(4);
	System.out.println(J.solve());
    }
}
