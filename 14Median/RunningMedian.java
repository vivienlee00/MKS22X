public class RunningMedian{

    MyHeap maxHeap;
    MyHeap minHeap;
    int maxSize;
    int minSize;
    int choose;

    public RunningMedian(){
	
	maxHeap = new MyHeap();
	minHeap = new MyHeap(false);
	maxSize = 0;
	minSize = 0;
	choose = 0;

    }

    public void add(int n){
	if (n > this.getMedian()){
	    minHeap.add(n);
	    minSize += 1;
	}
	else{
	    if(n < this.getMedian()){
		maxHeap.add(n);			
		maxSize += 1;
	    }
	    else{
		if (choose % 2 == 0){
		    maxHeap.add(n);
		}
		else{
		    minHeap.add(n);
		}
		choose += 1;
	    }
	}

	//have to do the balancing thingymabob

    }

    public double getMedian(){
	
	if(maxSize == 0 && minSize == 0){
	    return 0;
	}
	
	if(maxSize == minSize){
	    return (maxHeap.peek() + minHeap.peek());
	}
	else{
	    if (maxSize > minSize){
		return maxHeap.peek();
	    }
	    else{
		return minHeap.peek();
	    }
	}
    }


    public static void main(){
	RunningMedian x = new RunningMedian();
	x.add(15);
	x.add(25);
	x.add(35);
    }

}
