import java.util.Arrays;

/*
 * Stack of fixed capacity where 
 * when it reaches maximum capacity
 * oldest elements are removed and replaced 
 * by newest elements.
 */

public class ArrayLeakyStack<E> implements Stack<E>{

	private int size;
	private E[] data;
	private int first;
	
	@SuppressWarnings("unchecked")
	public ArrayLeakyStack(int capacity)
	{
		size = 0;
		first = -1;
		data = (E[]) (new Object[capacity]);
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
	public void push(E e) {
		int pushInd = (first + 1) % data.length;
		data[pushInd] = e;
		first = pushInd;
		
		if (size != data.length)
			size++;
	}

	@Override
	public E pop() {
		if (empty()) return null;
		E e = data[first];
		data[first] = null;
		size--;
		first = (first - 1 + data.length) % data.length;
		
		return e;
	}

	@Override
	public E peek() {
		if (empty()) return null;
		return data[first];
	}
	
	@SuppressWarnings("unchecked")
	public E[] toArray()
	{
		E[] items = (E[]) new Object[size];
		
		for (int i = 0; i < size(); i++)
		{
			
			items[i] = data[(first - i + data.length) % data.length];
		}
		
		return items;
	}
	
	
	public static void main(String[] args)
	{
		ArrayLeakyStack<Integer> a = new ArrayLeakyStack<Integer>(10);
		System.out.println(Arrays.toString(a.toArray()));
		
		for (int i = 1; i < 20; i++)
		{
			a.push(i);
			System.out.println(Arrays.toString(a.toArray()));
			
		}
		
		for (int i = 1; i <= 10; i++)
			System.out.println(a.pop());
	}