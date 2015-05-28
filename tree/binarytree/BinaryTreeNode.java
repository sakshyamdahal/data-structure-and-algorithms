public class BinaryTreeNode<E> {
	public E data;
	public BinaryTreeNode<E> left;
	public BinaryTreeNode<E> right;
	
	public BinaryTreeNode(E data)
	{
		this.data = data;
		left = null;
		right = null;
	}
	
	/* getters */
	public E getData() { return data; }
	public BinaryTreeNode<E> getLeft() { return left; }
	public BinaryTreeNode<E> getRight() { return right; }
	
	/* setters */
	public void setData(E data) { this.data = data; }
	public void setLeft(BinaryTreeNode<E> left) { this.left = left; }
	public void setRight(BinaryTreeNode<E> right) { this.right = right; }
	
}
