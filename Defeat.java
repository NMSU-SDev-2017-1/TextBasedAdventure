import java.util.Scanner;

//Defeat.java
//Written by: TBAD
//Defeat scripts for post-combat

public class Defeat{
   public static void enemyDefeat(Monster monster, Character player){
      Scanner scan = new Scanner(System.in);
      System.out.println();
      player.modCoins(monster.getCoinDropValue());
      System.out.println("Your attack destroys the "  + monster.getName() + "." + " You collected: " + monster.getCoinDropValue() + " coins.");
      System.out.println("You check the fallen foe for items: ");
      monster.updateDeathItems();
      monster.deathItems();
      while(monster.inventory[0] != null){
	      System.out.println();
	      System.out.println();
         System.out.println("Do you wish to take any items?");
         System.out.println("1. Yes");
         System.out.println("2. No");
         int itemResponse = scan.nextInt();
         if(itemResponse == 1){ 
	         System.out.println();
            System.out.println("Which item will you take?");
            monster.deathItems();
	         System.out.println();
            int monsterItems = monster.getInventoryNum();
            int itemSelection = scan.nextInt();
            if((itemSelection > 0) && (itemSelection <= monsterItems) && (monster.inventory[itemSelection-1] != null)){
               player.addInventoryItem(monster.inventory[itemSelection-1]);
               monster.inventory[itemSelection-1] = null;
               monster.updateDeathItems();
            }
            else
               System.out.println("That is not a valid item selection.");
         }//end if
         else{
	    System.out.println();
            System.out.println("You leave your fallen foe.");
            return;
         }
         System.out.println();
      }//end while
   }//end enemyDefeat
}//end class
