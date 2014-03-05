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
    
    public void init() {

        setSize(500, 500);

        textBoxCaption = new Label("Please enter your text here:");
        inputField = new TextField(50);
        analyseButton = new Button("Submit");
        resetButton = new Button("Restart");
        add(analyseButton);
        add(inputField);
        add(textBoxCaption);
        analyseButton.addActionListener(this);
        add(resetButton);
        resetButton.addActionListener(this);
    }
}