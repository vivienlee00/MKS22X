import java.util.*;


public class partition{

    public static int getKth(int[] data, int index){
	return 0;
    }

    public static int part(int[] data, int start, int end){

	Random randgen = new Random();
	//	int pivotIndex  = randgen.nextInt((end-start)+1);
	int pivotIndex = 1;
	int pivot = data[pivotIndex+start];
	System.out.println(pivot);
	System.out.println(toString(data));

	//	int finalIndex = 0;

	int left = start;
	int right = end;

	while(right>left){

	    
	    while (data[left] < pivot){
		left += 1;
	    }
	
	    while (data[right] > pivot){
		right -= 1;
	    }


	    if(right>left){
		int temp = data[left];
		data[left] = data[right];
		data[right] = temp;
		System.out.println(toString(data) + " - " + left + "," + right);
		
		if(data[left] == data[right]){
	       	right-=1;
		}
	        }
	}
	
	return 0;
    }

     public static String toString(int[] data) {
	String str = "[";

	    for (int j = 0; j < data.length; j++) {
		str += data[j];
		str += " ";
	    }

	return str;
    }


    public static void main(String[] args){

	/*
	
	int[] ary = {8,6,7,5,3,0};
	int[] ary2 = {1,2,3,4,5,6};
	int[] ary3 = {6,5,4,3,2,1};

	*/
	
	int[] ary4 = {3,3,2,1,3,3};

	/*
	part(ary,0,ary.length-1);
	part(ary2,0,ary2.length-1);
	part(ary3,0,ary3.length-1);
	*/
        part(ary4,0,ary4.length-1);

	/*
	System.out.println(toString(ary));
	System.out.println(toString(ary2));
	System.out.println(toString(ary3));
	*/
        System.out.println(toString(ary4));

    }
}
