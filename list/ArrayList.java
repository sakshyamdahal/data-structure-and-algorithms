import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E> {

	/* nested ArrayIterator class */
	private class ArrayIterator implements Iterator<E> {
		private int j = 0;
		private boolean removable = false;

		/* 
		 * tests whether the iterator has a next object
		 */
		@Override
		public boolean hasNext() {
			return j < size;
		}

		/*
		 * returns the next object in the iterator 
		 * throws no such element exception if no further elements
		 */
		@Override
		public E next() {
			if (j == size) throw new NoSuchElementException("No next element.");
			removable = true;
			return data[j++];
		}
		
		/*
		 * removes the element returned by most recent call to next
		 */
		@Override
		public void remove() throws IllegalStateException {
			if (!removable) throw new IllegalStateException("nothing to remove.");
			ArrayList.this.remove(j - 1);
			j--;
			removable = false;
		}
	}
	
	/* end of nested ArrayIterator class */
	
	private E[] data;
	private int size;
	private static int capacity = 100;
	
	public ArrayList() {this(capacity);}
	@SuppressWarnings("unchecked")
	public ArrayList(int c)
	{
		data = (E[]) (new Object[c]);
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean empty() {
		return size == 0;
	}

	@Override
	public E get(int i) throws IndexOutOfBoundsException {
		outOfBound(i,size);
		return data[i];
	}

	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException {
		outOfBound(i,size);
		E old = data[i];
		data[i] = e;
		return old;
			
	}

	@Override
	public E remove(int i) throws IndexOutOfBoundsException{
		outOfBound(i,size);
		E toRemove = data[i];
		for (int j = i + 1; j < size; j++)
		{
			data[j - 1] = data[j];
		}
		
		data[size - 1] = null;
		size--;
		return toRemove;
		
	}

	@Override
	public void add(int i, E e) throws IndexOutOfBoundsException, IllegalStateException {
		outOfBound(i, size + 1);
		if (size() == data.length) 
			resize(2 * data.length);
		
		for (int j = size(); j > i; j--)
			data[j] = data[j - 1];
		
		data[i] = e;
		size++;
	}
	
	/* helper method to check if index is in bounds */
	private void outOfBound(int i, int k) throws IndexOutOfBoundsException
	{
		if (i < 0 || i >= k)
			throw new IndexOutOfBoundsException("Illegal index : " + i);
	}
	
	
	public E[] toArray()
	{
		E[] arr = (E[]) new Object[size()];
		for (int i = 0; i < size(); i++)
			arr[i] = data[i];
		
		return arr;
	}
	
	private void resize(int capacity)
	{
		E[] temp = (E[]) new Object[capacity];
		data = Arrays.copyOf(data, capacity);
	}


	/*
	 * returns an iterator of elements stored in the list
	 */
	@Override
	public Iterator<E> iterator() {
		return new ArrayIterator();
	}
	
	/* testing */
	public static void main(String[] args)
	{
		ArrayList<Integer> arr = new ArrayList<Integer>(2);
		
		for (int i = 1; i <= 30; i++)
			arr.add(i- 1, i);
		
		System.out.println(Arrays.toString(arr.toArray()));
		
		arr.remove(20);
		System.out.println(Arrays.toString(arr.toArray()));
		
		arr.set(9, 9);
		System.out.println(Arrays.toString(arr.toArray()));
		
		for (int i = 1; i < 20; i++)
			arr.add(arr.size(), i);
		
		System.out.println(Arrays.toString(arr.toArray()));
		
		arr.add(0, 0);
		System.out.println(Arrays.toString(arr.toArray()));
		
		arr.remove(0);
		System.out.println(Arrays.toString(arr.toArray()));
		
		arr.remove(47);
		System.out.println(Arrays.toString(arr.toArray()));
		
		
	}
	
	
}
