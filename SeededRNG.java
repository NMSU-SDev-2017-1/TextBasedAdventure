import java.util.Random;
public class SeededRNG
{
	Random rand;
	
	public void SeededRNG()
	{
	}
	
	public int getRandomIntRange(int low, int high)
	{
		rand = new Random(System.currentTimeMillis());
		int randomInt = rand.nextInt(high - low) + low;
		return randomInt;
	}
}