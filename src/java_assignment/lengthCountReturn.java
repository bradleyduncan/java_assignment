package java_assignment;


public class lengthCountReturn {

	public static void main(String[] args) {
		String userInput = "I do not like green eggs and ham I do not like them, Sam-I-Am";
		int [] wordLengthCount = buildLengthsAndCounts(userInput);
		System.out.println(wordLengthCount[0]);
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

}

