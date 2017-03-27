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

	
	System.out.println(toString(left));
	System.out.println(toString(right)+ '\n');
	
	mergesort(left);
	mergesort(right);

		
	int[] dest = new int[left.length + right.length];
	merge(left, right, dest);
    }


    public static void merge(int[]a, int[]b,  int[]destination){
	//assume a and b are sorted, destination.length == a.length + b.length

	int iA = 0;
	int iB = 0;

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
	int[] v = {5,4,3,2,1};
	mergesort(v);
	System.out.println(toString(v));
    }


}
