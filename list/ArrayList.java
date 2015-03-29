package practice.edu;

import java.util.Arrays;

public class ArrayList<E> implements List<E>{
	
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
