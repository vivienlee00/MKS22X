public class KnightBoard{

    private int[][]board;
    private int boardArea;

    public KnightBoard(int startingRows,int startingCols){
	board = new int[startingRows][startingCols];
	boardArea = startingRows * startingCols;
	clearBoard();
    }

    public String toString(){ //blank if you never called solve or when there is no solution
	String str = "1 [";
	
	for (int i = 0; i < board.length; i++) {
	    
	    for (int j = 0; j < board[i].length; j++) {
		if(board[i][j] < 10){
		    str+= " " + board[i][j];
		}
		else{
		str += board[i][j];
		}
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

    public void solve() {
	return solveH(0,0,1);
    }

    private boolean solveH(int row ,int col, int level){ // level is the # of the knight

	//try
	board[row][col] = level;
	//catch indexOutOfBounds

	if (level == boardArea){
	    return true;
	}
	
	//if (no possible spaces) { return false;}
	/*	
		return (
		solveH(row-2,col-1,level+1) ||
		solveH(row-2,col+1,level+1) ||
		solveH(row-1,col+2,level+1) ||
		solveH(row+1,col+2,level+1) ||
		solveH(row+2,col+1,level+1) ||
		solveH(row+2,col-1,level+1) ||
		solveH(row+1,col-2,level+1) ||
		solveH(row-1,col-2,level+1)
		)
	*/
    }

    
    public void clearBoard(){
	for (int i = 0; i < board.length; i++) {
	    
	    for (int j = 0; j < board[i].length; j++) {
		board[i][j] = 0;
	    }
	}
    }

}
