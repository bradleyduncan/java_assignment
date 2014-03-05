package java_assignment;
//import static java.lang.System.out;
//
//import java.io.BufferedReader;
//import java.util.Arrays;
//import java.io.*;
//import java.util.Scanner;
//import static java.lang.System.in;
//import static java.lang.System.out;
//import java.applet.*;
//import java.awt.*;
//import java.awt.event.*;

public class lengthCountReturn {
	
	

	
	public static void main(String[] args) {
//		String userInput = "I do not like green eggs and ham I do not like them, Sam-I-Am";
		String userInput = "Hey how are you today";
		
		int [] wordLengthCount = buildLengthsAndCounts(userInput);
		System.out.println(meanWordCalc(wordLengthCount));
//		printArray(wordLengthCount);
	}
	
	public static int characterCount(int[] builtText) {
		int characterCount = 0;
		for(int j=0; j < builtText.length;j++) {
			characterCount = characterCount + ((builtText[j]) * j+1);
		}
		System.out.println(characterCount);
		return characterCount;
	}
	
	public static double meanWordCalc(int wordLengthCount[]) { 
		int WordCount = 0, CharCount = 0, j; 
		double MeanLength; 

		for (j = 1; j < wordLengthCount.length; j++) { 
		WordCount += wordLengthCount[j]; 
		} 

		for (j = 1; j < wordLengthCount.length; j++) { 
		CharCount += j * wordLengthCount[j]; 
		} 

		MeanLength = (double) CharCount / (double) WordCount; 

		return MeanLength+1; 
		} 
	
	/* START method that prints out contents of an array  */
	public static void printArray(int[] builtText) {
		for(int j=0; j<builtText.length;j++)
		 {
		     System.out.println("Word Length: "+(j+1)+" Amount: "+builtText[j]);
		 }
	}
	
	/* END method that prints out array */

	
//	SLB1 = ((250 / StringCount) * stringLength1);  
//    SLB11 = (300 - SLB1);
//    SLB1 = (300 - SL);B11
	
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


