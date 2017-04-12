public class WeightedRNGTest
{
	public static void main(String[] args)
	{
		int[] testWeights = {10, 16, 1, 5, 100};
		int totalones = 0;
		int totaltwos = 0;
		int totalthrees = 0;
		int totalfours = 0;
		int totalfives = 0;
		int totalrolls = 0;
		int roll = 0;
		for(int i = 0; i < 100; i++)
		{
			roll = RandomNumberGeneration.getRandomWeighted(1, 5, testWeights);
/* 			try
			{
				Thread.sleep(500);
			}
			catch(InterruptedException ie)
			{ 
			}*/
			totalrolls++;
			if(roll == 1)
			{
				totalones++;
			}
			else if(roll == 2)
			{
				totaltwos++;
			}
			else if(roll == 3)
			{
				totalthrees++;
			}
			else if(roll == 4)
			{
				totalfours++;
			}
			else if(roll == 5)
			{
				totalfives++;
			}
		}
		System.out.println("Total ones: " + totalones);
		System.out.println("Total twos: " + totaltwos);
		System.out.println("Total threes: " + totalthrees);
		System.out.println("Total fours: " + totalfours);
		System.out.println("Total fives: " + totalfives);
		System.out.println("Total rolls: " + totalrolls);
		System.out.println("Total 1, 2, 3, 4, & 5: " + (totalones + totaltwos + totalthrees + totalfours + totalfives));
		double percentones = (double) totalones/totalrolls;
		double percenttwos = (double) totaltwos/totalrolls;
		double percentthrees = (double) totalthrees/totalrolls;
		double percentfours = (double) totalfours/totalrolls;
		double percentfives = (double) totalfives/totalrolls;
		System.out.println("Percent of ones: " + percentones);
		System.out.println("Percent of twos: " + percenttwos);
		System.out.println("Percent of threes: " + percentthrees);
		System.out.println("Percent of fours: " + percentfours);
		System.out.println("Percent of fives: " + percentfives);
	}
}