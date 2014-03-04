package java_assignment;
import java.applet.Applet; 
import java.awt.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 

import static java.awt.Color.white; 

public class TextAnalysisApplet extends Applet implements ActionListener { 

// Pre: 
// Post: lists global gui parts 
TextField InputBox; 
Button AnalyzeButton, ResetButton; 
// Pre: 
// Post: lists global variables 
// boolean turns true if there has already been an analysis 
boolean NeedsReset; 
// global text is the text the user inputs into the text field 
String GlobalText; 

// Adds GUI parts 
public void init() { 

// Pre: 
// Post: adds label to text input field 
Label InputBoxLabel; 
InputBoxLabel = new Label("Please enter your text or a file name and press enter."); 
add(InputBoxLabel); 

// Pre: 
// Post: adds text input area 
InputBox = new TextField(" ", 50); 
add(InputBox); 
InputBox.addActionListener(this); 

// Pre: 
// Post: adds analyze button 
AnalyzeButton = new Button("Analyze"); 
add(AnalyzeButton); 
AnalyzeButton.addActionListener(this); 

// Pre: 
// Post: adds reset button 
ResetButton = new Button("Reset"); 
add(ResetButton); 
ResetButton.addActionListener(this); 
} 

// Sets size and initialises global variables 
public void start() { 

// Pre: 
// Post: sets size and background colour 
setSize(405, 600); 
setBackground(white); 

// Pre: variables made 
// Post: initialises variables 
NeedsReset = false; 
GlobalText = " "; 

} 

// Paints initials in bottom right 
public void paint(Graphics g) { 

// Pre: 
// Post: Paints B bottom right 
int xB[] = {290, 310, 320, 320, 300, 300, 310, 310, 320, 320, 310, 320, 310, 300, 300, 310, 310, 320, 320, 310, 290, 290}; 
int yB[] = {535, 535, 545, 545, 545, 555, 555, 545, 545, 555, 565, 575, 575, 575, 585, 585, 575, 575, 585, 595, 595, 535}; 
g.fillPolygon(xB, yB, xB.length); 

// Pre: 
// Post: Paints . bottom right 
int xDot[] = {330, 340, 340, 330, 330}; 
int yDot[] = {585, 585, 595, 595, 585}; 
g.fillPolygon(xDot, yDot, xDot.length); 

// Pre: 
// Post: Paints M bottom right 
int xM[] = {350, 360, 370, 380, 390, 400, 400, 390, 390, 380, 370, 360, 360, 350, 350}; 
int yM[] = {535, 535, 545, 545, 535, 535, 595, 595, 555, 565, 565, 555, 595, 595, 535}; 
g.fillPolygon(xM, yM, xM.length); 

} 

// Checks source of action and runs method 
public void actionPerformed(ActionEvent e) { 

if (e.getSource() == ResetButton) { 
// reset button clicked 
Reset(); 
} else if (e.getSource() == InputBox) { 
// text box typed in 
GlobalText = e.getActionCommand(); 
} else if (e.getSource() == AnalyzeButton) { 

if (!NeedsReset) { 
// if its the first analysis 
if (GlobalText.equals(" ") || GlobalText.equals("")) { 
// if nothing was entered 
PrintOutText("you did not enter any text \nplease reset and try again \n(Don't forget to press enter)", 10, 100); 
NeedsReset = true; 
} else 
// analyze button clicked 
Analyze(GlobalText); 
} else { 
PrintOutText("Please reset before analyzing again", 10, 575); 
} 
} 
} 

// Runs when stopping program 
public void stop() { 
} 

// Runs when ending program 
public void destroy() { 
} 

// Clears screen back to original state 
public void Reset() { 
start(); 
InputBox.setText(" "); 
repaint(); 
} 

// Displays information when analyze button clicked 
public void Analyze(String WorkingText) { 

NeedsReset = true; 

// Pre: WorkingText 
// Post: displays graph of LetterStats 

// if text has no numbers draw LetterStats 
if (!GlobalText.matches(".*\\d+.*")){ 
DrawGraph(LetterStats(WorkingText), 200, 250, 380, 350, "letter frequency"); 
} 

// Pre: WorkingText 
// Post prints out WordStats as text 
PrintOutText(TextOutput(WordStats(WorkingText)), 10, 100); 

// Pre: input string, WordStats possible 
// Post: displays a graph of WordStats of the string 
DrawGraph(WordStats(WorkingText), 200, 500, 380, 600, "word length frequency"); 

// Round the mean to one decimal place 

// Pre: WordStats 
// Post: get mean word length & make double into string 
String OutputDouble = Double.toString(MeanWordLength(WordStats(WorkingText))); 

// Pre: mean word length double 
// Post: find where . is and add 2 
int DecimalPointIndex = OutputDouble.indexOf(".") + 2; 

// Pre: found where . is and added 2 
// Post: get the part before the index 
OutputDouble = OutputDouble.substring(0, DecimalPointIndex); 

PrintOutText("The mean word length is " + OutputDouble, 10, 550); 
} 

// Finds the longest word in an array of words 
public int LongestWord(String[] WorkingWordArray) { 

int LongestWord = 0; 

// Pre: formatted word array 
// Post: finds longest word 
for (String Word : WorkingWordArray) { 
if (Word.length() > LongestWord) { 
LongestWord = Word.length(); 
} 
} 
return LongestWord; 
} 

// Finds the largest integer in an array of integers 
public int HighestInt(int[] WorkingIntArray) { 

int HighestInt = 0; 

// Pre: formatted int array 
// Post: finds the max value in the array 
for (int Int : WorkingIntArray) { 
if (Int > HighestInt) { 
HighestInt = Int; 
} 
} 
return HighestInt; 
} 

// Removes punctuation and numbers from a string and splits it into a word array based on spaces 
public String[] FormatText(String WorkingText) { 

String[] WorkingWordArray; 

// Pre: given working text 
// Post: replaces non A-Z / a-z / 0-9 with space 
WorkingText = WorkingText.replaceAll("\\W", " "); 

// Pre: given working text (punctuation removed) 
// Post: creates array with each word (split at space) 
WorkingWordArray = WorkingText.split(" "); 

return WorkingWordArray; 
} 

// Turns an integer array into text output 
public String TextOutput(int WordStats[]) { 
int i; 
String Indent = " ", PluralAddition, Output = "There are: "; 

// Pre: wordStats array given 
// Post: string ready for print 
for (i = 1; i < WordStats.length; i++) { 

// Pre: WordStats & PluralAddition 
// Post: if there is one word don't pluralise 
if (WordStats[i] == 1) { 
PluralAddition = ""; 
} else PluralAddition = "s"; 

Output = Output + "\n" + Indent + WordStats[i] + " word" + PluralAddition + " of length " + i; 
} 
return Output; 
} 

// Draws lines of text based on \n 
public void PrintOutText(String WorkingText, int X, int Y) { 
Graphics g = getGraphics(); 
String Lines[]; 

// pre: formatted string using \n for new line 
// Post: array containing each line 
Lines = WorkingText.split("\n"); 

// Pre: array containing each line 
// Post: displays each line 15 apart 
for (String Line : Lines) { 
g.drawString(Line, X, Y); 
Y += 15; 
} 
} 

// Finds the average length of words in a string array 
public double MeanWordLength(int WordStats[]) { 
int WordCount = 0, CharCount = 0, i; 
double MeanLength; 

// Pre: WordStats array 
// Post: word count calculated 
for (i = 1; i < WordStats.length; i++) { 
WordCount += WordStats[i]; 
} 

// Pre: WordStats array 
// Post: character count calculated 
for (i = 1; i < WordStats.length; i++) { 
CharCount += i * WordStats[i]; 
} 

// Pre: word and char count 
// Post: mean word length 
MeanLength = (double) CharCount / (double) WordCount; 

return MeanLength; 
} 

// Draws a graph based on an int array 
public void DrawGraph(int Stats[], int StartX, int StartY, int EndX, int EndY, String Description) { 

// Pre: 
// Post: set up variables 
Graphics g = getGraphics(); 
int X, i = 1; 

// start X/Y set where the graph will be displayed 
int ChartXSize = (EndX - StartX), ChartYSize = (EndY - StartY); 

// calculate how big each 'chunk' of the graph will be depending on the size of the array values 
int BarXSize = (ChartXSize / (Stats.length - 1)); 
int BarYSize = -(ChartYSize / (HighestInt(Stats))); 

// Pre: variables set 
// Post: display graph information 
for (X = StartX; X < EndX; X += BarXSize) { 
if (i <= (Stats.length - 1)) { 
X++; 
g.fillRect(X, StartY, BarXSize, BarYSize * Stats[i++]); 
} 
} 

// Pre: variables set (graph information should be drawn but not needed) 
// Post: add graph axis 
g.drawLine(StartX, StartY, EndX + 15, StartY); 

// Pre: 
// Post: draw label 
PrintOutText(Description, StartX, StartY + 15); 
} 

// Counts the word length frequency of a string array 
public int[] WordStats(String WorkingText) { 

// Pre: text input 
// Post: global text set to word counts 

// Pre: UnFormatted string 
// Post: punctuation removed and each word put into array 
String[] WorkingWordArray = FormatText(WorkingText); 

// Pre: WorkingWordArray 
// Post: WordStats array made as long as the longest word in the WorkingWordArray 
int[] WordStats = new int[LongestWord(WorkingWordArray) + 1]; 


// Pre: WordStats & WorkingWordArray 
// Post: counts the number of occurrences of each word length 
for (String Word : WorkingWordArray) { 
WordStats[Word.length()]++; 
} 
return WordStats; 
} 

// Counts the number of times each letter appears in a string 
public int[] LetterStats(String WorkingText) { 

int[] LetterStats = new int[27]; 

// Pre: formatted string 
// Post: Letter stats 
int i; 

// add one to the letter count for each letter in the string 
for (i = 0; i < WorkingText.length(); i++) { 
switch (WorkingText.toLowerCase().charAt(i)) { 
case 'a': 
LetterStats[1]++; 
break; 
case 'b': 
LetterStats[2]++; 
break; 
case 'c': 
LetterStats[3]++; 
break; 
case 'd': 
LetterStats[4]++; 
break; 
case 'e': 
LetterStats[5]++; 
break; 
case 'f': 
LetterStats[6]++; 
break; 
case 'g': 
LetterStats[7]++; 
break; 
case 'h': 
LetterStats[8]++; 
break; 
case 'i': 
LetterStats[9]++; 
break; 
case 'j': 
LetterStats[10]++; 
break; 
case 'k': 
LetterStats[11]++; 
break; 
case 'l': 
LetterStats[12]++; 
break; 
case 'm': 
LetterStats[13]++; 
break; 
case 'n': 
LetterStats[14]++; 
break; 
case 'o': 
LetterStats[15]++; 
break; 
case 'p': 
LetterStats[16]++; 
break; 
case 'q': 
LetterStats[17]++; 
break; 
case 'r': 
LetterStats[18]++; 
break; 
case 's': 
LetterStats[19]++; 
break; 
case 't': 
LetterStats[20]++; 
break; 
case 'u': 
LetterStats[21]++; 
break; 
case 'v': 
LetterStats[22]++; 
break; 
case 'w': 
LetterStats[23]++; 
break; 
case 'x': 
LetterStats[24]++; 
break; 
case 'y': 
LetterStats[25]++; 
break; 
case 'z': 
LetterStats[26]++; 
break; 
default: 
break; 
} 
} 
return LetterStats; 
} 
}