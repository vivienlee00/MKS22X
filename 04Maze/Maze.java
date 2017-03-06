import java.util.*;
import java.io.*;

public class Maze{


    private char[][]maze;
    private boolean animate;
    public int rowS;
    public int colS;
    private boolean hasS;
    private boolean hasE;


    /*Constructor loads a maze text file, and sets animate to false by default.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)

      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR there is no E or S then: print an error and exit the program.

    */

    public Maze(String filename){
        //COMPLETE CONSTRUCTOR
    animate = false;
    rowS = -1;
    colS = -1;
    hasS = false;
    hasE = false;
    maze = new char[findLength(filename)][findWidth(filename)];
    loadFile(filename);

    if (!hasS || !hasE) {
	    System.out.println("Missing start or end point");
	    System.exit(0);
	}

    //also need to check that maze has E and S
    }
    

    private void wait(int millis){ //ADDED SORRY!
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }


    public void setAnimate(boolean b){

        animate = b;

    }

    public int findWidth(String filename){
    try{
        Scanner inf = new Scanner(new File(filename));
        int width = 0;
        if(inf.hasNextLine()){
        String x = inf.nextLine();
        width = x.length();
        }
        return width;
    }
    catch(FileNotFoundException e){
        System.out.println("file not found");
        System.exit(1);
    }
    return 0;
    }

    public int findLength(String filename){
    try{
        Scanner inf = new Scanner(new File(filename));
        int length = 0;
        while(inf.hasNextLine()){
        String line = inf.nextLine();
        length += 1;
        }
        return length;
    }
    catch(FileNotFoundException e){
        System.out.println("file not found");
        System.exit(1);
    }
    return 0;
    }

    public void loadFile(String filename) {
    try{
    Scanner inf = new Scanner(new File(filename));

     int lineNumber = 0;
     while(inf.hasNextLine()){
         String line = inf.nextLine();
         for(int c = 0; c < line.length(); c++){
	     maze[lineNumber][c] = line.charAt(c);
	     if(line.charAt(c) == 'S'){
		 rowS = lineNumber;
		 colS = c;
		 hasS = true;
	     }
	     if(line.charAt(c) == 'E'){
		 hasE = true;
	     }
         }
         lineNumber += 1;            
     }
    }
    catch(FileNotFoundException e){
        System.out.println("file not found");
        System.exit(1);
    }
    }
    
    public void clearTerminal(){

        //erase terminal, go to top left of screen.

        System.out.println("\033[2J\033[1;1H");

    }



    /*Wrapper Solve Function
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public boolean solve(){
            int startr=-1,startc=-1;

            //Initialize starting row and startint col with the location of the S. 
	    startr = rowS;
	    startc = colS;
            maze[startr][startc] = ' ';//erase the S, and start solving!
            return solve(startr,startc);
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns true when the maze is solved,
      Returns false when the maze has no solution.


      Postcondition:

        The S is replaced with '@' but the 'E' is not.

        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
    private boolean solve(int row, int col){
        if(animate){
            System.out.println("\033[2J\033[1;1H"+this);

            wait(20);
        }

        //COMPLETE SOLVE
	if(maze[row][col] == 'E'){
	    return true;
	}

	if (maze[row][col] == '#' || maze[row][col] == '@') {
	    return false;
	}
	if (maze[row][col] == ' ') {
	    maze[row][col] = '@';
	    if (
		solve(row , col+1) ||
		solve(row , col-1) ||
		solve(row+1 , col) ||
		solve(row-1 , col)
		) {
		return true;
	    }
	}
	maze[row][col] = '.';

        return false; //so it compiles
    }



     public String toString() {

     String str = "";
    for (int i = 0; i < maze.length; i++) {

        for (int j = 0; j < maze[i].length; j++) {
        str += maze[i][j];
        str += " ";
        }

        str += "\n";
    }

    return str;
    }


    /*
    public static void main(String[] args){
    //    Maze j = new Maze("data1.dat");
    //    Maze k = new Maze("data2.dat");
        Maze l = new Maze("data3.dat");
        System.out.println(l.toString());

    }
    */
}
