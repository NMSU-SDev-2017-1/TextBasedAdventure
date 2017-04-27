import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Goblin extends Monster
{
   public Goblin(){
      super("Goblin", 12, 13, 2, 10);
      Equipment goblinMace = new Equipment("Goblin Mace", 2, 100, 0, 1, 0, 0, "P", "A poorly constructed mace. It feels as though it was used for " + 
         "purposes beyond its intended use.  ATTACK +1.", 1, 6);
      Equipment goblinDagger = new Equipment("Goblin Dagger", 2, 150, 0, 2, 0, 0, "P", "A dagger held by high-status goblins." + 
         "While dull, it is a sybol of status amongst their ranks.  ATTACK +2", 1, 3);
      Consumable bread = new Consumable("Bread", 1, 5, 2,0,0,0, "Regular Ol' Bread. The choice meal of every Navy Seal.", 2);
      Consumable bread2 = new Consumable("Strange Bread", 1, 5, 2,0,0,0, "Regular Ol' Bread, but slightly different. The choice meal of every Navy Seal.", 2);
	  LootTable temp = new LootTable(3);
	  possibleLoot = temp;
	  possibleLoot.add(goblinMace, 45);
	  possibleLoot.add(goblinDagger, 30);
	  possibleLoot.add(bread, 50);
	  possibleLoot.add(bread2, 2);
	  createInventory();
      
   }
	
	public void print()
	{
		System.out.println("|             ,        ,        |");
		System.out.println("|            //(.-''-.)\\       |");
		System.out.println("|        |\\ \\/      \\/  /|   |");
		System.out.println("|        | \\ / =.  .=  \\ / |   |");
		System.out.println("|       \\( \\   o\\//o   / )/   |");
		System.out.println("|         \\_, '-//  \\-' ,_/    |");
		System.out.println("|           /    \\__/   \\      |");
		System.out.println("|          \\  \\__/\\__/ /      |");
		System.out.println("|         __\\  \\|--|/ /___    |");
		System.out.println("|        /`  \\  \\    /   `\\   |");
		System.out.println("|       /        '----'      \\  |");
		System.out.println();
		System.out.println();




      

	}
}
/*
             ,      ,
            /(.-""-.)\
        |\  \/      \/  /|
        | \ / =.  .= \ / |
        \( \   o\/o   / )/
         \_, '-/  \-' ,_/
           /   \__/   \
           \ \__/\__/ /
         ___\ \|--|/ /___
       /`    \      /    `\
      /       '----'       \


*/
