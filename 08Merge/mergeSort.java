public class Merge{


    public static int[] mergesort(int[]ary){
	if((ary.length % 2) == 0){
	    int[]left = new int[ary.length/2];
	    int[]right = new int[ary.length/2];
	}
	else{
	    int[]left = new int[(ary.length/2) + 1];
	    int[]right = new int[ary.length/2];
	}

	for(int l = 0; l < left.length; l++){
	    left[l] = ary[l];
	}
	/////////////////
	for(int r = left.length-1; l < right.length; l++){
	    left[l] = ary[l];
	}
    }


    public static void merge(int[]a, int[]b,  int[]destination){
	//assume a and b are sorted, destination.length == a.length + b.length

	index iA = 0;
	index iB = 0;

	for(int r = 0; r < destination.length; r++){
	    if(a[iA] <= b[iB]){
		destination[r] = a[iA];
		iA+=1;
	    }
	    else{
		destination[r] = b[iB];
		iB+=1;
	    }
	}
    }


}
