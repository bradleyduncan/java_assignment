package java_assignment;


public class lengthCountReturn {

	public static void main(String[] args) {
		String userInput = "I am going to find some string lengths sdjkfsbdkfzbgnsg";
		String str[] = userInput.split(" "); // split the strings: "I", "am", "going", etc

		int maxLength = 0;

		for(String s: str)   // finding the word with maximum size and take its length
		  if(maxLength < s.length())
		        maxLength = s.length();

		int lengthCount[] = new int[maxLength+1]; 


		for(String s1: str)
		{
		   lengthCount[s1.length()]++; // count each length's occurance
		}

		 for(int j=0; j<lengthCount.length;j++)
		 {
		     System.out.println("String length: "+j+" count: "+lengthCount[j]);
		     
		 }
		 
	}

}

