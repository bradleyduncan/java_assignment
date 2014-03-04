package java_assignment;
//import java.applet.*;
//import java.awt.*;
//import java.awt.event.*;

public class lengthCountReturn {
	
	

	
	public static void main(String[] args) {
//		String userInput = "I do not like green eggs and ham I do not like them, Sam-I-Am";
		String userInput = "hello world world";
		int [] wordLengthCount = buildLengthsAndCounts(userInput);
		int wordCount = wordCount(userInput);
		System.out.println(wordCount);
		printArray(wordLengthCount);
	}
	


	
	
	/* START method that prints out contents of an array  */
	public static void printArray(int[] builtText) {
		for(int j=0; j<builtText.length;j++)
		 {
		     System.out.println("Word Length: "+(j+1)+" Amount: "+builtText[j]);
		 }
	}
	/* END method that prints out array */

	
	
	/* START array storing counts of word lengths */
	public static int[] buildLengthsAndCounts(String userInput) {
		userInput = userInput.replaceAll("\\p{P}", "");
		String str[] = userInput.split(" "); // split the strings: "I", "am", "going", etc

		int maxLength = 1;

		for(String s: str)   // finding the word with maximum size and take its length
		  if(maxLength < s.length())
		        maxLength = s.length();

		int lengthCount[] = new int[maxLength]; 


		for(String s1: str)
		{
		   lengthCount[s1.length()-1]++; // count each length's occurance
		}
		return lengthCount;
	}
	/* END method that builds array */
	
	
	
	/* START method that word counts */

	public static int wordCount(String userInput){

	    int wordCount = 0;

	    boolean word = false;
	    int endOfLine = userInput.length() - 1;

	    for (int i = 0; i < userInput.length(); i++) {
	        // if the char is a letter, word = true.
	        if (Character.isLetter(userInput.charAt(i)) && i != endOfLine) {
	            word = true;
	            // if char isn't a letter and there have been letters before,
	            // counter goes up.
	        } else if (!Character.isLetter(userInput.charAt(i)) && word) {
	            wordCount++;
	            word = false;
	            // last word of String; if it doesn't end with a non letter, it
	            // wouldn't count without this.
	        } else if (Character.isLetter(userInput.charAt(i)) && i == endOfLine) {
	            wordCount++;
	        }
	    }
	    return wordCount;
	}
	/* END method that word counts */


}

