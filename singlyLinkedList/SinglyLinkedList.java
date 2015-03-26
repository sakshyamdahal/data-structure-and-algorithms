/*
 * @author: Sakshyam Dahal
 * Implementing singly linked list 
*/

public class SinglyLinkedList<E>{
	
	/* nested node class */
	private static class Node<E>
	{
		E element;
		Node<E> next;
		
		public Node(E ele, Node<E> pointer)
		{
			element = ele;
			next = pointer;
		}
		
		public E getElement() { return element; }
		public Node<E> getNext() { return next; }
		public void setNext(Node<E> n) { next = n; }
	}
	/* end of nested node class */
	
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;
	public SinglyLinkedList() {}
	
	/* returns the size of the singly linked list, return if its empty*/
	public int size() { return size; }
	public boolean isEmpty() { return size == 0; }
	
	/* return first element without deleting it */
	public E getFirst()
	{
		if (size == 0) { return null; }
		else
			return head.getElement();
	}
	
	/* return last element without deleting it */
	public E getLast()
	{
		if (size == 0) { return null;}
		else
			return tail.getElement();
	}
	
	/* add an element at the beginning of singlylinked list */
	public void addFirst(E element)
	{
		// head is the new node and it points to old head
		head = new Node<E>(element, head);
		// if its the first element to be added it is also the tail
		if (size == 0) { tail = head; }
		// size of linked list increases
		size++;
	}
	
	/* add an element at the end of the list */
	public void addLast(E element)
	{
		/* create a new node */
		Node<E> newest = new Node<E>(element, null);
		/* if list is empty last node = first node */
		if (size == 0) { head = newest; }
		else
			tail.setNext(newest);
		/* update the tail */
		tail = newest;	
		size++;
	}
	
	/* removes and returns the first element in the singly linked list */
	public E removeFirst()
	{
		if (isEmpty()) { return null; }
		
		E firstElement = head.getElement();
		head = head.getNext();
		
		size--;
		/* list might be empty now */
		if (isEmpty()) { tail = null; }
		
		return firstElement;	
	}
	
	/* removes and returns the last element in the list */
	public E removeLast1()
	{
		/* if list is empty nothing to remove */
		if (isEmpty()) { return null; }
		
		/* if only one element in list */
		if (size() == 1)
		{
			E element = head.getElement();
			head = null;
			tail = null;
			size--;
			return element;
		}
		
		Node<E> pointer = head;
		
		while(pointer.next.next != null)
		{
			pointer = pointer.next;
		}
		
		E element = pointer.next.getElement();
		pointer.next = pointer.next.next;
		
		tail = pointer;
		size--;
		return element;	
	}
	
	/* leverages size to remove the last element */
	public E removeLast()
	{
		if (isEmpty()) { return null; }
		if (size() == 1)
		{
			E element = head.getElement();
			head = null;
			tail = null;
			size--;
			return element;
		}
		
		Node<E> pointer = head;
		
		// get the second last element
		for (int i = 1; i < size() - 1; i++)
		{
			pointer = pointer.getNext();
		}
		
		E element = tail.getElement();
		pointer.setNext(null);
		tail = pointer;
		size--;
		return element;
	}
	
	
	/* checks if an elemnet is present in the list */
	public boolean hasElement(E e)
	{
		Node<E> pointer = head;
		
		while(pointer != null)
		{
			if (pointer.getElement().equals(e))
				return true;
			pointer = pointer.getNext();
		}
		return false;
	}
	
	/* remove element from list */
	public boolean remove(E e)
	{
		if (isEmpty()) { return false; } // nothing to delete
		
		/* if its first element or last element */
		if (getFirst().equals(e)) { removeFirst(); return true; }
		if (getLast().equals(e)) { removeLast(); return true; }
		
		/* traverse to find and remove the element */
		Node<E> pointer = head;
		while(pointer.next != null)
		{
			// the next element is the one we need to remove
			if (pointer.next.getElement().equals(e))
			{
				pointer.next = pointer.next.next;
				size--;
				return true;
			}
			
			pointer = pointer.next;
		}
		
		// couldn't find the element
		return false;
	}

	@Override
	public boolean equals(Object o)
	{
		if (o == null) return false;
		if (getClass() != o.getClass()) return false;
		
		SinglyLinkedList<E> other = (SinglyLinkedList<E>) o;
		if (size() != other.size()) return false;
		Node<E> pointer1 = head;
		Node<E> pointer2 = other.head;
		
		while (pointer1 != null)
		{
			if (!pointer1.getElement().equals(pointer2.getElement()))
			{
				return false;
			}
			
			pointer1 = pointer1.getNext();
			pointer2 = pointer2.getNext();
		}
		
		return true;
	}

	@Override
	public SinglyLinkedList<E> clone() throws CloneNotSupportedException
	{
		@SuppressWarnings("unchecked")
		SinglyLinkedList<E> listCopy = (SinglyLinkedList<E>) super.clone();
		if (listCopy.size() > 0)
		{
			listCopy.head = new Node<E>(head.getElement(), null);
			listCopy.tail = listCopy.head;
			
			Node<E> pointer = head.getNext();
			
			while(pointer != null)
			{
				Node<E> newNode = new Node<E>(pointer.getElement(), null);
				listCopy.tail.setNext(newNode);
				listCopy.tail = newNode;
				pointer = pointer.getNext();
			}
		}
		
		return listCopy;
	}
	
	
	
	@Override
	public String toString()
	{
		StringBuilder list = new StringBuilder();
		//list.append("[ ");
		Node<E> pointer = head;
		while(pointer != null)
		{
			if (pointer.getNext() != null)
				list.append("[" + pointer.getElement() + "] --->");
			else
				list.append("[" + pointer.getElement() + "]");
			
			pointer = pointer.getNext();
		}
		
		//list.append(" ]");
		
		return list.toString();
	}
	
	
	public static void main(String[] args)
	{
		SinglyLinkedList<Integer> l = new SinglyLinkedList<Integer>();
		
//		Random rand = new Random();
//		int num1;
//		int num2;
//		for (int i = 0; i < 30; i++)
//		{
//			num1 = rand.nextInt(30);
//			num2 = rand.nextInt(30);
//			
//			if (num1 % 2 == 0 && num2 % 2 == 0)
//			{
//				l.addFirst(num1);
//				l.addLast(num2);
//				System.out.println(l.toString());
//				System.out.println("Size " + l.size());
//			}
//			
//			
//		}
//		
//		l.addFirst(100);
//		System.out.println("has 100 " + l.hasElement(100));
//		System.out.println(l.toString());
//		
//		l.addLast(200);
//		System.out.println("has 200 " +l.hasElement(200));
//		System.out.println(l.toString());
//		
//		l.removeLast();
//		System.out.println(l.toString());
//		System.out.println("has 200 " +l.hasElement(200));
//		
//		System.out.println("has 2000 " + l.hasElement(2000));
//		System.out.println(l.toString());
//		
//		int size = l.size();
//		// remove last
//		System.out.println("Remove last");
//		for (int i = 0; i < size/2; i++)
//		{
//			l.removeFirst();
//			l.removeLast();
//			System.out.println(l.toString());
//			System.out.println("Size " + l.size());
//			
//		}
		
		for (int i = 1; i < 10; i++)
		{
			l.addLast(i);
		}
		l.addFirst(8);
		
		System.out.println(l.toString());
		
		l.remove(8);
		System.out.println(l.toString());

		
		
	}
	
	
	
	
	
	
}
