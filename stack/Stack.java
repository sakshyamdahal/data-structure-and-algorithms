/*
 * Interface for stack first in first out (FIFO) structure.
 * @author: Sakshyam Dahal
 */

public interface Stack<E>
{
	
	/**
	 * Returns the number of element in the stack
	 * @return a long corrosponding number of elements in the stack
	 */
	int size();
	
	/**
	 * Tests whether the stack is currently empty
	 * @return true if stack if empty, false otherwise
	 */
	boolean empty();
	
	/**
	 * Inserts an element at the top of the stack
	 * @param e		the element to be inserted
	 */
	void push(E e);
	
	/**
	 * Removes and returns the top element on the stack
	 * @return	the element that was removed from stack ( or null if stack is empty )
	 */
	E pop();
	
	/**
	 * Returns but does remove the top element from the stack
	 * @return top element in the stack (or null if stack is empty)
	 */
	E peek();
}
