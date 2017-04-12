public class MonsterTest
{
	public static void main(String args[])
	{
		Skeleton testSkeleton = new Skeleton();
		testSkeleton.printSkeleton();
		Character testChar = new Character("test");
		System.out.println("Character has " + testChar.getHealth() + " health.");
		testSkeleton.attack(testChar);
		System.out.println("Character has " + testChar.getHealth() + " health.");
	}
}