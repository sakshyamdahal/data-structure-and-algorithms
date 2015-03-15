/*
 * @uthor: Sakshyam Dahal
*/

import java.util.Arrays;
import java.util.Random;

public class InsertionSort {
	public <T extends Comparable<T>> void sort(T[] items)
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
			items[j] = temp;
		}
	}
}
