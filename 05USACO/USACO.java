import java.io.*;
import java.util.*;

public class USACO{

    public USACO(){
    }

    //////////////////////////////////////////////////////////////////////
    
    public int bronze(String filename){
	BufferedReader in = null;
	PrintWriter out = null;
	try{
	    in= new BufferedReader(new FileReader(filename));
	}
	catch(Exception e){System.out.println("Exception");}

	StringTokenizer st = null;
		
	int r, c, e, n;
	try{
	    st = new StringTokenizer(in.readLine());
	}catch(Exception ex){}
		
	r = Integer.parseInt(st.nextToken());
	c = Integer.parseInt(st.nextToken());
	e = Integer.parseInt(st.nextToken());
	n = Integer.parseInt(st.nextToken());
		
	int[][] lake = new int[r][c];
	for(int row = 0; row < r; row++) {
	    try{
		st = new StringTokenizer(in.readLine());}
	    catch (Exception ex){}
			
	    for(int col = 0; col < c; col++){
		lake[row][col] = Integer.parseInt(st.nextToken());
		//System.out.println(lake[row][col]);
	    }
	}
	int rs, cs, ds;
	for(int x = 0; x<n; x++){
	    try{
		st = new StringTokenizer(in.readLine());
	    }
	    catch(Exception ex){}
	    
	    rs = Integer.parseInt(st.nextToken()) - 1;
	    cs = Integer.parseInt(st.nextToken()) - 1;
	    ds = Integer.parseInt(st.nextToken());
	    stomp(rs, cs, ds, lake);
	}
	return getVolume(r, c , e, lake);
    }

    public static int getVolume(int r , int c , int e, int[][] lake) {
	int totalDepth = 0;
        for(int x = 0; x <r; x++){
	    for (int y =0; y< c; y++){
		if (lake[x][y]-e < 0) totalDepth += (e-lake[x][y]);
	    }
	}
	
	return totalDepth*72*72;
    }

    public static void stomp(int rs, int cs, int ds, int[][] lake) {
	int highX, highY;
	int hi = -999;
	for (int x = rs; x < rs+3; x++) {
	    for (int y = cs; y<cs+3; y++) {
		if (lake[x][y] > hi) {
		    hi = lake[x][y];
		    highX = x;
		    highY = y;
		}
	    }
	}

	for(int x = rs; x <rs+3; x++){
	    for (int y =cs; y< cs+3; y++){
		int temp = (ds-(hi-lake[x][y]));
		if(temp>0){
		    lake[x][y] -= temp;
		}
		//System.out.print(lake[x][y] + " ");
	    }
	    //System.out.println();
	}
	//System.out.println(hi);
    }

    ////////////////////////////////////////////////////////////////////////

    public int silver(String filename){

	BufferedReader in = null;
	try{
	    in= new BufferedReader(new FileReader(filename));
	}
	catch(Exception e){System.out.println("Exception");}
	
	StringTokenizer st = null;
		
	int r, c, t;
	try{st = new StringTokenizer(in.readLine());}
	catch(Exception e) {}
		
	r = Integer.parseInt(st.nextToken());
	c = Integer.parseInt(st.nextToken());
	t = Integer.parseInt(st.nextToken());

	int[][][] pasture = new int[r][c][2];
	for(int row = 0; row<r; row++){

	    try{
		String str = in.readLine();
		char[]chars = str.toCharArray();


		for(int col = 0; col<c; col++){
		    if (chars[col] == '.'){
			pasture[row][col][0] = 0;
		    }

		    if (chars[col] == '*'){
			pasture[row][col][0] = -1;
		    }
	
		}
	    }
	    catch(Exception ex){}
		
	
	}
	

	int startX, startY, endX, endY;
	try{st = new StringTokenizer(in.readLine());}
	catch(Exception e) {}
		
	startX = Integer.parseInt(st.nextToken()) - 1;
	startY = Integer.parseInt(st.nextToken()) - 1;
	endX = Integer.parseInt(st.nextToken()) - 1;
	endY = Integer.parseInt(st.nextToken()) - 1;

	firstMove(startX, startY, pasture);
	addMoves(t, pasture);
	//	System.out.println(toString(pasture));
	return pasture[endX][endY][0];
    }

    public void firstMove(int x, int y, int[][][]pasture){

	try{
	    if(pasture[x-1][y][0] != -1){
		pasture[x-1][y][0] = 1;
	    }
	}
	catch(IndexOutOfBoundsException e){}

	    
	try{
	    if(pasture[x+1][y][0] != -1){
		pasture[x+1][y][0] = 1;
	    }
	}
	catch(IndexOutOfBoundsException e){}


	    	    
	try{
	    if(pasture[x][y+1][0] != -1){
		pasture[x][y+1][0] = 1;
	    }
	}
	catch(IndexOutOfBoundsException e){}


	try{
	    if(pasture[x][y-1][0] != -1){
		pasture[x][y-1][0] = 1;
	    }
	}
	catch(IndexOutOfBoundsException e){}

	    
    }

    
    public void addMoves(int steps, int[][][]pasture){

	for(int step = 0; step<steps-1; step++){

	    for(int r=0; r<pasture.length;r++){

		for(int c =0; c<pasture[0].length; c++)
		    {
			pasture[r][c][1] = findNum(r,c,pasture);
		    }


	    }
	    copyAry(pasture);
	}
    }


    public int findNum(int x, int y, int[][][]pasture){
	int sum = 0;

	if(pasture[x][y][0] == -1){
	    return -1;
	}
	
	try{
	    if(pasture[x][y-1][0] != -1){
	        sum+=pasture[x][y-1][0];
	    }
	}
	catch(IndexOutOfBoundsException e){}


	try{
	    if(pasture[x][y+1][0] != -1){
	        sum+=pasture[x][y+1][0];
	    }
	}
	catch(IndexOutOfBoundsException e){}
	

	try{
	    if(pasture[x-1][y][0] != -1){
	        sum+=pasture[x-1][y][0];
	    }
	}
	catch(IndexOutOfBoundsException e){}
	

	try{
	    if(pasture[x+1][y][0] != -1){
	        sum+=pasture[x+1][y][0];
	    }
	}
	catch(IndexOutOfBoundsException e){}

	return sum;
	
    }

    public void copyAry(int[][][]pasture){

	for(int r=0; r<pasture.length;r++){
	    for(int c = 0; c<pasture[0].length;c++){
		pasture[r][c][0] = pasture[r][c][1];
	    }
	}

    }

    public String toString(int[][][]pasture){

	String str = "";
	
	for(int r=0; r<pasture.length;r++){
	    for(int c = 0; c<pasture[0].length;c++){
		str += pasture[r][c][0];
		str+= " | ";
	    }
	    str += '\n';
	}
	return str;
    }
 
    ///////////////////////////////////////////////////////////////////////
}
