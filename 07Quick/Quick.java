import java.util.*;


public class Quick{

    public static int quickselect(int[] data, int k){
	return partHelp(data,k,0,data.length-1);
    }


    public static int partHelp(int[]data, int k, int start, int end){

	int ans = part(data,start,end);

	if(ans < k){
	    return partHelp(data,k,ans+1,end);
	}
	
	if(ans > k){
	    return partHelp(data,k,start,ans-1);
	}

	return data[ans];
	
    }

    public static int part(int[] data, int start, int end){

	Random randgen = new Random();
       	int pivotIndex  = (randgen.nextInt((end-start)+1) + start);
	int pivot = data[pivotIndex];

       	int finalIndex = pivotIndex;

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

		int tempIndex = finalIndex;
		if(left == tempIndex){
		    finalIndex = right;
		}

		if(right == tempIndex){
		    finalIndex = left;
		}

		if(data[left] == data[right]){
		    right-=1;
		}

	    }
	}
	return finalIndex;
    }

     public static String toString(int[] data) {
	String str = "[";

	    for (int j = 0; j < data.length; j++) {
		str += data[j];
		str += " ";
	    }

	    str+="]";

	return str;
    }


    public static void main(String[] args){

	/*
	
	int[] ary = {8,6,7,5,3,0};
	int[] ary2 = {1,2,3,4,5,6};
	int[] ary3 = {6,5,4,3,2,1};

	*/
	
	int[] ary4 = {2,10,15,23,0,5};

	/*
	part(ary,0,ary.length-1);
	part(ary2,0,ary2.length-1);
	part(ary3,0,ary3.length-1);
	
        part(ary4,0,ary4.length-1;

	
	System.out.println(toString(ary));
	System.out.println(toString(ary2));
	System.out.println(toString(ary3));
	*/
	//  System.out.println(toString(ary4));
	System.out.println(quickselect(ary4,2));
    }
}
