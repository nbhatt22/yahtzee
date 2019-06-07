
public class YahzteeGame 
{

	public static void main(String[] args) 
	{
		Die d = new Die();
		
		for(int i =0; i < 10; i++)
		{
			System.out.println("roll(): " + d.roll());
		}
		System.out.println("getValue(): " + d.getValue());
	}

}
