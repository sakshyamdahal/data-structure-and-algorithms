import java.util.Iterator;

/*
 * @author: Sakshyam Dahal
 * An interface for tree ADT
*/

public interface Tree<E> implements Iterable<E> {

 	/**
	* @return the position of the root of the tree (null if empty)
 	*/
	Position<E> root();

	/**
	 * return the position of the parent of the node whose position is provided
	 * @param p position of the node 
	 * @return the position of the parent for the given node position
	 * @throws IllegalArgumentException if position p is invalid
	 */
	Position<E> parent(Position<E> p) throws IllegalArgumentException;

	/**
	* returns an iterable of position of children nocdes given a nodes position
	* @param p position of the node
	* @return an iterable of position of the children nodes for a given node's position
	* @throws IllegalArgumentException if position p is invalid
	*/
	Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException;

	/**
	* returns the number of children for the given node's position
	* @param p positon of the node
	* @return the number of children nodes
	* @throws IllegalArgumentException if p is invalid
	*/
	int numChildren(Position<E> p) throws IllegalArgumentException;

	/**
	* returns the size of the tree ie number of elements in the tree
	* @return number of elements in the tree
	*/
	int size();

	/**
	* checks whether the tree is empty or not
	* @return true if the tree is empty false otherwise
	*/
	boolean isEmpty();

	/**
	* checks whether the node at the given position is internal or not (i.e it has at least one children)
	* @param p the node's position
	* @return true if the node is internal, false otherwise
	* @throws IllegalArgumentException if p is invalid
	*/
	boolean isInternal(Position<E> p) throws IllegalArgumentException;

	/**
	* checks whether the node at the given position is external or not (ie it has no children)
	* @param p the node's position
	* @return true if the node is external, false otherwise
	* @throws IllegalArgumentException if p is invalid
	*/
	boolean isExternal(Position<E> p) throws IllegalArgumentException;

	/**
	* checks whether the node at the given position is the root of the tree
	* @param p the node's position
	* @return true if the node at the given position is the root of the tree, false otherwise
	* @throws IllegalArgumentException if p is invalid
	*/
	boolean isRoot(Position<E> p) throws IllegalArgumentException;

	/**
	* @return an iterator for the elements in the tree
	*/
	Iterator<E> iterator();

	/**
	* @return an iterable for the positions in the tree
	*/
	Iterable<Position<E>> positions();
}