import java.util.Random;

public class Die 
{
	private int value;
	Random rand = new Random();
	
	public Die()
	{
		 value = 0;
	}
	public int roll()
	{
		 value = (rand.nextInt(6)+1);
		return value;
	}
	public int getValue()
	{
		return value;
	}
	
}
