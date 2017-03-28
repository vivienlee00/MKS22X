public class MyLinkedList{
    private LNode start;
    private int size;

    public MyLinkedList(){
	start = null;
	size = 0;
    }

    class LNode(){
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
	LNode x  =  new LNode(value, this.start);
	start = x;
	size += 1;
    }

    private int size(){
	return this.size;
    }

    private String toString(){

    }
}
