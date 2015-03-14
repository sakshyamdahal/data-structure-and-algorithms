public class GameEntry {
	String playerName; 			// person who made this score
	int scoreEarned;				// value of the score

	/* construct a game entry with given parameters */
	public GameEntry(String name, int score)
	{
		playerName = name;
		scoreEarned = score;
	}

	/* getter methods */
	public String getName()
	{
		return playerName;
	}

	public int getScore()
	{
		return scoreEarned;
	}
	

	/* give a string representation of game Entry as (playerName	:	scoreEarned) */
	public String toString()
	{
		return String.format("%s : %d", playerName, scoreEarned);
	}

}
