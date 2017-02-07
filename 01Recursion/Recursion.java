public class Recursion{

    public static String name(){
	return "Lee,Vivien";
    }

    public static double sqrt(double n){
	return sqrtHelp(n, 1);
    }

    public static double sqrtHelp(double n, double guess){
	if (n == 0){
	    return 0;
	}
	if (checkEqual(n, (guess * guess))){
	    return guess;
	}
	else{
	    double betterGuess = ((n/guess) + guess) / 2;
	    return sqrtHelp(n, betterGuess);
	}
    }

    public static boolean checkEqual(double n, double guessSquared){
	if ((((guessSquared-n)/n)*100) <= 0.00001 &&
	    (((guessSquared-n)/n)*100) >= 0){
	    return true;
	}

	return false;
    }

    public static void main(String[] args){
	System.out.println(sqrt(25));
	System.out.println(sqrt(36));
	System.out.println(sqrt(100));
    }
    
}
