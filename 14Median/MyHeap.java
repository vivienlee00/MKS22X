import java.util.*;

public class MyHeap{

    private ArrayList<Integer> data;
    private boolean isMax;

    public MyHeap(){

	data = new ArrayList<Integer>();
	data.add(0,null);
	isMax = true;
    }

    public MyHeap(boolean bool){
	data = new ArrayList<Integer>();
	data.add(0,null);
	isMax = bool;
    }

    public void add(int n){
	data.add(n);
	pushUp();
    }

    public Integer remove(){
	int temp = data.get(1);
	data.set(1, data.get(data.size() - 1));
	data.remove(data.size() - 1);
	pushDown();
	return temp;
    }

    public Integer peek(){
	return data.get(1);
    }

    private void pushUp(){
	Integer temp = data.get(data.size() - 1);
	int index = data.size() - 1;

	if(isMax){
	    while((index/2 > 0) &&
		  (temp.compareTo(data.get(index/2)) > -1)){
		swap(data, index, index/2);
		index = index/2;
	    }
	}
	else{
	    while((index/2 > 0) &&
		  (temp.compareTo(data.get(index/2)) < 1)){
		swap(data, index, index/2);
		index = index/2;
	    }
	}
	
    }

    private void pushDown(){
	Integer temp = data.get(1);
	int index = 1;

	if(isMax){
	    while((index*2 < data.size()) &&
		  (temp.compareTo(data.get(index*2)) < 1)){
		swap(data, index, index*2);
		index = index*2;
	    }
	}
	else{
	    while((index*2 < data.size()) &&
		  (temp.compareTo(data.get(index*2)) > -1)){
		swap(data, index, index*2);
		index = index*2;
	    }
	}
    }

    private void swap(ArrayList<Integer> ary, int ind, int ind2){
	Integer temp = ary.get(ind);
	ary.set(ind, ary.get(ind2));
	ary.set(ind2, temp);
    }

    public String toString(){
	String temp = "";

	for(Integer str : data){
	    temp += str + " ";
	}

	return temp;
    }

    public static void main(String[] args){
	MyHeap x = new MyHeap();
	x.add(1);
	System.out.println(x.toString());
	x.add(4);
	System.out.println(x.toString());
	x.add(2);
	System.out.println(x.toString());
	x.add(3);
	System.out.println(x.toString());
	x.add(1);
	System.out.println(x.toString());



    }
    
}
