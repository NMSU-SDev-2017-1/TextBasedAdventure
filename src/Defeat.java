import java.util.Scanner;

//Defeat.java
//Written by: TBAD
//Defeat scripts for post-combat

public class Defeat{
   public static void enemyDefeat(Monster monster, Character player) throws InterruptedException {
      Scanner scan = new Scanner(System.in);
      System.out.println();
      player.modCoins(monster.getCoinDropValue());
      GameSystem.readFast("Your attack destroys the "  + monster.getName() + "." + " You collected: " + monster.getCoinDropValue() + " coins.");
      GameSystem.readFast("You check the fallen foe for items: ");
      monster.updateDeathItems();
      monster.deathItems();
      while(monster.inventory[0] != null){
	      System.out.println();
	      System.out.println();
         GameSystem.readFast("Do you wish to take any items?");
         System.out.println("(1)Yes.   (2)No");
         int itemResponse = scan.nextInt();
         if(itemResponse == 1){ 
	         System.out.println();
            GameSystem.readFast("Which item will you take?");
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
               GameSystem.readFast("That is not a valid item selection.");
         }//end if
         else{
	          System.out.println();
            GameSystem.readFast("You leave your fallen foe.");
            return;
         }
         System.out.println();
      }//end while
   }//end enemyDefeat
   
   public static void PlayerDefeat() throws InterruptedException {
      GameSystem.read("Hahahahahahahaha.");
      Thread.sleep(500);
      GameSystem.read("You have Died!");
      Thread.sleep(500);
      GameSystem.read("Take a moment to wallow in shame.");
      Thread.sleep(3000);
      System.exit(0);
   }
   
}//end class
