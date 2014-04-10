package edu.grinnell.csc207;

import java.util.Stack;

public class RPNCalc
{
  public static void evaluate(int input, Stack<Integer> output)
  {
    int first = output.pop();
    int second = output.pop();
    int result = 0;

    if (input == '+')
      {
        result = first + second;
      }// if
    else if (input == '-')
      {
        result = second - first;
      }// else if
    else if (input == '/')
      {
        result = second / first;
      }// else if
    else if (input == '*')
      {
        result = first * second;
      }// else if
    else
      {
        result = second % first;
      }// else
    output.push(result);
  }// evaluate()

}// class RPNCalc
