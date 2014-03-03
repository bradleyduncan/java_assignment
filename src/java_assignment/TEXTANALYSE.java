package java_assignment;

// Bradley Duncan

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

// Used strictfp to ensure that the application is WORA (Write-Once-Run-Anywhere)
public strictfp class TEXTANALYSE extends Applet implements ActionListener {

    Label textBoxCaption;    //Caption for the text box
    TextField inputField; //Input field
    Button analyseButton;   //Analyse button
    Button resetButton;      //Reset button
    String inputText;
    int stringLength1, stringLength2, stringLength3, stringLength4, stringLength5, stringLength6, stringLength7, stringLength8, stringLength9;    //Variables with the string lengths stored for future comparison
    double meanLength, stringCounter, lengthBar1, lengthBar2, lengthBar3, lengthBar4, lengthBar5, lengthBar6, lengthBar7, lengthBar8, lengthBar9, lengthBar11, lengthBar22, lengthBar33, lengthBar44, lengthBar55, lengthBar66, lengthBar77, lengthBar88, lengthBar99;//used for working out coordinates


    public void init() {

        setSize(450, 350);

        textBoxCaption = new Label("Please enter your text here:");
        inputField = new TextField(35);
        analyseButton = new Button("Submit");
        resetButton = new Button("Restart");
        add(analyseButton);
        add(inputField);
        add(textBoxCaption);
        analyseButton.addActionListener(this);
        add(resetButton);
        resetButton.addActionListener(this);
    }

    public void paint(Graphics g) {
        g.drawString("BWD", 410, 340);    // Puts my signature in the bottom corner
        inputField.setText("");
        inputText = ("");
        stringCounter = 0;
        g.drawLine(50, 300, 410, 300);     //Drawing the x-axis
        g.drawLine(50, 300, 50, 50);       //Drawing the y-axis
        g.setColor(Color.red);                            //Setting the bar color
        g.drawRect(50, (int) lengthBar11, 40, (int) lengthBar1); //Drawing the bar
        g.setColor(Color.black);                   //Setting the text color
        g.drawString("1", 70, 315);                 //Giving values to the x-axis
        g.drawString("" + stringLength1 + "", 40, (int) lengthBar11);      //Displaying the frequency of the word on the y-axis
        g.setColor(Color.orange);
        g.drawRect(90, (int) lengthBar22, 40, (int) lengthBar2); //stringLength2
        g.setColor(Color.black);
        g.drawString("2", 110, 315);
        g.drawString("" + stringLength2 + "", 40, (int) lengthBar22);
        g.setColor(Color.yellow);
        g.drawRect(130, (int) lengthBar33, 40, (int) lengthBar3); //stringLength3
        g.setColor(Color.black);
        g.drawString("3", 150, 315);
        g.drawString("" + stringLength3 + "", 40, (int) lengthBar33);
        g.setColor(Color.green);
        g.drawRect(170, (int) lengthBar44, 40, (int) lengthBar4); //stringLength4
        g.setColor(Color.black);
        g.drawString("4", 190, 315);
        g.drawString("" + stringLength4 + "", 40, (int) lengthBar44);
        g.setColor(Color.blue);
        g.drawRect(210, (int) lengthBar55, 40, (int) lengthBar5); //stringLength5
        g.setColor(Color.black);
        g.drawString("5", 230, 315);
        g.drawString("" + stringLength5 + "", 40, (int) lengthBar55);
        g.setColor(Color.red);
        g.drawRect(250, (int) lengthBar66, 40, (int) lengthBar6); //stringLength6
        g.setColor(Color.black);
        g.drawString("6", 270, 315);
        g.drawString("" + stringLength6 + "", 40, (int) lengthBar66);
        g.setColor(Color.orange);
        g.drawRect(290, (int) lengthBar77, 40, (int) lengthBar7); //stringLength7
        g.setColor(Color.black);
        g.drawString("7", 310, 315);
        g.drawString("" + stringLength7 + "", 40, (int) lengthBar77);
        g.setColor(Color.yellow);
        g.drawRect(330, (int) lengthBar88, 40, (int) lengthBar8); //stringLength8
        g.setColor(Color.black);
        g.drawString("8", 350, 315);
        g.drawString("" + stringLength8 + "", 40, (int) lengthBar88);
        g.setColor(Color.green);
        g.drawRect(370, (int) lengthBar99, 40, (int) lengthBar9); //stringLength9
        g.setColor(Color.black);
        g.drawString("9", 390, 315);
        g.drawString("" + stringLength9 + "", 40, (int) lengthBar99);
        g.drawString("Mean word length is: " + meanLength, 200, 330);
    }

    public void actionPerformed(ActionEvent e) {
        inputText = inputField.getText();    //Sets a variable as the inputted text
        inputText = inputText.replaceAll("\\p{P}", ""); //Removes punctuation from the text
        for (String rectangleVariable : inputText.split(" ")) {   //Splits the string by spaces
            stringCounter += 1;      //Adds 1 to the string count
            if (rectangleVariable.length() == 1)      
                stringLength1 += 1;
            if (rectangleVariable.length() == 2)
                stringLength2 += 1;
            if (rectangleVariable.length() == 3)
                stringLength3 += 1;
            if (rectangleVariable.length() == 4)
                stringLength4 += 1;
            if (rectangleVariable.length() == 5)
                stringLength5 += 1;
            if (rectangleVariable.length() == 6)
                stringLength6 += 1;
            if (rectangleVariable.length() == 7)
                stringLength7 += 1;
            if (rectangleVariable.length() == 8)
                stringLength8 += 1;
            if (rectangleVariable.length() == 9)
                stringLength9 += 1;
            meanLength = ((stringLength9 * 9) + (stringLength8 * 8) + (stringLength7 * 7) + (stringLength6 * 6) + (stringLength5 * 5) + (stringLength4 * 4) + (stringLength3 * 3) + (stringLength2 * 2) + (stringLength1 * 1)) / stringCounter;
            //^^^Working out the Mean Word Length
            lengthBar1 = ((250 / stringCounter) * stringLength1);  //Working out the coordinates of each bar
            lengthBar11 = (300 - lengthBar1);
            lengthBar1 = (300 - lengthBar11);


            lengthBar2 = ((250 / stringCounter) * stringLength2);
            lengthBar22 = (300 - lengthBar2);
            lengthBar2 = (300 - lengthBar22);

            lengthBar3 = ((250 / stringCounter) * stringLength3);
            lengthBar33 = (300 - lengthBar3);
            lengthBar3 = (300 - lengthBar33);

            lengthBar4 = ((250 / stringCounter) * stringLength4);
            lengthBar44 = (300 - lengthBar4);
            lengthBar4 = (300 - lengthBar44);

            lengthBar5 = ((250 / stringCounter) * stringLength5);
            lengthBar55 = (300 - lengthBar5);
            lengthBar5 = (300 - lengthBar55);

            lengthBar6 = ((250 / stringCounter) * stringLength6);
            lengthBar66 = (300 - lengthBar6);
            lengthBar6 = (300 - lengthBar66);

            lengthBar7 = ((250 / stringCounter) * stringLength7);
            lengthBar77 = (300 - lengthBar7);
            lengthBar7 = (300 - lengthBar77);

            lengthBar8 = ((250 / stringCounter) * stringLength8);
            lengthBar88 = (300 - lengthBar8);
            lengthBar8 = (300 - lengthBar88);

            lengthBar9 = ((250 / stringCounter) * stringLength9);
            lengthBar99 = (300 - lengthBar9);
            lengthBar9 = (300 - lengthBar99);

        }
        if (e.getSource() == resetButton) {
            inputField.setText("");    //Resetting the datafields when reset is pressed.
            inputText = ("");
            stringLength1 = 0;
            stringLength2 = 0;
            stringLength3 = 0;
            stringLength4 = 0;
            stringLength5 = 0;
            stringLength6 = 0;
            stringLength7 = 0;
            stringLength8 = 0;
            stringLength9 = 0;
            meanLength = 0;
            stringCounter = 0;
        }
        repaint(); //Re-painting the applet
    }
}