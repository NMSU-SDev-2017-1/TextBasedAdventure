import java.io.*;
public class Skeleton extends Monster
{
   public Skeleton(){
      super("Skeleton", 10, 2);
      Equipment skeletonSword = new Equipment("Skeleton Sword", 1, 5, 0, 2, 0, 0, "P", "A skeleton sword.");
      inventory[0] = skeletonSword;
      inventory[1] = null;
      inventory[2] = null;
   }
	
	public void printSkeleton()
	{
		System.out.println();
		System.out.println("        .-.");
		System.out.println("       (e.e)");
		System.out.println("        (m)");
		System.out.println("      .-=\"=-.  W");
		System.out.println("     // =T= \\,/");
		System.out.println("    () ==|== ()");
		System.out.println("     \\  =V=");
		System.out.println("      M(oVo)");
		System.out.println("       // \\");
		System.out.println("      //   \\");
		System.out.println("     ()     ()");
		System.out.println("      \\     ||");
		System.out.println("       \\'   \'|");
		System.out.println("     ==\"     \"==");
	}
}
