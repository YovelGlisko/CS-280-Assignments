/**
 * Yovel Glisko
 * Dec 4, 2020
**/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator extends JFrame implements ActionListener
  {
	// The basis for this code is Display 17.19 which the instructions stated were fine to use. As a result, I don't really think I should 
	// comment on all of those lines so I will focus my comments on how I took that simple calculator and fleshed it out to what it is here.
      public static final int WIDTH = 900;
      public static final int HEIGHT = 225;
      public static final int NUMBER_OF_DIGITS = 30;
      // here I simply modified the text fields and added my own JLabels to use later for my non-editable text boxes with labels next to them
      private JLabel resultLabel; 
      private JLabel operandLabel;
      private JTextField resultField;
      private JTextField operandField;
      private double result = 0.0;
      // here I also create two variables, count and tempNum to store the number of operations since reset or startup and the operand being inputted character by character
      private int count = 0;
      private String tempNum = "";

      public static void main(String[] args) {
          Calculator aCalculator = new Calculator();
          aCalculator.setVisible(true);
      }

      public Calculator()
      {
          setTitle("Simplified Calculator");
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setSize(WIDTH, HEIGHT);
          setLayout(new BorderLayout());
          // here I use the initial way the Calculator creates its text fields to create my operand Label followed by a corresponding text field. I do the same for the results.
          JPanel textPanel = new JPanel();
          textPanel.setLayout(new FlowLayout());
          operandLabel = new JLabel("Operand");
          operandLabel.setBackground(Color.WHITE);
          textPanel.add(operandLabel);
          operandField = new JTextField("Operand Will Appear Here", NUMBER_OF_DIGITS);
          operandField.setBackground(Color.WHITE);
          // I use the setEditable method to make sure the user cannot type in these boxes. I do the same for the results.
          operandField.setEditable(false);
          textPanel.add(operandField);
          resultLabel = new JLabel("Result");
          resultLabel.setBackground(Color.WHITE);
          textPanel.add(resultLabel);
          resultField = new JTextField("Result Will Appear Here", NUMBER_OF_DIGITS);
          resultField.setBackground(Color.WHITE);
          resultField.setEditable(false);
          textPanel.add(resultField);
          add(textPanel, BorderLayout.NORTH);
          JPanel buttonPanel = new JPanel();
          // here is where I start making some tweaks to the buttons the user presses. I start with changing the background color for fun.
          buttonPanel.setBackground(new Color(204,154,237));
          buttonPanel.setLayout(new FlowLayout());
          JButton addButton = new JButton("+"); 
          addButton.addActionListener(this);
          buttonPanel.add(addButton); 
          JButton subtractButton = new JButton("�"); 
          subtractButton.addActionListener(this);
          buttonPanel.add(subtractButton); 
          // here I take the same method for creating the + and - buttons for creating my * and / buttons as well as the Clear button.
          JButton multiplyButton = new JButton("*"); 
          multiplyButton.addActionListener(this);
          buttonPanel.add(multiplyButton); 
          JButton divideButton = new JButton("/"); 
          divideButton.addActionListener(this);
          buttonPanel.add(divideButton); 
          JButton resetButton = new JButton("Reset"); 
          resetButton.addActionListener(this);
          buttonPanel.add(resetButton);
          JButton clearButton = new JButton("Clear"); 
          clearButton.addActionListener(this);
          buttonPanel.add(clearButton);
          // here I create my own JPanel for specifically the numbers 0-9 and the decimal place as input buttons. I create a 4 row by 3 column GridLayout to house it all
          JPanel numPanel = new JPanel();
          numPanel.setBackground(new Color(254,184,255));
          GridLayout numLayout = new GridLayout(4, 3);
          // after creating the GridLayout I set the JPanel to it and start making all my buttons in the order found on a stanard calculator left to right then top to bottom.
          // this is all again the same as any other button.
          numPanel.setLayout(numLayout);
          JButton sevenButton = new JButton("7");
          sevenButton.addActionListener(this);
          numPanel.add(sevenButton);
          JButton eightButton = new JButton("8");
          eightButton.addActionListener(this);
          numPanel.add(eightButton);
          JButton nineButton = new JButton("9");
          nineButton.addActionListener(this);
          numPanel.add(nineButton);
          JButton fourButton = new JButton("4");
          fourButton.addActionListener(this);
          numPanel.add(fourButton);
          JButton fiveButton = new JButton("5");
          fiveButton.addActionListener(this);
          numPanel.add(fiveButton);
          JButton sixButton = new JButton("6");
          sixButton.addActionListener(this);
          numPanel.add(sixButton);
          JButton oneButton = new JButton("1");
          oneButton.addActionListener(this);
          numPanel.add(oneButton);
          JButton twoButton = new JButton("2");
          twoButton.addActionListener(this);
          numPanel.add(twoButton);
          JButton threeButton = new JButton("3");
          threeButton.addActionListener(this);
          numPanel.add(threeButton);
          JButton decimalButton = new JButton(".");
          decimalButton.addActionListener(this);
          numPanel.add(decimalButton);
          JButton zeroButton = new JButton("0");
          zeroButton.addActionListener(this);
          numPanel.add(zeroButton);
          

          add(buttonPanel, BorderLayout.CENTER);
          // I set my numPanel to be at the bottom as that feels right.
          add(numPanel, BorderLayout.SOUTH);
      }

      public void actionPerformed(ActionEvent e)
      {
          try
          {
              assumingCorrectNumberFormats(e);
          }
          catch (NumberFormatException e2)
          {
              operandField.setText("Error: Reenter Number.");
          // here I catch my DivisionByZeroException that will come up later and give a simply error message in the operand text field.
          } catch (DivisionByZeroException e3) {
        	  operandField.setText("Error: Attempted to Divide By Zero");
          }
      }

      //Throws NumberFormatException.
      public void assumingCorrectNumberFormats(ActionEvent e) throws DivisionByZeroException
      {
          String actionCommand = e.getActionCommand();
          if (actionCommand.equals("+"))
          {
        	  // here is where my changes really start to take place. I start tracking my counts to check how many operations have been done and using 
        	  // tempNum for the operand before resetting it
              result = result + stringToDouble(tempNum);
              tempNum = "";
              count++;
              // I also clear the operand text field.
              operandField.setText("");
              resultField.setText(Double.toString(result));
          }
          else if (actionCommand.equals("�"))
          {
        	  // this is more of the same
              result = result - stringToDouble(tempNum);
              tempNum = "";
              count++;
              operandField.setText("");
              resultField.setText(Double.toString(result));
          }
          else if (actionCommand.equals("*"))
          {
        	  // here I have to create my own function, multiplication. with the base result value being 0 it is impossible to use the prior format in a user friendly way.
        	  // this is why I have my count. if it is the first operation, meaning the 0 is there unintended by the user, result is set to 1 to allow for multiplication to work intuitively.
        	  if(count == 0) {
        		  result = 1;
        	  }
        	  // the rest here is more of the same
        	  result = result * stringToDouble(tempNum);
              tempNum = "";
              count++;
              operandField.setText("");
              resultField.setText(Double.toString(result));
          }

          else if (actionCommand.equals("/"))
          {
        	  // division here gets interesting. I have to do the same count thing for the first operation but I cannot simply set the result to 1. I set it to the 2nd power of the operand so the result
        	  // when the operand is divided by it will yield the operand itself allowing division to work extremely intuitively.
        	  if(count == 0) {
        		  result = Math.pow(stringToDouble(tempNum), 2);
        	  }
        	  // here is also where I have to use my DivisionByZeroException. I check for the operand being close enough to zero and if it is I
        	  // set the operand and field to nothing and throw the exception.
        	  if(stringToDouble(tempNum) < 1.0E-10 && stringToDouble(tempNum) > -1.0E-10) {
        		  operandField.setText("");
        		  tempNum = "";
        		  throw new DivisionByZeroException();
        	  }
        	  // the rest here is more of the same as before.
        	  result = result / stringToDouble(tempNum) ;
              tempNum = "";
              count++;
              operandField.setText("");
              resultField.setText(Double.toString(result));
          }
          else if (actionCommand.equals("Reset"))
          {
              result = 0.0;
              // here after a reset I set count to 0 since after resetting it is unintuitive for the value of 0 to be inserted there automatically as the base result and this solves that.
              count = 0;
              resultField.setText("0.0");
          }
          else if (actionCommand.equals("Clear"))
          {
        	  // here I check for my new "clear" button which simply sets the operand and operand field to nothing.
              tempNum = "";
              operandField.setText("");
          // following this is the onslaught of numbers and the decimal point. basically I just add the string of the number or decimal to the existing string of the current operand.
          // since later this will converted to a double this is entirely fine. I also set the operand field to show the current string after each change.
          } else if(actionCommand.equals("0")) {
        	  tempNum += "0";
        	  operandField.setText(tempNum);
          } else if(actionCommand.equals("1")) {
        	  tempNum += "1";
        	  operandField.setText(tempNum);
          } else if(actionCommand.equals("2")) {
        	  tempNum += "2";
        	  operandField.setText(tempNum);
          } else if(actionCommand.equals("3")) {
        	  tempNum += "3";
        	  operandField.setText(tempNum);
          } else if(actionCommand.equals("4")) {
        	  tempNum += "4";
        	  operandField.setText(tempNum);
          } else if(actionCommand.equals("5")) {
        	  tempNum += "5";
        	  operandField.setText(tempNum);
          } else if(actionCommand.equals("6")) {
        	  tempNum += "6";
        	  operandField.setText(tempNum);
          } else if(actionCommand.equals("7")) {
        	  tempNum += "7";
        	  operandField.setText(tempNum);
          } else if(actionCommand.equals("8")) {
        	  tempNum += "8";
        	  operandField.setText(tempNum);
          } else if(actionCommand.equals("9")) {
        	  tempNum += "9";
        	  operandField.setText(tempNum);
          } else if(actionCommand.equals(".")) {
        	  tempNum += ".";
        	  operandField.setText(tempNum);
          }
          else
        	  operandField.setText("Unexpected error.");
      }
      //Throws NumberFormatException.
      private static double stringToDouble(String stringObject)
      {
          return Double.parseDouble(stringObject.trim());
      }
  }