import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class StackApplication {

	/* tests if the delimeters in a given expression are 
	 * properly matched
	 */
	public static boolean isBalanced(String s)
	{
		final String open = "/<[{(";
		final String close = "\\>]})";
		Deque<Character> d = new ArrayDeque<Character>(s.length());
		
		for (char c : s.toCharArray())
		{
			if (open.indexOf(c) != -1) // if its opening delimeter
			{
				d.push(c);
			}
			else if (close.indexOf(c) != -1) // its a closing delimeter
			{
				if (d.isEmpty())
					return false;
				
				if (close.indexOf(c) != open.indexOf(d.pop())) // not matched
					return false;
			}
		}
		
		return d.isEmpty();
	}
	
	
	/*
	 * test if the given html string is valid that is every opening tag has
	 * a closing tag in LIFO order
	 */
	public static boolean isValidHtml(String html)
	{
		/*
		 * <h1>Hello</h1> This is <i> Sakshyam dahal </i> 
		 */
		
		Deque<String> d = new ArrayDeque<String>();
		int openIndex = html.indexOf('<');
		
		while(openIndex != -1)
		{
			
			int close = html.indexOf('>', openIndex);
			if (close == -1)
				return false;
			
			String tag = html.substring(openIndex + 1, close);
			
			if (tag.startsWith("/")) // closing tag
			{
				if (d.isEmpty())
					return false;
				if (!d.pop().equals(tag.substring(1)))
					return false;
			}
			else
				d.push(tag);
			
			openIndex =html.indexOf('<', close+1);
		}
		
		return d.isEmpty();
	}
	
	
	public static void main(String[] args)
	{
		System.out.println(StackApplication.isBalanced("/[[[[{{{{(((())))}}}}]]]]\\"));
		isValidHtml("yeah");
		
		Scanner input = new Scanner(System.in);
		
		System.out.println(isValidHtml(input.nextLine()));
	}
}
