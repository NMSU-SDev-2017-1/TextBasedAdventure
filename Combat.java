import java.util.Scanner;

//Class.java
//Written by: TBAD
//Scripts for enemy VS player combat

public class Combat{
   
   //Standard Combat Method, can be used with any monster object. 
   public static void standardCombat(Monster monster, Character player){
           int criticalHit = player.getAttack() + (player.getAttack()/2);
           Scanner scan = new Scanner(System.in);
	   while(player.healthpoints >0){
	       System.out.println("What is your next action?");
	       System.out.println("1. Attack");
	       System.out.println("2. View Inventory");
	       System.out.println("3. Check Status");
	       System.out.println("4. Switch Active Weapon");
          System.out.println("5. Run");
	       System.out.println();
	       int engagedAction = scan.nextInt();
	       if(engagedAction == 1){
	          System.out.println();
		  System.out.println("You attack the " + monster.getName() + ".");
		  monster.takeDamage(player.getAttack());
		  System.out.println("You deal " + player.getAttack() + " damage.");
		  if(monster.hp <= 0){
                     Defeat.enemyDefeat(monster, player);
                     return;
                  }
	          System.out.println();
		  System.out.println("The " + monster.getName() + " strikes back.");
		  player.modHP(-(monster.getAttack()));
		  System.out.println("You take " + monster.getAttack() + " damage.");
		  System.out.println("Status after combat cycle: ");
		  System.out.println(player.toString());
	          System.out.println();
		  if(player.healthpoints == 0){
		     System.out.println("You've been dealt a fatal blow...");
		     return;
		  }
	       }
	       else if(engagedAction == 2){
		       player.useInventory();
          }	       
	       else if(engagedAction == 3){
	          System.out.println();
		       System.out.println(player.toString());
             System.out.println();
	       }
	       else if(engagedAction == 4){
		       player.weaponSwitch();
             player.equipmentMod();
             if(player.equipment[4] == null)
                return;
             else
                System.out.println(player.equipment[4].getItemName() + " is now your Active Weapon.");
	       } 
	       else if(engagedAction == 5){
		       System.out.println("You attempt to flee but the " + monster.getName() + " cuts you off!");
		       System.out.println("There's no escaping this fight!");
	       }
         else
            System.out.println("That is not a correct input.");
	    }//end while (Combat)
   }//end standardCombat
   
   //Player advantage combat method, gives player critical hit at the beginning of the battle.
   public static void advantageCombat(Monster monster, Character player){
      int criticalHit = player.getAttack() + (player.getAttack()/2);
      Scanner scan = new Scanner(System.in);
      
      System.out.println("You caught the enemy off-guard and dealt a critical blow!");
      monster.takeDamage(criticalHit);
      System.out.println("You dealt " + criticalHit + " damage.");
      if(monster.hp <=0){
         Defeat.enemyDefeat(monster, player);
         return;
      }
      while(player.healthpoints >0){
          System.out.println("What is your next action?");
	       System.out.println("1. Attack");
	       System.out.println("2. View Inventory");
	       System.out.println("3. Check Status");
	       System.out.println("4. Switch Active Weapon");
          System.out.println("5. Run");
	       System.out.println();
	       int engagedAction = scan.nextInt();
	       if(engagedAction == 1){
	          System.out.println();
		  System.out.println("You attack the " + monster.getName() + ".");
		  monster.takeDamage(player.getAttack());
		  System.out.println("You deal " + player.getAttack() + " damage.");
		  if(monster.hp <= 0){
                     Defeat.enemyDefeat(monster, player);
                     return;
                  }
	          System.out.println();
		  System.out.println("The " + monster.getName() + " strikes back.");
		  player.modHP(-(monster.getAttack()));
		  System.out.println("You take " + monster.getAttack() + " damage.");
		  System.out.println("Status after combat cycle: ");
		  System.out.println(player.toString());
	          System.out.println();
		  if(player.healthpoints == 0){
		     System.out.println("You've been dealt a fatal blow...");
		     return;
		  }
	       }
	       else if(engagedAction == 2){
		       player.useInventory();
          }	 
          else if(engagedAction == 3){
	          System.out.println();
		       System.out.println(player.toString());
             System.out.println();
	       }
	       else if(engagedAction == 4){
		       player.weaponSwitch();
             player.equipmentMod();
             System.out.println(player.equipment[4].getItemName() + " is now your Active Weapon.");
	       } 
	       else if(engagedAction == 5){
		       System.out.println("You attempt to flee but the " + monster.getName() + " cuts you off!");
		       System.out.println("There's no escaping this fight!");
	       }
         else
            System.out.println("That is not a correct input.");
	    }//end while (Combat)
   }//end advantageCombat
}//end class
