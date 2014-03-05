package java_assignment;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public strictfp class JavaAppletMain extends Applet implements ActionListener {

    Label textBoxCaption;    //Caption for the text box
    TextField inputField; //Input field
    Button analyseButton;   //Analyse button
    Button resetButton;      //Reset button
    String inputText;
    int meanLength;
    int[] lengthCountArray;
    
    /*  --------------METHODS-------------- */
	
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
		double meanLength; 

		for (j = 1; j < wordLengthCount.length; j++) { 
		WordCount += wordLengthCount[j]; 
		} 

		for (j = 1; j < wordLengthCount.length; j++) { 
		CharCount += j * wordLengthCount[j]; 
		} 

		meanLength = (double) CharCount / (double) WordCount; 

		return meanLength+1; 
		} 
	
	public static void printArray(int[] builtText) {
		for(int j=0; j<builtText.length;j++)
		 {
		     System.out.println("Word Length: "+(j+1)+" Amount: "+builtText[j]);
		 }
	}
	
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
    /*  --------------METHODS-------------- */
	
	
	
	
	
	
    public void init() {

        setSize(500, 500);

        textBoxCaption = new Label("Please enter your text here:");
        inputField = new TextField(50);
        analyseButton = new Button("Submit");
        resetButton = new Button("Restart");
        add(analyseButton);
        add(textBoxCaption);
        add(inputField);
        analyseButton.addActionListener(this);
        add(resetButton);
        resetButton.addActionListener(this);
    }
    
    public void paint(Graphics g) {
        g.drawString("BWD", 450, 490);    // Puts my signature in the bottom corner
        inputField.setText("");
        inputText = ("");
        g.drawLine(50, 450, 460, 450);//Paints  x-axis
        g.drawLine(50, 450, 50, 100);//Paints the y-axis
    }
    
    
    
    public void actionPerformed(ActionEvent e) {
        
    	
        if (e.getSource() == analyseButton) {
        	inputText = inputField.getText();
            lengthCountArray = buildLengthsAndCounts(inputText);
            System.out.println(lengthCountArray[0]);
        }
    	
    	if (e.getSource() == resetButton) {
            inputField.setText("");    //Resetting the datafields when reset is pressed.
            inputText = ("");
	            
				for(int j=0; j<lengthCountArray.length;j++) {
					lengthCountArray[j] = 0;
	            }
				System.out.println(lengthCountArray[0]);
        }
    	
    	
    }
}