public class KnightBoard{

    private int[][]board;
    private int boardArea;

    public KnightBoard(int startingRows,int startingCols){
	board = new int[startingRows][startingCols];
	boardArea = startingRows * startingCols;
	clearBoard();
    }

    public String toString(){ //blank if you never called solve or when there is no solution
	String str = "";
	
	for (int i = 0; i < board.length; i++) {
	    
	    for (int j = 0; j < board[i].length; j++) {
		if(board[i][j] < 10){
		    str+= " " + board[i][j] + " ";
		}
		else{
		str += board[i][j] + " ";
		}
        
	    }
	    
	    str += "\n";

	}
	return str;
    }

    public void solve() {
	solveH(0,0,1);
    }

    private boolean solveH(int row ,int col, int level){ // level is the # of the knight

	try{
	    if(board[row][col] == 0){
		board[row][col] = level;
	    }
	    else{
		return false;
	    }
	}
	catch (IndexOutOfBoundsException e){
	    return false;
	}
	
	if (level == boardArea){
	    return true;
	}
	
	if (
		solveH(row-2,col-1,level+1) ||
		solveH(row-2,col+1,level+1) ||
		solveH(row-1,col+2,level+1) ||
		solveH(row+1,col+2,level+1) ||
		solveH(row+2,col+1,level+1) ||
		solveH(row+2,col-1,level+1) ||
		solveH(row+1,col-2,level+1) ||
		solveH(row-1,col-2,level+1)
	    ){
	    return true;
	}
	else{
	    clearGreater(level);
	    return false;
	}
	
    }

    public void clearGreater(int level){
	for(int row = 0; row < board.length; row++){
	    for(int col = 0; col < board[0].length;col++){
		if(board[row][col] == level){
		    board[row][col] = 0;
		}
	    }
	}
    }
    
    public void clearBoard(){
	for (int i = 0; i < board.length; i++) {
	    
	    for (int j = 0; j < board[i].length; j++) {
		board[i][j] = 0;
	    }
	}
    }

   
}
