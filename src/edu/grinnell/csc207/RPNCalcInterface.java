package edu.grinnell.csc207;

import java.util.Stack;

public class RPNCalcInterface
{
  /**
   * @pre Accepts inputs of one character per line
   * @pre Only accepts commands from the "List of Commands" printed
   * @post Returns the result from the RPN calculation or command
   * 
   * @throws Exception
   */
  public static void main(String[] args)
    throws Exception
  {
    java.io.PrintWriter pen = new java.io.PrintWriter(System.out, true);
    java.io.InputStreamReader istream =
        new java.io.InputStreamReader(System.in);
    java.io.BufferedReader eyes = new java.io.BufferedReader(istream);

    String input;
    Stack<Integer> output = new Stack<Integer>();
    pen.println("List of Commands: ");
    pen.println("p");
    pen.println("s");
    pen.println("c");
    pen.println("q");
    pen.println("+ , - , * , / , %");
    pen.println("or enter an Integer");

    while (true)
      {
        // pen.println("Enter: ");
        input = eyes.readLine();

        if (input.charAt(0) == 'p')
          {
            pen.print(output.peek());
            pen.println();
          }// if
        else if (input.charAt(0) == 's')
          {
            Object[] items = output.toArray();
            for (int i = 0; i < items.length; i++)
              {
                pen.println(items[i]);
              }// for
          }// else if
        else if (input.charAt(0) == 'c')
          {
            while (!output.empty())
              {
                output.pop();
              }// while
          }// else if
        else if (input.charAt(0) == 'q')
          {
            output = new Stack<Integer>();
            break;
          }// else if
        else if ((input.charAt(0) == '*') || (input.charAt(0) == '/')
                 || (input.charAt(0) == '-') || (input.charAt(0) == '+')
                 || (input.charAt(0) == '%'))
          {
            RPNCalc.evaluate(input.charAt(0), output);
          }// else if
        else
          {
            output.push(Integer.parseInt(input));
          }// else
      }// while
    return;
  }// main()
}// class RPNCalcInterface
