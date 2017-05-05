import java.util.*;

public class MyHeap{

    private ArrayList<String> data;
    private boolean isMax;

    public MyHeap(){

	data = new ArrayList<String>();
	data.add(0,"");
	isMax = true;
    }

    public MyHeap(boolean bool){
	data = new ArrayList<String>();
	data.add(0,"");
	isMax = bool;
    }

    public void add(String str){
	data.add(str);
	pushUp();
    }

    public String remove(){
	String temp = data.get(1);
	data.set(1, data.get(data.size() - 1));
	data.remove(data.size() - 1);
	pushDown();
	return temp;
    }

    public String peek(){
	return data.get(1);
    }

    private void pushUp(){
	String temp = data.get(data.size() - 1);
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
	String temp = data.get(1);
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

    private void swap(ArrayList<String> ary, int ind, int ind2){
	String temp = ary.get(ind);
	ary.set(ind, ary.get(ind2));
	ary.set(ind2, temp);
    }

    public String toString(){
	String temp = "";

	for(String str : data){
	    temp += str + " ";
	}

	return temp;
    }

    public static void main(String[] args){
	MyHeap x = new MyHeap();
	x.add("A");
	System.out.println(x.toString());
	x.add("D");
	System.out.println(x.toString());
	x.add("B");
	System.out.println(x.toString());
	x.add("C");
	System.out.println(x.toString());
	x.add("A");
	System.out.println(x.toString());



    }
    
}
