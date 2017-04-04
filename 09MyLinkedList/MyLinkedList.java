public class MyLinkedList{
    private LNode start;
    private LNode tail;
    private int size;

    public MyLinkedList(){
	start = null;
	size = 0;
    }


    class LNode{
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
    }

    private boolean add(int value){
	if(size() == 0){
	    LNode x = new LNode(value);
	    start = x;
	}
	else{
	    LNode current = start;
	    while(current.next != null){
		current = current.next;
	    }
	    LNode x  =  new LNode(value);
	    current.next = x;
	    x.previous = current;
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



    public void add(int index, int value){

	if(index > this.size() || index < 0){
	    throw new IndexOutOfBoundsException();
	}

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

    public int remove(int index){

	if(index > this.size() || index < 0){
	    throw new IndexOutOfBoundsException();
	}

	if(index == this.size() - 1){
	    tail = tail.previous;
	}

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

    public int indexOf(int value){
	LNode current = start;
	int index = 0;
	while(current.value != value){
	    index+=1;
	    if(index<this.size()-1){
	    current = current.next;
	    }
	    else{index = -1;
		break;}
	}
	return index;
    }

    public static void main(String[] args){
	MyLinkedList x = new MyLinkedList();
	x.add(5);
	x.add(6);
	x.add(5);
	x.add(4);
	x.add(3);
	System.out.println(x);
	x.add(2,9);
       	System.out.println(x);
	x.remove(0);
	System.out.println(x);
       	System.out.println(x.toStringBackWards());

    }
}

