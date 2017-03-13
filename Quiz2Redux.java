
import java.util.*;


public class Quiz2Redux{  
  /*Returns an ArrayList<String> that contains all subsets of the
   *characters of String s. Assume s has no duplicate characters.
   *the characters should appear in the same order that they occur 
   *in the original string.
   */

    
    public static ArrayList<String> combinations(String s){
	ArrayList<String>words = new ArrayList<String>();
	help(words , 0, s.length(), s);
	Collections.sort(words);
	return words;
    }


    
    private static void help(ArrayList<String> words, int current, int endIndex, String w){

	if(current == 0){
	    words.add("");
	    try{
		words.add(w.substring(0,1));
		help(words, current+1, endIndex, w);
	    }
	    catch(IndexOutOfBoundsException e){};
	    return;
	}

	if(current == endIndex){
	    return;
	}

	int origSize = words.size();
	for(int i = 0; i < origSize; i++){
	    words.add((words.get(i)) + w.substring(current,current+1));
	}

	help(words,current+1, endIndex, w);
	return;
    }

}
