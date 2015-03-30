public interface PositionalList<E> {
	
	
	/**
	 * @return the number of element in the list
	 */
	int size();
	
	/**
	 * @return true if the list is empty false otherwise
	 */
	boolean isEmpty();
	
	/**
	 * @return the first positon of the list (null if empty)
	 */
	Position<E> first();
	
	/**
	 * @return the last position of the list (null if empty)
	 */
	Position<E> last();
	
	/**
	 * @param p a position
	 * @return the position immediately before position p (null if p is first)
	 * @throws IllegalArgumentException if p is not valid
	 */
	Position<E> before(Position<E> p) throws IllegalArgumentException;
	
	/**
	 * @param p a position
	 * @return the position imeediatley after positon p (null if p is last)
	 * @throws IllegalArgumentException if p is not valid
	 */
	Position<E> after(Position<E> p) throws IllegalArgumentException;
	
	/**
	 * @param e element to be added at front of the list
	 * @return the position of newly added element
	 */
	Position<E> addFirst(E e);
	
	
	/**
	 * @param e element to be added at the end of the list
	 * @return the position of newly added element
	 */
	Position<E> addLast(E e);
	
	
	/**
	 * Adds the element e immediately before position p and returns its position
	 * @param p position before which e is to be added
	 * @param e element that is to be added before positon p
	 * @return the positon of the newly added element
	 */
	Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException;
	
	/**
	 * Adds the element e immediately after position p and returns its position
	 * @param p position after which e is to be added
	 * @param e element that is to be added after position p
	 * @return the position of newly added element
	 * @throws IllegalArgumentException
	 */
	Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException;
	
	/**
	 * Replaces the element stored at position p and returns the replaced element
	 * @param p positon where we need to change element
	 * @param e the element to be inserted in the position
	 * @return the replaced element
	 * @throws IllegalArgumentException if p is not valid
	 */
	E set(Position<E> p, E e) throws IllegalArgumentException;
	
	/**
	 * Removes the element stored at position p and returns it (p is no longer valid)
	 * @param p the postion to be removed
	 * @return element sotred at positon p
	 * @throws IllegalArgumentException if p is not valid
	 */
	E remove(Position<E> p) throws IllegalArgumentException;
	

}
