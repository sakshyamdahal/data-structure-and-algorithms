public class GameScoreBoard {
	private int numEntries; // actual number of game entries in the score board
	private GameEntry[] board; // store all the game entries in the board
	
	/* construct a new score board with a given capacity */
	public GameScoreBoard(int capacity)
	{
		board = new GameEntry[capacity];
		numEntries = 0;
	}
	
	/* 
	 * Add an entry to the game board 
	 * only adds the entry if the board is not full
	 * or when the board is full but the score entry
	 * is higher than the minimum score entry in the board
	 * 
	 * also keep the score board sorted when adding a new game entry
	 */
	public boolean add(GameEntry e)
	{
		int score = e.getScore();
		
		/* check if the score matches our criteria of high score */
		if (numEntries < board.length || score > board[numEntries - 1].getScore())
		{
			// we really added a new entry without replacing old one
			if (numEntries < board.length)
				numEntries++;
			
			// find the appropriate index for the new entry
			int j = numEntries - 1;
			
			while (j > 0 && board[j - 1].getScore() < score)
			{
				board[j] = board[j - 1];
				j--;
			}
			
			// finally put the new entry in its correct place
			board[j] = e;
			
		}
		
		return false;
	}
	
	// removes and returns the gameEntry at specified index
	public GameEntry remove(int index) throws IndexOutOfBoundsException
	{
		if (index < 0 || index >= numEntries)
			throw new IndexOutOfBoundsException("No such entry.");
		
		GameEntry temp = board[index];
		
		// shift all the game entries towards the left
		for (int i = index; i < numEntries - 1; i++)
		{
			board[i] = board[i+1];
		}
		
		/* last entry will be null since they are all shifted */
		board[numEntries - 1] = null;
		
		numEntries--; // keep track of correct numEntries
		
		// return the deleted game entry
		return temp;
	}
	
	// returns string representation of game board
	public String toString()
	{
		StringBuffer s = new StringBuffer();
		s.append("[ ");
		for (GameEntry e : board)
		{
			if (e.equals(board[board.length - 1]))
				s.append(e.toString());
			else
				s.append(e.toString() + ",");
		}
		
		s.append(" ]");
		
		return s.toString();
	}
	
}
