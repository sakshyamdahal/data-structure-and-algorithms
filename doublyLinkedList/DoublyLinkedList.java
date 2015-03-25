/*
 * @author: Sakshyam Dahal
*/

public class DoublyLinkedList<E> {
	
	/* nested Node class */
	private static class Node<E> {
		E element;
		Node<E> next;
		Node<E> prev;
		
		/* constructors */
		public Node(E e, Node<E> p, Node<E> n)
		{
			element = e;
			prev = p;
			next = n;
		}
		public Node() { this(null, null, null); }
		/* end of constructors */
		
		/* getters */
		public E getElement() { return element; }
		public Node<E> getPrev() { return prev; }
		public Node<E> getNext() { return next; }
		
		/* setters */
		public void setNext(Node<E> n) { next = n; }
		public void setPrev(Node<E> p) { prev = p; }
	}
	/* end of nested Node class */
	
	private int size;
	private Node<E> sentinel;
	
	public DoublyLinkedList()
	{
		size = 0;
		sentinel = new Node<E>(null, new Node<E>(), new Node<E>());
		sentinel.getPrev().setNext(sentinel.getNext());
		sentinel.getNext().setNext(sentinel.getPrev());
	}
	
	public int size() { return size; }
	public boolean isEmpty() { return size == 0; };
	
	public E first() 
	{
		if (isEmpty())
			return null;
		return sentinel.getNext().getElement();
	}
	
	public E last()
	{
		if (isEmpty())
			return null;
		return sentinel.getPrev().getElement();
	}
	
	public void addFirst(E e)
	{
		addBetween(sentinel.getNext(), sentinel.getNext().getNext(), e);
	}
	
	public void addLast(E e)
	{
		addBetween(sentinel.getPrev().getPrev(), sentinel.getPrev(), e);
	}
	
	public E removeFirst()
	{
		if (isEmpty())
			return null;
		return remove(sentinel.getNext().getNext());
	}
	
	public E removeLast()
	{
		if (isEmpty())
			return null;
		return remove(sentinel.getPrev().getPrev());
	}
	
	public E remove(Node<E> node)
	{
		// next node's previous node = this node's previous node
		node.getNext().setPrev(node.getPrev());
		// previous node's next node = this node's next node
		node.getPrev().setNext(node.getNext());
		
		size--;
		return node.getElement();
	}
	
	private void addBetween(Node<E> first , Node<E> second, E e)
	{
		Node<E> newNode = new Node<E>(e, first, second);
		first.setNext(newNode);
		second.setPrev(newNode);
		size++;
	}
	
	/* prints the list in the same order */
	public void printList()
	{
		Node<E> pointer = sentinel.getNext().getNext();
		
		while (pointer.getElement() != null )
		{
			System.out.print(pointer.getElement() + " ");
			pointer = pointer.getNext();
		}
		System.out.println();
	}
}