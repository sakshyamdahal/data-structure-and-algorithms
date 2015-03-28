/**
 * Queue: A First Item First Out (FIFO) structure.
 * @author sakshyamdahal
 *
 */
public interface Queue<T> {

	/**
	 * @return number of elements in the queue
	 */
	int size();
	
	/**
	 * @return true if the queue is empty, false otherwise
	 */
	boolean isEmpty();
	
	/**
	 * Inserts an element at the rear of the queue
	 * @param e element to be inserted in the queue
	 */
	void enqueue(T e);
	
	/**
	 * Returns but doesnot remove the first element of the queue
	 * @return the first element of the queue (null if empty)
	 */
	T first();
	
	/**
	 * Removes and return the first element of the queue (null if empty)
	 * @return the first element of the queue
	 */
	T dequeue();
	
}
