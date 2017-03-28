import java.util.Scanner;

public class Defeat{
   public static void enemyDefeat(Monster monster, Character player){
      Scanner scan = new Scanner(System.in);
      System.out.println("Your attack destroys the "  + monster.getName() + "." + " The enemy dropped the following items:");
      monster.deathItems(); 
      while(monster.inventory[0] != null){
         System.out.println("Do you wish to take any items?");
         System.out.println("1. Yes");
         System.out.println("2. No");
         int itemResponse = scan.nextInt();
         if(itemResponse == 1){ 
            System.out.println("Which item will you take?");
            monster.deathItems();
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
            System.out.println("You leave your fallen foe.");
            return;
         }
         System.out.println();
      }//end while
   }//end enemyDefeat
}//end class
