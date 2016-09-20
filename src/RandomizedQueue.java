/**
 * 
 * @author			Mikhail Zulkarneev
 * Created			20.09.2016
 * Last modified	20.09.2016
 *
 * @param <Item>
 */

import edu.princeton.cs.algs4.*;
import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item>
{
	private Item[] data;
	private int N;
	
	private class Array implements Iterator<Item> {
		private int n;
		public Array () {
			n = N;
		}
		public boolean hasNext() {
			return n!=0;
		}
		public Item next() {
			return data[n];
		}
	}
	
	
	/**
	 * construct an empty randomized queue 
	 */
	public RandomizedQueue()
	{
		data = (Item[]) new Object[0];
		N = 0;
	}
	
	/**
	 * is the queue empty?
	 * @return
	 */
	public boolean isEmpty()
	{
		return N==0;
	}
	
	/**
	 * return the number of items on the queue
	 * @return
	 */
	public int size()
	{
		return N;
	}
	
	/**
	 * add the item
	 * @param item
	 */
	public void enqueue(Item item)
	{
		if (data.length == N) resize(2*N);
		data[N++] = item;
	}
	
	private void resize(int newSize)
	{
		if (newSize == 0) newSize = 1;
		Item[] newData = (Item[]) new Object[newSize];
		for (int i = 0; i < N; i++) newData[i] = data[i];
		data = newData;
	}	
	
	/**
	 * remove and return a random item
	 * @return
	 */
	public Item dequeue()
	{
		int i = StdRandom.uniform(N);
		Item item = data[i];
		data[i] = data[--N];
		return item;
	}
	
	/**
	 * return (but do not remove) a random item
	 * @return
	 */
	public Item sample()
	{	
		int i = StdRandom.uniform(N);
		Item item = data[i];
		return item;
	}
	
	/**
	 * return an independent iterator over items in random order
	 */
	public Iterator<Item> iterator()
	{
		return new Array();
	}
	
	/**
	 * unit testing
	 * @param args
	 */
	public static void main(String[] args)
	{		
	}
}