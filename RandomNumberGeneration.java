import java.util.Random;
public class RandomNumberGeneration
/*
This is a utility class containing several methods of generating random numbers.
Written by: Troy Redfearn
Last edited: 4/1/2017
*/
{
	/*
	Generates a random int from low to high using system time as the seed.
	*/
	public static int getSeededRandomIntRange(int low, int high)
	{
		Random rand = new Random(System.currentTimeMillis());
		int randomInt = rand.nextInt(high - low) + low;
		return randomInt;
	}
	
	/*
	Generates a non-seeded random int from low to high.
	*/
	public static int getRandomIntRange(int low, int high)
	{
		Random rand = new Random();
		int randomInt = rand.nextInt(high - low) + low;
		return randomInt;
	}
	
	/*
	This method is used to choose a random int between a given range with given
	weights.
	@param low: The low value of the range of ints you want to generate
	@param high: The high value of the range of ints you want to generate
	@param weights[]: An array of ints where weights[0] is the weight of low,
		and weights[length-1] is the weight of high. This method will throw an 
		exception if the length of weights[] is greater than the range of 
		values or if the range provided is invalid.
	*/
	public static int getRandomWeighted(int low, int high, int weight[])
	{
		int weights[] = weight.clone();
		if(low > high)
		{
			throw new IllegalArgumentException("Low range value greater than high.");
		}
		if(weights.length != ((high - low) + 1))
		{
			throw new IllegalArgumentException("Range and size of weights array do not match.");
		}
		
		int totalWeights = 0;
		for(int i = 0; i < weights.length; i++)
		{
			int temp = weights[i] * 100;
			weights[i] = temp;
			totalWeights += weights[i];
		}
		int rolledNumber = getRandomIntRange(1, totalWeights);
		
		int cursor = rolledNumber;
		for(int i = 0; i < weights.length; i++)
		{
			cursor -= weights[i];
			if(cursor <= 0)
			{
				return i + low;
			}
		}
		return 0;
	}
}