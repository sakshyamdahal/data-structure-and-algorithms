/*
 * Base class for concrete Tree implementation
*/

public abstract class AbstractTree<E> implements Tree<E> {

	public boolean isInternal(Position<E> p)
	{
		return numChildren(p) > 0;
	}

	public boolean isExternal(Position<E> p)
	{
		return numChildren(p) == 0;
	}

	public boolean isRoot(Position<E> p)
	{
		return p == root();
	}

	public boolean isEmpty()
	{
		return size() == 0;
	}

	/* retuns the depth of p from the root */
	/* runs in O(depth of p) */
	public int depth(Position<E> p)
	{
		if (isRoot(p))
			return 0;
		else
			return 1 + depth(parent(p));
	}


	/* returns height of the tree*/
	/* runs in O(n^2) */
	private int heightBad()
	{
		int height = 0;
		for(Position<E> p : positions())
		{
			if (isExternal(p))
			{
				height = Math.max(height, depth(p));
			}
		}

		return height;
	}

	/* returns the height of subtree at position p */
	/* this algorithm runs in O(n) */
	/* height of given position is 0 if its leaf
	 * and height is 1 more than maximum height of its children
	 * if its not leaf
	*/
	private int height(Position<E> p)
	{
		int height = 0;
		for (Position<E> child : children(p))
		{
			height = Math.max(h, 1 + height(child));
		}

		return height;
	}
}