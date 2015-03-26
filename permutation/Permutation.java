import java.util.LinkedList;

public class Permutation {

	public static void permutation(String[] items)
	{
		permutation(items.length, new LinkedList<String>(), items);
	}

	private static void permutation(int num, LinkedList<String> looked, String[] set)
	{
		if (num == 0)
		{
			StringBuilder s = new StringBuilder();
			for (String j : looked)
				s.append(j);
			System.out.println(s.toString());
		}
		else
		{
			for (int i = 0; i < set.length; i++)
			{
				LinkedList<String> l = (LinkedList<String>) looked.clone();
				l.addLast(set[i]);

				String[] arr = giveArray(set, i);

				permutation(num - 1, l, arr);
			}
		}
	}

	private static String[] giveArray(String[] set, int index)
	{
		String[] arr = new String[set.length - 1];
		int j = 0;
		for (int i = 0; i < set.length; i++)
		{
			if (i != index)
			{
				arr[j++] = set[i];
			}
		}

		return arr;
	}
