import java.util.*;
public class MyLinkedList implements Iterable<Integer>{
    LNode start;
    LNode tail;
    int size;

    public MyLinkedList(){
	start = null;
	tail = null;
	size = 0;
    }

    public class linkedListIterator implements Iterator<Integer>{

	private LNode current;
	private int currentIndex;

	public linkedListIterator(MyLinkedList data){
	    current = data.start;
	    currentIndex = 0;
	}
    
	public boolean hasNext(){
	    return current.next != null;
	}

	public Integer next(){
	    if(currentIndex == 0){
		currentIndex++;
		return current.value;
	    }
	    else{
		if(hasNext()){
		    current = current.next;
		    currentIndex++;
		    return current.value;
		}
		else{
		    throw new NoSuchElementException();
		}
	    }
	}

	public void remove(){
	    throw new UnsupportedOperationException();
	}
    }
    

    
    private class LNode{
	private int value;
	private LNode next = null;
	private LNode previous = null;

	private LNode(int val){
	    value = val;
	}
	
	private LNode(int val, LNode nextNode){
	    value = val;
	    next = nextNode;
	}

	public String toString(){
	    return value+"";
	}
    }

    public boolean add(int value){
	if(size() == 0){
	    LNode x = new LNode(value);
	    start = x;
	    tail = x;
	}
	else{
	    LNode x  =  new LNode(value);
	    tail.next = x;
	    x.previous = this.tail;
	    this.tail = x;
	}
	this.size += 1;
	return true;
    }

    public int size(){
	return this.size;
    }

    public String toString(){
	String x = "[";
	LNode current = start;
	while(current != null){
	    x+=(current.value + ",");
	    current = current.next;
	}
	x+= '\b' + "]";
	return x;
    }

    public String toStringBackWards(){
	String x = "[";
	LNode current = tail;
	while(current != null){
	    x+=(current.value + ",");
	    current = current.previous;
	}
	x+= '\b' + "]";
	return x;
    }

    public int get(int index){

	if(index > this.size() || index < 0){
	    throw new IndexOutOfBoundsException();
	}

	int ans = 0;
	LNode current = start;
	for(int i = 0; i < index+1; i++){
	    ans = current.value;
	    current = current.next;
	}
	return ans;
    }

    public LNode getNthNode(int index){

	if(index > this.size() || index < 0){
	    throw new IndexOutOfBoundsException();
	}

	LNode temp = start;
	LNode current = start;
	for(int i = 0; i < index+1; i++){
	    temp = current;
	    current = current.next;
	}
	return temp;
    }

    public int set(int index, int newValue){

	if(index > this.size() || index < 0){
	    throw new IndexOutOfBoundsException();
	}

	LNode current = start;
	for(int i = 0; i < index; i++){
	    current = current.next;
	}
	int ans = current.value;
	current.value = newValue;
	return ans;
    }

    public void addFront(int value){
 	LNode x  =  new LNode(value, this.start);
	this.start.previous = x;
 	this.start = x;
 	size += 1;
    }

    public void add(int index, int value){


	if(index > this.size() || index < 0){
	    throw new IndexOutOfBoundsException();
	}

	if(index == 0 && this.size() != 0){
	    addFront(value);
	}
	else{
	    if(index == this.size()){
		add(value);
	    }
	    else{
		if(index == 1){
		    LNode x = new LNode(value,start.next);
		    x.previous = start;
		    start.next = x;
		    x.next.previous = x;
		    size += 1;

		}
		else{
		    LNode current = start;
		    LNode temp = start;
		    for(int i =0; i < index-1; i++){
			temp = current.next.next;
			current = current.next;
		    }
		    LNode x = new LNode(value, temp);
		    current.next = x;
		    x.previous = current;
		    temp.previous = x;
		    this.size += 1;
		}
	    }
	}

    }

    public int remove(int index){

	if(index > this.size() || index < 0){
	    throw new IndexOutOfBoundsException();
	}

	if(index == this.size() - 1){
	    if(this.size() == 1){
		int temp = start.value;
		this.start = null;
		this.size -= 1;
		return temp;
	    }
	    else{
		int temp = tail.value;
		tail = tail.previous;
		tail.next = null;
		this.size -= 1;
		return temp;
	    }
	}
	else{
	    if(index != 0){
		if(index == 1){
		    int val = start.next.value;
		    start.next.next.previous = start;
		    start.next = start.next.next;
		    this.size -= 1;

		    return val;
		}
		else{
		    LNode current = start;
		    LNode temp = start;
		    int val = 0;
	
		    for(int i = 0; i < index-1; i++){
			temp = current.next.next.next;
			val = temp.value;
			current = current.next;
		    }
		    current.next = temp;
		    temp.previous = current;
		    this.size -= 1;
		    return val;
		}
	    }
	    else{
		int temp = start.value;
		start = start.next;
		start.previous = null;
		this.size -= 1;
		return temp;
	    }
	}
    }

    public int indexOf(int value){
	LNode current = start;
	int index = 0;
	while(current.value != value){
	    index+=1;
	    if(index<this.size()-1){
		current = current.next;
	    }
	    else{
		if(index==this.size()-1 && this.get(this.size()-1)==value){
		    return index;
		}
		else{index = -1;
		    break;}
	    }
	}
	return index;
    }


    public linkedListIterator iterator() {
       	return new linkedListIterator(this);
    }



}


