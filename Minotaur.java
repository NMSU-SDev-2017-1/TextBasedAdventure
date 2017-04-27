import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Minotaur extends Monster
{
   public Minotaur(){
      super("Minotaur", 25, 13, 6, 50);
      Equipment minotaurStaff = new Equipment("Minotaur Polearm", 2, 500, 0, 10, 0, 0, "P", "A large minotaur staff. Its imposing size is sure " + 
         "to be matched by its power.  ATTACK +3.", 1, 8);
      Equipment minotaurBow = new Equipment("A Minotaur Bow & Arrows", 2, 450, 0, 4, 0, 0, "P", "A bow made of elderwood. " + 
         "It is both flexible and sturdy at the same time.  ATTACK +4", 1, 4);
      Consumable bread = new Consumable("Bread", 1, 5, 2,0,0,0, "Regular Ol' Bread. The choice meal of every Navy Seal.", 2);
      Consumable bread2 = new Consumable("Strange Bread", 1, 5, 2,0,0,0, "Regular Ol' Bread, but slightly different. The choice meal of every Navy Seal.", 2);
	  LootTable temp = new LootTable(3);
	  possibleLoot = temp;
	  possibleLoot.add(minotaurStaff, 45);
	  possibleLoot.add(minotaurBow, 30);
	  possibleLoot.add(bread, 50);
	  possibleLoot.add(bread2, 2);
	  createInventory();
      
   }
	
	public void print()
	{
		System.out.println();
		System.out.println("     |\\____/|");
		System.out.println("    (\\|----|/)");
		System.out.println("     \\ 0  0 /");
		System.out.println("      |    |");
		System.out.println("   ___/\\../\\____    ");
		System.out.println("  /     --       \\ ");
		System.out.println(" /  \\         /   \\    ");
		System.out.println("|    \\___/___/(   | ");
		System.out.println("\\   /|  }{   | \\  )");
		System.out.println(" \\  ||__}{__|  |  | ");
		System.out.println("  \\ |;;;;;;;\\  \\ / \\_");
		System.out.println("   \\ /;;;;;;;;| [,,[|======' ");
		System.out.println("     |;;;;;;/ |     /");
		System.out.println("     ||;;|\\   |");
      System.out.println("     ||;;/|   /");
		System.out.println("     \\_|:||__| ");
		System.out.println("      \\ ;||  /|");
		System.out.println("      |= || =||");
		System.out.println("      /_/  \\_\\");
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
