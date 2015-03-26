/**
 * @author sakshyamdahal
 *
 */
public class Search {
	
	/*
	 * The binary search algorithm runs in O(log n) time for a sorted array of
	 * n elements and O(1) extra space.
	 * The recursive implementation requires O(log n) extra space.
	 */
	
	/* returns the index of key. If key not found returns - 1 */
	public static <T extends Comparable<T>> int binarySearch(T items[], T key)
	{
		return binarySearch(items, 0, items.length -1, key);
	}
	
	private static <T extends Comparable<T>> int binarySearch(T items[], int low, int high, T key)
	{
		if (low > high)
			return -1;
		
		int mid = (low + high) / 2;
		
		if (items[mid].equals(key))
			return mid;
		else if (items[mid].compareTo(key) > 0)
			// look the left half
			return binarySearch(items, low, mid - 1, key);
		else
			return binarySearch(items, mid + 1, high, key);
	}
	
	
	/*
	 * linear search takes O(n) time for an array of size n
	 * array need not be sorted
	 */
	/* returns the index of key. If key not found returns - 1 */
	public static <T extends Comparable<T>> int linearSearch(T items[], T key)
	{
		for (int i = 0; i < items.length; i++)
		{
			if (items[i].equals(key))
				return i;
		}
		
		return -1;
	}
	

}
