import java.util.*;

public class FrontierPriorityQueue implements Frontier{

    private ArrayList<Location> data;

    public FrontierPriorityQueue(){

	data = new ArrayList<Location>();
	data.add(0,null);
    }


    public void add(Location x){
	data.add(x);
	pushUp();
    }

    public Location next(){ //remove?
	Location temp = data.get(1);
	data.set(1, data.get(data.size() - 1));
	data.remove(data.size() - 1);
	pushDown();
	return temp;
    }

    public Location peek(){
	return data.get(1);
    }

    private void pushUp(){
	Location temp = data.get(data.size() - 1);
	int index = data.size() - 1;

	    while((index/2 > 0) &&
		  (temp.compareTo(data.get(index/2)) < 1)){
		swap(data, index, index/2);
		index = index/2;
	    }
    }
	

    private void pushDown(){

	if(data.size() == 1){
	    return;
	}
	
	Location temp = data.get(1);
	int index = 1;

	while((index*2 < data.size()) &&
	      ((temp.compareTo(data.get(index*2)) > -1) ||
	       (temp.compareTo(data.get(index*2)+1)) > -1)
	      ){
		
	    if((temp.compareTo(data.get(index*2)) > -1)&&
	       ((index*2) + 1 >= data.size() ||
		(data.get(index*2).compareTo(data.get((index*2) +1)) < 1)
		)){
		swap(data, index, index*2);
		index = index*2;
	    }
	    else{
		swap(data, index, (index*2)+1);
		index = (index*2)+1;
	    }
	}
    }
	    


    private void swap(ArrayList<Location> ary, int ind, int ind2){
	Location temp = ary.get(ind);
	ary.set(ind, ary.get(ind2));
	ary.set(ind2, temp);
    }

    public String toString(){
	String temp = "";

	for(Location x : data){
	    temp += x.getdistToGoal() + " ";
	}
	
	temp += '\n';

	for(Location x : data){
	    temp += (x.getdistToGoal() + x.getdistToStart()) + " ";
	}

	return temp;
    }

}
