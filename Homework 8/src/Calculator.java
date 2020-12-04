/**
 * Yovel Glisko
 * Dec 4, 2020
**/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator extends JFrame implements ActionListener
  {
      public static final int WIDTH = 900;
      public static final int HEIGHT = 225;
      public static final int NUMBER_OF_DIGITS = 30;

      private JLabel resultLabel; 
      private JLabel operandLabel;
      private JTextField resultField;
      private JTextField operandField;
      private double result = 0.0;
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

          JPanel textPanel = new JPanel();
          textPanel.setLayout(new FlowLayout());
          operandLabel = new JLabel("Operand");
          operandLabel.setBackground(Color.WHITE);
          textPanel.add(operandLabel);
          operandField = new JTextField("Operand Will Appear Here", NUMBER_OF_DIGITS);
          operandField.setBackground(Color.WHITE);
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
          buttonPanel.setBackground(new Color(204,154,237));
          buttonPanel.setLayout(new FlowLayout());
          JButton addButton = new JButton("+"); 
          addButton.addActionListener(this);
          buttonPanel.add(addButton); 
          JButton subtractButton = new JButton("—"); 
          subtractButton.addActionListener(this);
          buttonPanel.add(subtractButton); 
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
          JPanel numPanel = new JPanel();
          numPanel.setBackground(new Color(254,184,255));
          GridLayout numLayout = new GridLayout(4, 3);
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
              result = result + stringToDouble(tempNum);
              tempNum = "";
              count++;
              operandField.setText("");
              resultField.setText(Double.toString(result));
          }
          else if (actionCommand.equals("—"))
          {
              result = result - stringToDouble(tempNum);
              tempNum = "";
              count++;
              operandField.setText("");
              resultField.setText(Double.toString(result));
          }
          else if (actionCommand.equals("*"))
          {
        	  if(count == 0) {
        		  result = 1;
        	  }
        	  result = result * stringToDouble(tempNum);
              tempNum = "";
              count++;
              operandField.setText("");
              resultField.setText(Double.toString(result));
          }

          else if (actionCommand.equals("/"))
          {
        	  if(count == 0) {
        		  result = Math.pow(stringToDouble(tempNum), 2);
        	  }
        	  if(stringToDouble(tempNum) < 1.0E-10 && stringToDouble(tempNum) > -1.0E-10) {
        		  operandField.setText("");
        		  tempNum = "";
        		  throw new DivisionByZeroException();
        	  }
        	  result = result / stringToDouble(tempNum) ;
              tempNum = "";
              count++;
              operandField.setText("");
              resultField.setText(Double.toString(result));
          }
          else if (actionCommand.equals("Reset"))
          {
              result = 0.0;
              count = 0;
              resultField.setText("0.0");
          }
          else if (actionCommand.equals("Clear"))
          {
              tempNum = "";
              operandField.setText("");
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