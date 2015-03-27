public class ArrayStack<E> implements Stack<E> {
	private int size;
	private E[] data;
	
	public ArrayStack()
	{
		this(1);
	}
	
	public ArrayStack(int capacity)
	{
		size = 0;
		data = (E[]) new Object[capacity];
	}

	@Override
	public int size() {
		System.out.println("total array size " + data.length);
		return size;
	}

	@Override
	public boolean empty() {
		return (size == 0);
	}

	@Override
	public void push(E e) {
		// maximum size reached need to create new array
		// and copy data
		if (size == data.length)
		{
			data = arrayCopy(data, 2 * data.length);
		}
		
		data[size++] = e;
	}
	
	@Override
	public E pop() {
		if (empty()) return null;
		E value = data[size - 1];
		data[size - 1] = null;
		size--;
		
		// if we only using half the size of array
		// reduce array size to current usage 
		if (size == data.length/2)
		{
			data = arrayCopy(data, size);
		}
		return value;
	}

	@Override
	public E peek() {
		if (empty()) return null;
		return data[size - 1];
	}
	

	/**
	 * Clears the array stack
	 */
	public void clear()
	{
		size = 0;
		data = arrayCopy(data, 1);
		data[0] = null;
	}
	
	/**
	 * Reduce the size of the stack to the number of elements present
	 * @return true if the size was reduced, false otherwise
	 */
	public boolean retainAll()
	{
		// no need to retain
		if (size() == data.length)
			return false;
		else
		{
			data = arrayCopy(data, size);
			return true;
		}
	}
	
	/**
	 * prints the ArrayStack
	 */
	public void print()
	{
		for (int i = 0; i < size; i++)
		{
			if(i %5 == 0)
			{
				System.out.println();
			}
			System.out.print(data[i] + " ");
		}
	}
	
	
	/**
	 * Helper method for copying data to a new array of size newSize
	 * @param data array that needs to be copied
	 * @param newSize the size of the new array
	 * @return an array of size newSize by copying elements from data to new array
	 */
	private E[] arrayCopy(E[] data, int newSize)
	{
		E[] dataCopy = (E[]) new Object[newSize];
		int index = (newSize < data.length) ? newSize : data.length;
		
		for (int i = 0; i < index; i++)
		{
			dataCopy[i] = data[i];
		}
		
		return dataCopy;
	}
}
