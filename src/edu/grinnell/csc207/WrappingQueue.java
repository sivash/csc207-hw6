package edu.grinnell.csc207;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class WrappingQueue<T>
    implements
      Queue<T>
{
  // +--------+----------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The values stored in the queue.
   */
  T[] values;

  /**
   * The index of the front of the queue.
   */
  int front;

  /**
   * The index of the back of the queue.
   */
  int back;

  /**
   * The number of elements in the queue.
   */
  int size;

  // +--------------+----------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new queue that holds up to capacity elements.
   */
  @SuppressWarnings({ "unchecked" })
  public WrappingQueue(int capacity) throws Exception
  {
    if (capacity <= 0)
      {
        throw new Exception("Queues must have a positive capacity.");
      } // if (capacity <= 0)
    this.values = (T[]) new Object[capacity];
    this.front = 0;
    this.size = 0;
    this.back = 0;
  } // WrappingQueue(int capacity)

  // +---------------+---------------------------------------------------
  // | Queue Methods |
  // +---------------+

  @Override
  public void put(T val)
    throws Exception
  {
    if (this.isFull())
      {
        throw new Exception("no more room!");
      } // if full
    if (this.back >= this.values.length)
      {
        this.back = 0;
      } //if need to wrap back around
    this.values[this.back] = val;
    ++this.size;
    this.back++;
  } // put

  @Override
  public T get()
    throws Exception
  {
    if (this.isEmpty())
      {
        throw new Exception("empty");
      } // if empty
    // Grab and clear the element at the front of the queue
    if (this.front >= this.values.length)
      {
        this.front = 0;
      } //If need to wrap front around
    T result = this.values[this.front];
    this.values[this.front++] = null;
    // We're removing an element, so decrement the size
    --this.size;
    // And we're done
    return result;
  } // get

  @Override
  public T peek()
    throws Exception
  {
    T result = this.values[this.front];
    return result;
  } // peek

  @Override
  public boolean isEmpty()
  {
    return this.size <= 0;
  } //isEmpty

  @Override
  public boolean isFull()
  {
    return this.size >= this.values.length;
  } //isFull

  @Override
  public Iterator<T> iterator()
  {
    return new WrappingIterator<T>(this);
  } //iterator

  @Override
  public void enqueue(T val)
    throws Exception
  {
    this.put(val);
  } //enqueue

  @Override
  public T dequeue()
    throws Exception
  {
    return this.get();
  } //dequeue

} // class WrappingQueue<T>

class WrappingIterator<T>
    implements
      Iterator<T>
{
  // +--------+----------------------------------------------------------
  // | Fields |
  // +--------+
  WrappingQueue<T> vals;
  /**
   * The iterator's current position in the list
   */
  int pos;
  /**
   * The number of times iterator has been moved forward
   */
  int mods;

  // +--------------+----------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new iterator.
   */
  public WrappingIterator(WrappingQueue<T> q)
  {
    this.vals = q;
    this.pos = q.front;
    this.mods = 0;
  } // WrappingIterator

  // +---------+---------------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public T next()
    throws NoSuchElementException
  {
    if (!this.hasNext())
      {
        throw new NoSuchElementException("no elements remain");
      } // if no elements
    T result = this.vals.values[pos];
    if (++pos >= this.vals.values.length)
      this.pos = 0;
    mods++;
    return result;
  } // next()

  @Override
  public boolean hasNext()
  {
    return (this.mods < this.vals.size);
  } // hasNext()


  @Override
  public void remove()
    throws UnsupportedOperationException
  {
    throw new UnsupportedOperationException();
  } // remove()
}// WrappingIterator<T>

