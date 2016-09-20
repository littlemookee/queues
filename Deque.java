/**
 * @author 			mikhail
 * created 			19.09.2016
 * last modified	19.09.2016
 * @param <Item>
 */

public class Deque<Item> implements Iterable<Item>
{
	private Node first, last;
	private int N;
	
	private class Node {
		public Item item;
		public Node prev, next;
		public Node() {
			item = prev = next = null;
		}
	}
	
	private class List implements Iterator<Item> {
		private Node cur;
		private List() {
			cur = first
		}
		Item next(){
			Item item = cur.item;
			cur = cur.next;
			return item;
		}
		boolean hasNext() {
			return cur != null;
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
		N++;
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.prev = oldFirst;
		oldFirst.next = first;
	}
	
	/**
	 * add the item to the end
	 * @param item
	 */
	public void addLast(Item item)
	{
		N++;
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = oldLast;
		oldLast.prev = last;
	}
	
	/**
	 * remove and return the item from the front
	 * @return
	 */
	public Item removeFirst()
	{
		N--;
		Item item = first.item;
		first = first.prev;
		first.next = null;
		return item;
	}
	
	/**
	 * remove and return the item from the end
	 * @return
	 */
	public Item removeLast()
	{
		N--;
		Item item = last.item;
		last = last.next;
		last.prev = null;
		return null;
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
		
	}
}
