public class Merge{

    /*
      TEST CASES
      array size: 1 million
      -completely random
      -random from 0-10
      -all 0's
      -sorted
      -reverse sorted
     */

    public static void mergesort(int[]ary){

	int leftL = 0;
	int rightL = 0;

	if(ary.length <= 1){
	    return;
	}

	if((ary.length % 2) == 0){
	    leftL = ary.length/2;
	    rightL = ary.length/2;
	}
	else{
	    leftL = (ary.length/2) + 1;
	    rightL = ary.length/2;
	}
	

	int[]left = new int[leftL];
	int[]right = new int[rightL];

	for(int l = 0; l < left.length; l++){
	    left[l] = ary[l];
	}

	for(int r = 0; r < right.length; r++){
	    right[r] = ary[r+(left.length)];
	}

		
	mergesort(left);
	mergesort(right);

		
	int[] dest = new int[left.length + right.length];
	merge(left, right, dest);

	for(int i = 0; i<ary.length; i++){
	    ary[i] = dest[i];
	}
    }


    public static void merge(int[]a, int[]b,  int[]destination){
	//assume a and b are sorted, destination.length == a.length + b.length

	int iA = 0;
	int iB = 0;

	for(int r = 0; r < destination.length; r++){


	    
	    // try{
	    if(a[iA] <= b[iB]){
		destination[r] = a[iA];

		if((iA+1)<a.length){
		iA+=1;
		}
		else{fill(b, iB, destination, r+1);
		    break;}
	    }
	    else{
		destination[r] = b[iB];
		
		if((iB+1)<b.length){
		iB+=1;
		}
		else{fill(a, iA, destination, r+1);
		    break;}
	    }
	    //}
	//  catch(IndexOutOfBoundsException e){}
	}
    }


    public static void fill(int[]ary, int index, int[]dest, int ind2){
	while(ind2 < dest.length){
	    dest[ind2] = ary[index];
	    ind2+=1;
	    index+=1;
	}
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



}
