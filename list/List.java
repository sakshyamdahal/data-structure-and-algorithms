package practice.edu;

public interface List<E> {
	
	/* Returns the number of elements in the list */
	int size();
	
	/* Returns if the list is empty or not */
	boolean empty();
	
	/* Returns an element at index i without removing it */
	E get(int i) throws IndexOutOfBoundsException;
	
	/* Replaces the element at index i with e, and returns the replaced element */
	E set(int i, E e) throws IndexOutOfBoundsException;
	
	/* removes and returns the element at index i shifting subsequent elements earlier */
	E remove(int i) throws IndexOutOfBoundsException;
	
	/* adds element e at index i shifting all subsequent elements later */
	void add(int i, E e) throws IndexOutOfBoundsException;
	
}
