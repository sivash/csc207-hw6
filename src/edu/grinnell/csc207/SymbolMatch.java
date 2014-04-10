package edu.grinnell.csc207;

import java.util.Stack;

public class SymbolMatch
{
  public static void match(String input)
  {
    int temp;
    Stack<Object> output = new Stack<Object>();
    for (int i = 0; i < input.length(); i++)
      {
        char ch = input.charAt(i);
        if ((ch == '{') || (ch == '(') || (ch == '<') || (ch == '[')
            || (ch == '`'))
          {
            output.push(i);
            output.push(ch);
          }// if
        else if (ch == '}')
          {
            if (output.isEmpty() == false)
              {
                if ((char) output.peek() == '{')
                  {
                    output.pop();
                    temp = (int) output.pop();
                    for (int j = 0; j < temp; j++)
                      {
                        System.out.print(" ");
                      }// for
                    System.out.print("{");
                    for (int j = 1; j < i - temp; j++)
                      {
                        System.out.print("-");
                      }// for
                    System.out.print("}");
                    System.out.println();
                  }// if
                else
                  {
                    for (int j = 0; j < i; j++)
                      {
                        System.out.print(" ");
                      }// for
                    System.out.println("}  <- UNMATCHED");
                  }// else
              }// if
            else
              {
                for (int j = 0; j < i; j++)
                  {
                    System.out.print(" ");
                  }// for
                System.out.println("}  <- UNMATCHED");
              }// else
          }// else if

        else if (ch == ')')
          {
            if (output.isEmpty() == false)
              {
                if ((char) output.peek() == '(')
                  {
                    output.pop();
                    temp = (int) output.pop();
                    for (int j = 0; j < temp; j++)
                      {
                        System.out.print(" ");
                      }// for
                    System.out.print("(");
                    for (int j = 1; j < i - temp; j++)
                      {
                        System.out.print("-");
                      }// for
                    System.out.print(")");
                    System.out.println();
                  }// if
                else
                  {
                    for (int j = 0; j < i; j++)
                      {
                        System.out.print(" ");
                      }// for
                    System.out.println(")  <- UNMATCHED");
                  }// else
              }// if
            else
              {
                for (int j = 0; j < i; j++)
                  {
                    System.out.print(" ");
                  }// for
                System.out.println(")  <- UNMATCHED");
              }// else
          }// else if
        else if (ch == '>')
          {
            if (output.isEmpty() == false)
              {
                if ((char) output.peek() == '<')
                  {
                    output.pop();
                    temp = (int) output.pop();
                    for (int j = 0; j < temp; j++)
                      {
                        System.out.print(" ");
                      }// for
                    System.out.print("<");
                    for (int j = 1; j < i - temp; j++)
                      {
                        System.out.print("-");
                      }// for
                    System.out.print(">");
                    System.out.println();
                  }// if
                else
                  {
                    for (int j = 0; j < i; j++)
                      {
                        System.out.print(" ");
                      }// for
                    System.out.println(">  <- UNMATCHED");
                  }// else
              } // if
            else
              {
                for (int j = 0; j < i; j++)
                  {
                    System.out.print(" ");
                  }// for
                System.out.println(">  <- UNMATCHED");
              }// else
          }// else if
        else if (ch == ']')
          {
            if (output.isEmpty() == false)
              {

                if ((char) output.peek() == '[')
                  {
                    output.pop();
                    temp = (int) output.pop();
                    for (int j = 0; j < temp; j++)
                      {
                        System.out.print(" ");
                      }// for
                    System.out.print("[");
                    for (int j = 1; j < i - temp; j++)
                      {
                        System.out.print("-");
                      }// for
                    System.out.print("]");
                    System.out.println();
                  }// if
                else
                  {
                    for (int j = 0; j < i; j++)
                      {
                        System.out.print(" ");
                      }// for
                    System.out.println("]  <- UNMATCHED");
                  }// else
              }// if
            else
              {
                for (int j = 0; j < i; j++)
                  {
                    System.out.print(" ");
                  }// for
                System.out.println("]  <- UNMATCHED");
              }// else
          }// else if
        else if (ch == '\'')
          {
            if (output.isEmpty() == false)
              {
                if ((char) output.peek() == '`')
                  {
                    output.pop();
                    temp = (int) output.pop();
                    for (int j = 0; j < temp; j++)
                      {
                        System.out.print(" ");
                      }// for
                    System.out.print("`");
                    for (int j = 1; j < i - temp; j++)
                      {
                        System.out.print("-");
                      }// for
                    System.out.print("\'");
                    System.out.println();
                  }// if
                else
                  {
                    for (int j = 0; j < i; j++)
                      {
                        System.out.print(" ");
                      }// for
                    System.out.println("\'  <- UNMATCHED");
                  }// else
              }// if
            else
              {
                for (int j = 0; j < i; j++)
                  {
                    System.out.print(" ");
                  }// for
                System.out.println("\'  <- UNMATCHED");
              }// else
          }// else if
      }// for
    while (!(output.isEmpty()))
      {
        char ch = (char) output.pop();
        int pos = (int) output.pop();
        for (int j = 0; j < pos; j++)
          {
            System.out.print(" ");
          }// for
        System.out.println(ch + "  <- UNMATCHED");
      }// while

  }// match(String)

  public static void main(String[] args)
    throws Exception
  {
    // java.io.PrintWriter pen = new java.io.PrintWriter(System.out, true);
    java.io.InputStreamReader istream =
        new java.io.InputStreamReader(System.in);
    java.io.BufferedReader eyes = new java.io.BufferedReader(istream);

    String input = eyes.readLine();
    match(input);

  }// main()

}// class SymbolMatch
