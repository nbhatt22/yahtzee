import java.util.Random;

public class Yahtzee 
{
	private Die[] dice;
	private static int[] count;
	static Random rand = new Random();

	public Yahtzee()
	{
		dice = new Die[5];
		
		for(int i = 0; i < 5; i++)
		{
			dice[i] = new Die();
		}
	}
		public void rollAllDice()
		{
			dice[0].roll();
			dice[1].roll();
			dice[2].roll();
			dice[3].roll();
			dice[4].roll();
		}
		public void rollADice(int dieNumber)
		{
			int dieIndex = dieNumber-=1;
			dice[dieIndex].roll();
		}
		public int getADie(int dieNumber)
		{
			int dieIndex = dieNumber-=1;
			return dice[dieIndex].getValue();
		}
		public String showDice()
		{
			int dice1 = dice[0].getValue();
			int dice2 = dice[1].getValue();
			int dice3 = dice[2].getValue();
			int dice4 = dice[3].getValue();
			int dice5 = dice[4].getValue();
			String format = "+------+---+---+---+---+---+\n| Dice | 1 | 2 | 3 | 4 | 5 |\n+------+---+---+---+---+---+\n| Face | " + dice1 + " | " + dice2 + " | " + dice3 + " | " + dice4 + " | " + dice5 + " |\n+------+---+---+---+---+---+";
			return format;
		}

		private static int countUp(int value)
		{
			count[rand.nextInt(6)]++;
			return count[value];
		}
		public static void updateCount()
		{
			for(int i = 0; i < 6; i++)
			{
				count[i] = countUp(i + 1);
				System.out.println("Number of " + (i + 1) + "s rolled: " + count[i]);
			}
		}
		public int getScoreOnes()
		{
			return count[0]*1;
		}
		public int getScoreTwos()
		{
			return count[1]*2;
		}
		public int getScoreThrees()
		{
			return count[2]*3;
		}
		public int getScoreFours()
		{
			return count[3]*4;
		}
		public int getScoreFives()
		{
			return count[4]*5;
		}
		public int getScoreSixes()
		{
			return count[5]*6;
		}
		public int getScoreThreeOfAKind()
		{	
			int num = 0;
			for (int x=0; x<6; x++)
			{
				if (countUp(x) == 3)
				{
					for(int j = 0; j<6; j++)
						{
							num+= countUp(x) * x;
						}
				}
			}
			return num;
		}
		public int getScoreFourOfAKind()
		{
			int num = 0;
			for (int x = 0; x<6; x++)
			{
				if (countUp(x) == 4)
				{
					for(int j = 0; j<6; j++)
					{
						num+=countUp(x)*x;
					}
				}
			}
			return num;
		}
		public int getScoreFullHouse()
		{
			int num = 0;
			for (int x=0; x<6;x++)
			{
				if (countUp(x) == 3)
				{
					for (int y=0; y<6; y++)
					{
						if (countUp(y) == 2)
						{
							num+=25;
						}
					}
				}
			}
			return num;
		} 

		public int getScoreSmallStraight()
		{
			int num = 0;
			if ((countUp(3) >=1 && countUp(4) >=1) && ((countUp(1)>=1 && countUp(2) >=1 ) || (countUp(2)>=1 && countUp(5)>=1) ||(countUp(5)>=1 && countUp(6) >=1)));
			{
				num =30;
			}
			return num;
		}
		public int getScoreLargeStriaght()
		{
			boolean tf = false;
			int num = 0;
			if ((((countUp(2)>=1 && countUp(3)>=1 && countUp(4) >=1 && countUp(5) >=1) && (countUp(1) >=1 || countUp(6) >=1))));
			{
				tf = true;
				num=40;
			}
			return num;
		}
		public int getScoreChance()
		{
			int num = 0;
			for (int x=0; x<5;x++)
			{
				num = dice[x].getValue();
			}
		return num;
		}
		public int getScoreYahtzee()
		{
			int num =0;
			for (int i=0; i<6; i++)
			{
				if (countUp(i) == 5)
				{
					num+=50;
				}
			}
			return num;
		}
		public String getScoreCare()
	}

