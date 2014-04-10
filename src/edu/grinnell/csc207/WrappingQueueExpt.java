package edu.grinnell.csc207;

import java.util.Iterator;

public class WrappingQueueExpt
{

  /**
   * @param args
   */
  public static void main(String[] args)
    throws Exception
  {
    System.out.println("----Wrapping Queue Experiments----");
    System.out.println();
    System.out.println("Creating Queue capacity 5");
    WrappingQueue<String> queue = new WrappingQueue<String>(5);
    System.out.println();
    System.out.println("IsEmpty?");
    System.out.println(queue.isEmpty());
    System.out.println();
    System.out.println("Put Hello");
    queue.put("Hello");
    System.out.println();
    System.out.println("IsEmpty?");
    System.out.println(queue.isEmpty());
    System.out.println();
    System.out.println("Get:");
    System.out.println(queue.get());
    System.out.println();
    System.out.println("IsEmpty?");
    System.out.println(queue.isEmpty());
    System.out.println();
    System.out.println("Put ashwin");
    queue.put("ashwin");
    System.out.println();
    System.out.println("Peek:");
    System.out.println(queue.peek());
    System.out.println();
    System.out.println("Put b, c, d, e");
    queue.put("b");
    queue.put("c");
    queue.put("d");
    queue.put("e");
    System.out.println();
    System.out.println("isFull?");
    System.out.println(queue.isFull());
    System.out.println();
    System.out.println("Get:");
    System.out.println(queue.get());
    System.out.println();
    System.out.println("Get:");
    System.out.println(queue.get());
    System.out.println();
    System.out.println("isFull?");
    System.out.println(queue.isFull());
    System.out.println();
    System.out.println("Testing Wrapping");
    System.out.println();
    System.out.println("Put f, g");
    queue.put("f");
    queue.put("g");
    System.out.println();
    System.out.println("isFull?");
    System.out.println(queue.isFull());
    System.out.println();
    System.out.println("Get x 5");
    System.out.println(queue.get());
    System.out.println(queue.get());
    System.out.println(queue.get());
    System.out.println(queue.get());
    System.out.println(queue.get());
    System.out.println();
    System.out.println("IsEmpty?");
    System.out.println(queue.isEmpty());
    System.out.println();
    System.out.println("----Iterator Tests----");
    WrappingQueue<String> queue2 = new WrappingQueue<String>(5);
    System.out.println();
    System.out.println("Put a, b, c, d, e");
    queue2.put("a");
    queue2.put("b");
    queue2.put("c");
    queue2.put("d");
    queue2.put("e");
    System.out.println();
    System.out.println("get x2");
    queue2.get();
    queue2.get();
    System.out.println();
    System.out.println("Put f , g (To test iterator's ability to wrap)");
    queue2.put("f");
    queue2.put("g");
    System.out.println();
    System.out.println("Creating Iterator");
    Iterator<String> ite = queue2.iterator();
    System.out.println();
    System.out.println("hasNext?");
    System.out.println(ite.hasNext());
    System.out.println();
    System.out.println("Next x 5");
    System.out.println(ite.next());
    System.out.println(ite.next());
    System.out.println(ite.next());
    System.out.println(ite.next());
    System.out.println(ite.next());
    System.out.println();
    System.out.println("hasNext?");
    System.out.println(ite.hasNext());
    System.out.println();
  } // main
} // WrappingQueueExpt
