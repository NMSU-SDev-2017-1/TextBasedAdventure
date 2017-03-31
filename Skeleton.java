import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Skeleton extends Monster
{
   public Skeleton(){
      super("Skeleton", 10, 2, 5);
      Equipment skeletonSword = new Equipment("Skeleton Sword", 1, 5, 0, 2, 0, 0, "P", "A skeleton sword.", 1);
      Equipment skeletonBow = new Equipment("Skeleton Bow", 1, 5, 0, 1, 0, 0, "P", "A bow made of old bones.", 1);
      Consumable bread = new Consumable("Bread", 1, 5, 2,0,0,0, "Regular Ol' Bread. The choice meal of every Navy Seal.", 2);
      
      for(int i = 0; i < inventory.length; i++){
         Random rand = new Random();
		   int randomInt = rand.nextInt(8 - 1 + 1) + 1;
         if(randomInt <= 2)
            inventory[i] = skeletonSword;
         else if(randomInt > 2 && randomInt <= 4)
            inventory[i] = skeletonBow;
         else if(randomInt > 4 && randomInt <= 6)
            inventory[i] = bread;
         else if(randomInt >6)
            inventory[i] = null;
      }
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
