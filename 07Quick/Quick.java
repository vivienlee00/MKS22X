import java.util.*;


public class Quick{


    public static void quickSort(int[] data){
	quickSortHelp(data, 0, data.length-1);
    }

    public static void quickSortHelp(int[] data, int start, int end){
	int ans = part(data,start,end);

	if(end-(ans+1) > 1){
	quickSortHelp(data,ans+1,end);
	}

	if((ans-1) - start > 1){
	quickSortHelp(data,start,ans-1);
	}
    }

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

	System.out.println("pivot =" + pivot + "  index=" + finalIndex);
	System.out.println(toString(data) + '\n');
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

	int[] ary2 = {1,1,5,3,3,3,5,1,1,1};
	quickSort(ary2);
	System.out.println(toString(ary2));

    }

    
}
