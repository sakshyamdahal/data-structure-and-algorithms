public class ArrayDeque<E> implements Deque<E> {
	private E[] data;
	private int first;
	private int size;
	private static int CAPACITY = 1000;
	
	public ArrayDeque() { this(CAPACITY); }
	
	@SuppressWarnings("unchecked")
	public ArrayDeque(int capacity)
	{
		data = (E[]) new Object[capacity];
		first = 0;
		size = 0;
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
	public E first() {
		if (isEmpty()) return null;
		return data[first];
	}

	@Override
	public E last() {
		if (isEmpty()) return null;
		int lastIndex = (first+size - 1) % data.length;
		return data[lastIndex];
	}

	@Override
	public void addFirst(E e) {
		if (size == data.length) return; // can't add the deque is full
		int firstIndex = (first - 1 + data.length) % data.length;
		data[firstIndex] = e;
		first = firstIndex;
		size++;
	}

	@Override
	public void addLast(E e) {
		if (size == data.length) return;
		int lastIndex = (first + size) % data.length;
		data[lastIndex] = e;
		size++;
	}

	@Override
	public E removeFirst() {
		if (isEmpty()) return null;
		E f = data[first];
		data[first] = null;
		first = (first + 1) % data.length;
		size--;
		return f;
	}

	@Override
	public E removeLast() {
		if (isEmpty()) return null;
		int lastInd = (first + size - 1) % data.length;
		E l = data[lastInd];
		data[lastInd] = null;
		size--;
		return l;
	}
}
