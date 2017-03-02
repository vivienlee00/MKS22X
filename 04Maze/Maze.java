import java.util.*;
import java.io.*;

public class Maze{


    private char[][]maze;
    private boolean animate;


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
	maze = new char[findWidth(filename)][findLength(filename)];
	loadFile(filename);
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
	    System.out.println(length);
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
	     
	     int charNumber = 0;
	     while(line.length() > 0){
		maze[lineNumber][charNumber] = line.charAt(0);
		line = line.substring(1);
		charNumber += 1;
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



    public static void main(String[] args){
	Maze j = new Maze("data1.dat");
	System.out.println(j.toString());
    }
}


