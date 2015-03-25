public class Sorts {
	
	/* implementation of insertion sort algorithm */
	/* 
	 * worst case running time: O(n^2)
	 * best case running time: O(n)
	 * space complexity: O(1)
	 *  
	 */
	public static <T extends Comparable<T>> void insertionSort(T[] items)
	{
		int i;
		int j;
		T temp;
		
		for (i = 1; i < items.length; i++)
		{
			temp = items[i];
			j = i;
			while(j > 0 && items[j - 1].compareTo(temp) > 0)
			{	
				items[j] = items[j - 1];
				j--;
			}
			
			if (j != i)
				items[j] = temp;
		}
	}
	
	/* implementation of bubble sort algorithm */
	/* 
	 * worst case running time: O(n^2)
	 * best case running time: O(n)
	 * space complexity: O(1)
	 * 
	 */
	public static <T extends Comparable<T>> void bubbleSort(T[] items)
	{
		boolean swap;
		do
		{
			swap = false;
			T temp;
			for (int i = 0; i < items.length - 1; i++)
			{
				if (items[i].compareTo(items[i+1]) > 0)
				{
					temp = items[i];
					items[i] = items[i + 1];
					items[i + 1] = temp;
					swap = true;
				}
			}
		}
		while(swap);
	}
	
}
