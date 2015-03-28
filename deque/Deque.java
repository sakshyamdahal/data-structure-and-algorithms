/*
 * Interface for double-ended queue, (deque): a collection of elements
 * that can be inserted and removed at both ends
 */
/**
 * @author sakshyamdahal
 *
 */
public interface Deque<E> {
	
	/**
	 * @return size of the element in the queue
	 */
	int size();
	
	/**
	 * Tests whether the deque is empty
	 * @return true if the deque is empty, false otherwise
	 */
	boolean isEmpty();
	
	/**
	 * Returns but doesn't remove the first element from the deque (null if empty)
	 * @return first element of deque (null if empty)
	 */
	E first(); 
	
	
	/**
	 * Return but doesn't remove the last element from the deque (null if empty)
	 * @return last element of deque (null if empty)
	 */
	E last();
	
	/**
	 * Inserts an element at the front of deque
	 * @param e element to be inserted 
	 */
	void addFirst(E e);
	
	/**
	 * Inserts an element at the back of the deque
	 * @param e element to be inserted at back of deque
	 */
	void addLast(E e);
	
	/**
	 * Removes and returns the last element of deque
	 * @return the first element of deque (null if empty)
	 */
	E removeFirst();
	
	/**
	 * Removes and returns the last element of deque
	 * @return last element of deque (null if empty)
	 */
	E removeLast();

}
