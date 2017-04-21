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

    private void addFirst(String s){
	int index = front - 1;
	if(index <= 0){
	    ary[index] = s;
	}
	else{
	    //finish
	}
    }
    
    private void addLast(String s){
    }

    private String removeFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
    }
    
    private String removeLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
    }

}
