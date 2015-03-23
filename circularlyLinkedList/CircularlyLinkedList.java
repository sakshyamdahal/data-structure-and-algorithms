/**
 * @author sakshyamdahal
 */

public class CircularlyLinkedList<E> {
	/* nested node class */
	private static class Node<E> {
		E element;
		Node<E> next;
		
		public Node(E e, Node<E> n) 
		{
			element = e;
			next = n;
		}
		
		public E getElement() {	return element; }
		public Node<E> getNext() { return next; }
		public void setNext(Node<E> n) { next = n; }
	}
	/* end of nested node class */
	
	private Node<E> tail;
	private int size;
	
	public CircularlyLinkedList()
	{
		tail = null;
		size = 0;
	}
	
	public int size() { return size; }
	public boolean isEmpty() { return size == 0; }
	
	public E getFirst()
	{
		if (isEmpty()) return null;
		return tail.getNext().getElement();
	}
	
	public E getLast()
	{
		if (isEmpty()) return null;
		return tail.getElement();
	}
	
	public void rotate()
	{
		if (!isEmpty()) 
			tail = tail.getNext();
	}
	
	public void addFirst(E e)
	{
		if (isEmpty())
		{
			tail = new Node<E>(e, null);
			tail.setNext(tail);
		}
		else
			tail.setNext(new Node<E>(e, tail.getNext()));
		
		size++;
	}
	
	public void addLast(E e)
	{
		addFirst(e);
		tail = tail.getNext();
	}
	
	public E removeFirst()
	{
		if (isEmpty()) return null;
		E first = tail.getNext().getElement();
		size--;
		
		if (isEmpty()) tail = null;
		else
			tail.setNext(tail.getNext().getNext());
		
		return first;
	}
	
}
