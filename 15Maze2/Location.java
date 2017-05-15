public class Location{
    private int row;
    private int col;
    private Location previous;
    private int distanceToStart;
    private int distanceToGoal;
    private boolean Astar;

    public Location(int r, int c, Location prev, 
		    int disStart, int disGoal){
	row = r;
	col = c;
	previous = prev;
	distanceToStart = disStart;
	distanceToGoal = disStart;
	Astar = false;
    }

    public Location(int r, int c, Location prev,
		    int disStart, int disGoal, boolean aStar){
	row = r;
	col = c;
	previous = prev;
	distanceToStart = disStart;
	distanceToGoal = disStart;
	Astar = aStar;
    }

}
