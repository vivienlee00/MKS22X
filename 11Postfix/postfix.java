import java.util.Stack;
import java.util.StringTokenizer;

public class postfix{


    public static double eval(String s){
	Stack<String> stack = new Stack<String>();
	StringTokenizer st = new StringTokenizer(s);
	
	while(st.hasMoreTokens()){
	    String str = st.nextToken();
	    if(isOp(str)){
		stack.push("" + apply(stack.pop(), stack.pop(), str));
	    }
	    else{
		stack.push(str);
	    }
	}

	Double ans = Double.parseDouble(stack.pop());
	return ans;
    }

    private static boolean isOp(String s){
	if(s.equals("+")){
	    return true;
	}
	if(s.equals("-")){
	    return true;
	}
	if(s.equals("*")){
	    return true;
	}
	if(s.equals("/")){
	    return true;
	}
	if(s.equals("%")){
	    return true;
	}
	return false;		
    }

    private static double apply(String a, String b, String op){
	Double A = Double.parseDouble(a);
	Double B = Double.parseDouble(b);
	
	if(op.equals("+")){
	    return A + B;
	}
	if(op.equals("-")){
	    return A - B;
	}
	if(op.equals("*")){
	    return A * B;
	}
	if(op.equals("/")){
	    return A / B;
	}
	else{
	    return A % B;
	} 
    }

    public static void main (String[]args) {
	//	System.out.println(eval("2 3 + 5 * 5 % 2 2 - +"));
	System.out.println(eval("10 2.0 +"));
    }
    
    
}
	    
	      
	 
	    
