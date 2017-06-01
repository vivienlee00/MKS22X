import java.util.*;
public class MyDeque{

    String[] ary;
    int front;
    int back;
    int amount;
    int size;

    public MyDeque(){
	ary =  new String[5];
	size = 5;
	amount = 0;
	front = 0;
	back = 0;
    }

    public String toString() {
	String str = "[";

	for (int j = 0; j < ary.length; j++) {
	    str += ary[j];
	    str += " ";
	}

	str+="]";

	return str;
    }
    
    public void addFirst(String s){

	if(s == null){
	    throw new NullPointerException();
	}

	
	int index = 0;
	if(amount == 0){
	     index = 0;
	}
	else{
	     index = front - 1;
	}
	
	if(amount < size){
	    if(index >= 0){
		ary[index] = s;
		front = index;
		amount += 1;
	    }
	    else{
		ary[size + index] = s;
		front = size + index;
		amount += 1;
	    }
	}
	else{
	    doubleCap();
	    addFirst(s);
	}

    }

    private void doubleCap(){
	int newSize = size * 2;
	String[] ary2 = new String[newSize];

	int y = 0;
	int am = 0;
	
	for(int i = front; i < size && am < amount; i++){
	    ary2[y] = ary[i];
	    y += 1;
	    am += 1;
	}
	
	for(int i = 0; i < back+1 && am < amount; i++){
	    ary2[y] = ary[i];
	    y += 1;
	    am += 1;
	}
	ary = ary2;
	size = newSize;
	front = 0;
	back = amount-1;
    }
    
    public void addLast(String s){

	if(s == null){
	    throw new NullPointerException();
	}
	
	int index = 0;
	if(amount == 0){
	     index = 0;
	}
	else{
	     index = back + 1;
	}
	
	if(amount < size){
	    if(index < size){
		ary[index] = s;
		back = index;
		amount += 1;
	    }
	    else{
		ary[0] = s;
		back = 0;
		amount += 1;
	    }
	}
	else{
	    doubleCap();
	    addLast(s);
	}
    }


    
    public String removeFirst(){
	if(size == 0 || amount == 0){
	    throw new NoSuchElementException();
	}

	String x = ary[front];
	ary[front] = null;
	
	int newFront = front + 1;
	if(newFront < size){
	    front = newFront;
	    amount -= 1;
	}
	else{
	    front = 0;
	    amount -= 1;
	}

	if(amount == 0){
	    front = 0;
	    back = 0;
	}
	return x;
    }
    
    public String removeLast(){
	if(size == 0 || amount == 0){
	    throw new NoSuchElementException();
	}

	String x = ary[back];
	ary[back] = null;
	
	int newBack = back - 1;
	if(newBack >= 0){
	    back = newBack;
	    amount -= 1;
	}
	else{
	    back = size + newBack;
	    amount -= 1;
	}
	
	if(amount == 0){
	    front = 0;
	    back = 0;
	}
	return x;
    }

    public String getFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	return ary[front];
    }

    public String getLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	return ary[back];
    }
   

}
