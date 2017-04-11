import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Minotaur extends Monster
{
   public Minotaur(){
      super("Skeleton", 25, 7, 50);
      Equipment minotaurStaff = new Equipment("Minotaur Staff", 1, 5, 0, 2, 0, 0, "P", "A minotaur staff.", 1);
      Equipment minotaurBow = new Equipment("Minotaur Bow", 1, 5, 0, 1, 0, 0, "P", "A bow made of elderwood.", 1);
      Consumable bread = new Consumable("Bread", 1, 5, 2,0,0,0, "Regular Ol' Bread. The choice meal of every Navy Seal.", 2);
      Consumable bread2 = new Consumable("Bread2", 1, 5, 2,0,0,0, "Regular Ol' Bread, but slightly different. The choice meal of every Navy Seal.", 2);
	  LootTable temp = new LootTable(3);
	  possibleLoot = temp;
	  possibleLoot.add(minotaurStaff, 45);
	  possibleLoot.add(minotaurBow, 30);
	  possibleLoot.add(bread, 50);
	  possibleLoot.add(bread2, 2);
	  createInventory();
      
   }
	
	public void printMinotaur()
	{
		System.out.println();
		System.out.println("     |\____/|");
		System.out.println("    (\|----|/)");
		System.out.println("     \ 0  0 /");
		System.out.println("      |    |");
		System.out.println("   ___/\../\____    ");
		System.out.println("  /     --       \ ");
		System.out.println(" /  \         /   \    ");
		System.out.println("|    \___/___/(   | ");
		System.out.println("\   /|  }{   | \  )");
		System.out.println(" \  ||__}{__|  |  | ");
		System.out.println("  \ |;;;;;;;\  \ / \_");
		System.out.println("   \ /;;;;;;;;| [,,[|======' ");
		System.out.println("     |;;;;;;/ |     /");
		System.out.println("     ||;;|\   |");
      System.out.println("     ||;;/|   /");
		System.out.println("     \_|:||__| ");
		System.out.println("      \ ;||  /|");
		System.out.println("      |= || =||");
		System.out.println("      /_/  \_\");

	}
}

/*

     |\____/|                                              
    (\|----|/)                                             
     \ 0  0 /         
      |    |                                               
   ___/\../\____       
  /     --       \                                         
 /  \         /   \                                        
|    \___/___/(   |                                        
\   /|  }{   | \  )                                        
 \  ||__}{__|  |  |                                        
  \ |;;;;;;;\  \ / \_______                               
   \ /;;;;;;;;| [,,[|======'                               
     |;;;;;;/ |     /                                      
     ||;;|\   |                                            
     ||;;/|   /                                            
     \_|:||__|                                             
      \ ;||  /                                             
      |= || =|                                             
      |= /\ =|                                             
      /_/  \_\ 

*/