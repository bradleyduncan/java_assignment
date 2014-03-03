package java_assignment;

// Bradley Duncan

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public strictfp class TEXTANALYSE extends Applet implements ActionListener {

    Label textBoxCaption;    //Caption for the text box
    TextField inputField; //Input field
    Button analyseButton;   //Analyse button
    Button resetButton;      //Reset button
    String inputText;
    int[] stringLength = {1,2,3,4,5,6,7,8,9};
    double MWL, StringCount, SLB1, SLB2, SLB3, SLB4, SLB5, SLB6, SLB7, SLB8, SLB9, SLB11, SLB22, SLB33, SLB44, SLB55, SLB66, SLB77, SLB88, SLB99;//used for working out coordinates


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
        g.drawString("BWD", 425, 340);    // Puts my signature in the bottom corner
        inputField.setText("");
        inputText = ("");
        StringCount = 0;
        g.drawLine(50, 300, 410, 300);     //Drawing the x-axis
        g.drawLine(50, 300, 50, 50);       //Drawing the y-axis
        g.setColor(Color.red);                            //Setting the bar color
        g.drawRect(50, (int) SLB11, 40, (int) SLB1); //Drawing the bar
        g.setColor(Color.black);                   //Setting the text color
        g.drawString("1", 70, 315);                 //Giving values to the x-axis
        g.drawString("" + stringLength[1] + "", 40, (int) SLB11);      //Displaying the frequency of the word on the y-axis
        g.setColor(Color.orange);
        g.drawRect(90, (int) SLB22, 40, (int) SLB2); //stringLength2
        g.setColor(Color.black);
        g.drawString("2", 110, 315);
        g.drawString("" + stringLength[2] + "", 40, (int) SLB22);
        g.setColor(Color.yellow);
        g.drawRect(130, (int) SLB33, 40, (int) SLB3); //stringLength3
        g.setColor(Color.black);
        g.drawString("3", 150, 315);
        g.drawString("" + stringLength[3] + "", 40, (int) SLB33);
        g.setColor(Color.green);
        g.drawRect(170, (int) SLB44, 40, (int) SLB4); //stringLength4
        g.setColor(Color.black);
        g.drawString("4", 190, 315);
        g.drawString("" + stringLength[4] + "", 40, (int) SLB44);
        g.setColor(Color.blue);
        g.drawRect(210, (int) SLB55, 40, (int) SLB5); //stringLength5
        g.setColor(Color.black);
        g.drawString("5", 230, 315);
        g.drawString("" + stringLength[5] + "", 40, (int) SLB55);
        g.setColor(Color.red);
        g.drawRect(250, (int) SLB66, 40, (int) SLB6); //stringLength6
        g.setColor(Color.black);
        g.drawString("6", 270, 315);
        g.drawString("" + stringLength[6] + "", 40, (int) SLB66);
        g.setColor(Color.orange);
        g.drawRect(290, (int) SLB77, 40, (int) SLB7); //stringLength7
        g.setColor(Color.black);
        g.drawString("7", 310, 315);
        g.drawString("" + stringLength[7] + "", 40, (int) SLB77);
        g.setColor(Color.yellow);
        g.drawRect(330, (int) SLB88, 40, (int) SLB8); //stringLength8
        g.setColor(Color.black);
        g.drawString("8", 350, 315);
        g.drawString("" + stringLength[8] + "", 40, (int) SLB88);
        g.setColor(Color.green);
        g.drawRect(370, (int) SLB99, 40, (int) SLB9); //stringLength9
        g.setColor(Color.black);
        g.drawString("9", 390, 315);
        g.drawString("" + stringLength[9] + "", 40, (int) SLB99);
        g.drawString("Mean word length is: " + MWL, 200, 330);
    }

    public void actionPerformed(ActionEvent e) {
        inputText = inputField.getText();    //Sets a variable as the inputted text
        inputText = inputText.replaceAll("\\p{P}", ""); //Removes punctuation from the text
        for (String retval : inputText.split(" ")) {   //Splits the string by spaces
            StringCount += 1;      //Adds 1 to the string count
            if (retval.length() == 1)      
            	stringLength[1] += 1;
            if (retval.length() == 2)
            	stringLength[2] += 1;
            if (retval.length() == 3)
            	stringLength[3] += 1;
            if (retval.length() == 4)
            	stringLength[4] += 1;
            if (retval.length() == 5)
            	stringLength[5] += 1;
            if (retval.length() == 6)
            	stringLength[6] += 1;
            if (retval.length() == 7)
            	stringLength[7] += 1;
            if (retval.length() == 8)
            	stringLength[8] += 1;
            if (retval.length() == 9)
            	stringLength[9] += 1;
            MWL = ((stringLength[9] * 9) + (stringLength[8] * 8) + (stringLength[7] * 7) + (stringLength[6] * 6) + (stringLength[5] * 5) + (stringLength[4] * 4) + (stringLength[3] * 3) + (stringLength[2] * 2) + (stringLength[1] * 1)) / StringCount;
            //^^^Working out the Mean Word Length
            SLB1 = ((250 / StringCount) * stringLength[1]);  //Working out the coordinates of each bar
            SLB11 = (300 - SLB1);
            SLB1 = (300 - SLB11);

            SLB2 = ((250 / StringCount) * stringLength[2]);
            SLB22 = (300 - SLB2);
            SLB2 = (300 - SLB22);

            SLB3 = ((250 / StringCount) * stringLength[3]);
            SLB33 = (300 - SLB3);
            SLB3 = (300 - SLB33);

            SLB4 = ((250 / StringCount) * stringLength[4]);
            SLB44 = (300 - SLB4);
            SLB4 = (300 - SLB44);

            SLB5 = ((250 / StringCount) * stringLength[5]);
            SLB55 = (300 - SLB5);
            SLB5 = (300 - SLB55);

            SLB6 = ((250 / StringCount) * stringLength[6]);
            SLB66 = (300 - SLB6);
            SLB6 = (300 - SLB66);

            SLB7 = ((250 / StringCount) * stringLength[7]);
            SLB77 = (300 - SLB7);
            SLB7 = (300 - SLB77);

            SLB8 = ((250 / StringCount) * stringLength[8]);
            SLB88 = (300 - SLB8);
            SLB8 = (300 - SLB88);

            SLB9 = ((250 / StringCount) * stringLength[9]);
            SLB99 = (300 - SLB9);
            SLB9 = (300 - SLB99);

        }
        if (e.getSource() == resetButton) {
            inputField.setText("");    //Resetting the datafields when reset is pressed.
            inputText = ("");
            stringLength[1] = 0;
            stringLength[2] = 0;
            stringLength[3] = 0;
            stringLength[4] = 0;
            stringLength[5] = 0;
            stringLength[6] = 0;
            stringLength[7] = 0;
            stringLength[8] = 0;
            stringLength[9] = 0;
            MWL = 0;
            StringCount = 0;
        }
        repaint(); //Re-painting the applet
    }
}


