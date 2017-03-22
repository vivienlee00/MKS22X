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

	int lt = start;
	int et = start;
	int gt = end;

	while(et<=gt){
	    if(data[et] < pivot){
		finalIndex = trackIndex(lt, et, finalIndex);
		swap(data, lt, et);
		lt+= 1;
		et+= 1;
	    }
	    else{
		if(data[et]== pivot){
		    et+=1;
		}
		else{
		    finalIndex = trackIndex(gt, et, finalIndex);
		    swap(data, gt, et);
		    gt-=1;
		}
	    }
	}

	/*
	while(right>left){

	    
	    while (data[left] < pivot){
		left += 1;
	    }
	
	    while (data[right] > pivot){
		right -= 1;
	    }



	    if(right>left){
	        swap(data,left,right);

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
	*/
	System.out.println(toString(data) + '\n');

	return finalIndex;
    }

    public static int trackIndex(int i1, int i2, int index){
	int last = -1;
	if (i1 == index){
	    last = i2;
	}
	else{
	    if(i2 == index){
		last = i1;
	    }
	    else{
		last = index;
	    }
	}
	return last;
    }

    public static void swap(int[] ary, int i1, int i2){
	int temp = ary[i1];
	ary[i1]=ary[i2];
	ary[i2]=temp;
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
 
 	int[] ary2 = {1,1,5,3,3,3,5,1,1,1,3,3,3,3,5,3,2,2,1,1,4,4,4,4};
 	System.out.println(quickselect(ary2,24));
 
     }
}
