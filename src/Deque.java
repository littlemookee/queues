/**
 * @author 			mikhail
 * created 			19.09.2016
 * last modified	21.09.2016
 * @param <Item>
 */

import java.util.Iterator;
import edu.princeton.cs.algs4.*;

public class Deque<Item> implements Iterable<Item>
{
	private Node first, last;
	private int N;
	
	private class Node {
		public Item item;
		public Node prev, next;
		public Node() {
			item = null; 
			prev = next = null;
		}
	}
	
	private class List implements Iterator<Item> {
		private Node cur;
		private List() {
			cur = first;
		}
		public Item next(){
			if (cur == null)
				throw new java.util.NoSuchElementException();
			Item item = cur.item;
			cur = cur.prev;
			return item;
		}
		public boolean hasNext() {
			return cur != null;
		}
		public void remove() {
			throw new java.lang.UnsupportedOperationException();
		}		
	}
	
    // construct an empty deque
	public Deque()
	{
		N = 0;
		first = last = null;
	}
   
	/**
	 * is the deque empty?
	 * @return
	 */
	public boolean isEmpty()
	{
		return N == 0;
	}
	
	/**
	 * return the number of items on the deque
	 * @return
	 */
	public int size()
	{
		return N;
	}
	
	/**
	 * add the item to the front
	 * @param item
	 */
	public void addFirst(Item item)
	{
		if (item == null)
			throw new java.lang.NullPointerException();
		
		N++;
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.prev = oldFirst;
		if (oldFirst != null) oldFirst.next = first;
		if (last == null) last = first;
	}
	
	/**
	 * add the item to the end
	 * @param item
	 */
	public void addLast(Item item)
	{
		if (item == null)
			throw new java.lang.NullPointerException();
		
		N++;
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = oldLast;
		if (oldLast != null) oldLast.prev = last;
		if (first == null) first = last;
	}
	
	/**
	 * remove and return the item from the front
	 * @return
	 */
	public Item removeFirst()
	{
		if (N == 0)
			throw new java.util.NoSuchElementException();
		
		N--;
		Item item = first.item;
		first = first.prev;
		if (first == null) last = null;
		else first.next = null;
		return item;
	}
	
	/**
	 * remove and return the item from the end
	 * @return
	 */
	public Item removeLast()
	{
		if (N == 0)
			throw new java.util.NoSuchElementException();
		
		N--;
		Item item = last.item;
		last = last.next;
		if (last == null) first = null;
		else last.prev = null;
		return item;
	}
	
	/**
	 * return an iterator over items in order from front to end
	 */
	public Iterator<Item> iterator()
	{
		return new List();
	}
	
	/**
	 * unit testing
	 * @param args
	 */
	public static void main(String[] args)
	{
		Deque<Integer> deque = new Deque<Integer>();
		
		for (int i = 0; i < 100; i++)
			deque.addFirst(i);
		
		for (int i : deque)
			StdOut.println(i);
		
	}
}
