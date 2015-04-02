import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedPositionalList<E> implements PositionalList<E>, Iterable<E> {
	
	/* nested node class */
	private static class Node<E> implements Position<E> {

		private E element;
		private Node<E> prev;
		private Node<E> next;
		
		public Node(E e, Node<E> p, Node<E> n)
		{
			element = e;
			prev = p;
			next = n;
		}
		
		/* getters and setters */
		
		@Override
		public E getElement() throws IllegalStateException {
			if (next == null)
				throw new IllegalStateException("Invalid Position.");
			return element;
		}
		
		public Node<E> getPrev() { return prev; }
		public Node<E> getNext() { return next; }
		public void setElement(E e) { element = e; }
		public void setPrev (Node<E> p) { prev = p; }
		public void setNext(Node<E> n) { next = n; }
		
	} /* end of nested node class */


	/* nested PositionIterator class */
	private class PositionIterator implements Iterator<Position<E>> {
		
		private Position<E> cursor = first(); // position to report next
		private Position<E> recent = null; // recent position we have looked at
		
		@Override
		public boolean hasNext() {
			return (cursor != null);
		}

		@Override
		public Position<E> next() throws NoSuchElementException{
			if (cursor == null) throw new NoSuchElementException("no more element");
			recent = cursor;
			cursor = after(cursor);
			return recent;
		}
		
		/*
		 * removes the element returned by most recent call to next
		 */
		@Override
		public void remove() throws IllegalStateException{
			if (recent == null) throw new IllegalStateException("nothing to remove");
			LinkedPositionalList.this.remove(recent);
			recent = null;
		}
		
	}
	
	/* the end of nested PositionIterator class */
	
	/* nested PositionIterable class */
	private class PositionIterable implements Iterable<Position<E>>{

		@Override
		public Iterator<Position<E>> iterator() {
			return new PositionIterator();
		}
		
	}
	/* end of nested PositionIterable class */
	
	/* nested ElementIterator class */
	private class ElementIterator implements Iterator<E>
	{
		Iterator<Position<E>> i = new PositionIterator();
		@Override
		public boolean hasNext() {
			return i.hasNext();
		}

		@Override
		public E next() {
			return i.next().getElement();
		}
		
		public void remove()
		{
			i.remove();
		}
		
	}
	/* end of nested ElementIterator class */
	
	/* instance variables */
	private int size;
	private Node<E> header;
	private Node<E> trailer;
	
	/* constructor */
	public LinkedPositionalList()
	{
		size = 0;
		header = new Node<E>(null, null, null);
		trailer = new Node<E>(null, header, null);
		header.setNext(trailer);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Position<E> first() {
		return position(header.getNext());
	}

	@Override
	public Position<E> last() {
		return position(trailer.getPrev());
	}

	@Override
	public Position<E> before(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validatePosition(p);
		return position(node.getPrev());
	}

	@Override
	public Position<E> after(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validatePosition(p);
		return position(node.getNext());
	}
	
	
	@Override
	public Position<E> addFirst(E e) {
		return addBetween(e, header, header.getNext());
	}

	@Override
	public Position<E> addLast(E e) {
		return addBetween(e, trailer.getPrev(), trailer);
	}

	@Override
	public Position<E> addBefore(Position<E> p, E e)
			throws IllegalArgumentException {
		Node<E> node = validatePosition(p);
		return addBetween(e, node.getPrev(), node);
	}

	@Override
	public Position<E> addAfter(Position<E> p, E e)
			throws IllegalArgumentException {
		Node<E> node = validatePosition(p);
		return addBetween(e, node, node.getNext());
	}

	@Override
	public E set(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validatePosition(p);
		E oldElement = node.getElement();
		node.setElement(e);
		return oldElement;
	}

	@Override
	public E remove(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validatePosition(p);
		E element = node.getElement();
		node.getPrev().setNext(node.getNext());
		node.getNext().setPrev(node.getPrev());
		size--;
		node.setElement(null);
		node.setNext(null);
		node.setPrev(null);
		return element;
	}
	
	/* returns an array of elements in the list */
	public E[] toArray()
	{
		if (isEmpty()) return null;
		
		E[] items = (E[]) (new Object[size()]);
		int i = 0;
		Node<E> cursor = header.getNext();
		
		while(cursor != trailer)
		{
			items[i++] = cursor.getElement();
			System.out.println(cursor.getElement());
			cursor = cursor.getNext();
		}
		
		return items;
	}
	
	/* helper methods */

	/* adds the given element e in between first and second node and 
	 * returns its position
	*/
	private Position<E> addBetween(E e,Node<E> first, Node<E> second)
	{
		Node<E> newest = new Node<E>(e, first, second);
		first.setNext(newest);
		second.setPrev(newest);
		size++;
		return newest;
	}
	
	/* validate the given position and convert in into a node */
	private Node<E> validatePosition(Position<E> p) throws IllegalArgumentException
	{
		if (!(p instanceof Node)) 
			throw new IllegalArgumentException("Invalid position");
		Node<E> node = (Node<E>) p;
		if (node.getNext() == null)
			throw new IllegalArgumentException("p is no longer in the list");
		return node;
	}
	
	/* returns the node as a position (null if its a sentinel) */
	private Position<E> position(Node<E> node)
	{
		if (node == header || node == trailer)
			return null;
		return node;
	}

	/* returns iterable of list positions */
	public Iterable<Position<E>> positions()
	{
		return new PositionIterable();
	}
	
	/* returns an iterator of elements stored in the list */
	@Override
	public Iterator<E> iterator()
	{
		return new ElementIterator();
	}
		
	
	
	/* playing around with the list */
	public static void main(String[] args)
	{
		LinkedPositionalList<String> l = new LinkedPositionalList<String>();
		
		System.out.println(l.addFirst("sakshyam").getElement());
		System.out.println(l.first().getElement());
		Position<String> first = l.first();
		System.out.println(l.addAfter(first, "dahal"));
		l.addFirst("I am ");
		System.out.println(Arrays.toString(l.toArray()));
		
		
	}

}
