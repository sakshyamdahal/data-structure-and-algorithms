/*
 * @author: Sakshyam Dahal
 * Date: March 28, 2015
*/

public class ArrayQueue<T> implements Queue<T>{

	private static final int capacity = 1000;
	private int first;
	private int size;
	private T[] data;
	
	public ArrayQueue()
	{
		this(capacity);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayQueue(int sz)
	{
		size = 0;
		first = 0;
		data = (T[]) new Object[sz];
	}
	
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void enqueue(T e) {
		if (size < data.length)
		{
			int index = (size + first) % data.length;
			data[index] = e;
			size++;
		}
	}

	@Override
	public T first() {
		if (isEmpty()) return null;
		return data[first];
	}

	@Override
	public T dequeue() {
		if (isEmpty()) return null;
		T item = data[first];
		data[first] = null;
		first = (first + 1) % data.length;
		size--;
		return item;
		
	}
}
