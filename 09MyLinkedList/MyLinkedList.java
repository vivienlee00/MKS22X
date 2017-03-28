public class MyLinkedList{
    private LNode start;
    private int size;

    public MyLinkedList(){
	start = null;
	size = 0;
    }


    class LNode{
	private int value;
	private LNode next = null;

	private LNode(int val){
	    value = val;
	}
	
	private LNode(int val, LNode nextNode){
	    value = val;
	    next = nextNode;
	}
    }

    private boolean add(int value){
	//EDIT: adds node to the front
	LNode x  =  new LNode(value, this.start);
	start = x;
	size += 1;
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
	//EDIT: x+= backspace char + "]"
	return x;
    }

    public int get(int index){
	int ans = 0;
	LNode current = start;
	for(int i = 0; i < index+1; i++){
	    ans = current.value;
	    current = current.next;
	}
	return ans;
    }

    public int set(int index, int newValue){
	LNode current = start;
	for(int i = 0; i < index; i++){
	    current = current.next;
	}
	int ans = current.value;
	current.value = newValue;
	return ans;
    }

    //indexOf; add(index, value); remove
    //exceptions

    public static void main(String[] args){
	MyLinkedList x = new MyLinkedList();
	x.add(5);
	x.add(6);
	x.add(5);
	x.add(4);
	x.add(3);
	System.out.println(x + "  size=" +  x.size());
	System.out.println(x.set(3,7));
	System.out.println(x + "  size=" +  x.size());

    }
}
