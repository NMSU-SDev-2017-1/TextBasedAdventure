import java.util.Scanner;

public class Combat{
   
   public static void standardCombat(Monster monster, Character player){
           int criticalHit = player.getAttack() + (player.getAttack()/2);
           Scanner scan = new Scanner(System.in);
	   while(player.healthpoints >0){
	       System.out.println("What is your next action?");
	       System.out.println("1. Attack");
	       System.out.println("2. View Inventory");
	       System.out.println("3. Check Status");
	       System.out.println("4. Run");
	       int engagedAction = scan.nextInt();
	       
	       if(engagedAction == 1){
		  System.out.println("You attack the " + monster.getName() + ".");
		  monster.takeDamage(player.getAttack());
		  System.out.println("You deal " + player.getAttack() + " damage.");
		  if(monster.hp <= 0){
                     Defeat.enemyDefeat(monster, player);
                     return;
                  }
		  System.out.println("The " + monster.getName() + " strikes back.");
		  player.modHP(-(monster.getAttack()));
		  System.out.println("You take " + monster.getAttack() + " damage.");
		  System.out.println("Status after combat cycle: ");
		  System.out.println(player.toString());
		  if(player.healthpoints == 0){
		     System.out.println("You've been dealt a fatal blow...");
		     return;
		  }
	       }
	       else if(engagedAction == 2){
		  System.out.println();
		  System.out.println("Your current inventory:");
		  System.out.println(player.getInventoryList());
		  System.out.println();
		  System.out.println("Will you use an item?");
		  System.out.println("1. Yes");
		  System.out.println("2. No");    
		  int itemOption = scan.nextInt();
		  if(itemOption == 1){
		     int useOption = 1;
		     int i = 0;
		     System.out.println("Which item will you use?");
		     while(player.inventory[i] != null){
		        System.out.println( useOption +". " +player.inventory[i].getItemName());
		        useOption++;
		        i++;
		     }
		     int numberOfItems = useOption;
		     int itemSelection = scan.nextInt();
		     if(itemSelection <= useOption && player.inventory[itemSelection-1] != null){
		        System.out.println("You used " + player.inventory[itemSelection-1].getItemName() + ".");
		        player.modHP(player.inventory[itemSelection-1].getHealthMod());
		        player.inventory[itemSelection-1] = null;
		     }
		  }
		  else if(itemOption == 2){
		     System.out.println();
		  }       
	       }
	       else if(engagedAction == 3){
		  System.out.println(player.toString());
	       }
	       else if(engagedAction == 4){
		  System.out.println("You attempt to flee but the " + monster.getName() + " cuts you off!");
		  System.out.println("There's no escaping this fight!");
	       } 
	       
	       
	    }//end while (Combat)
   }//end standardCombat
   
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
       System.out.println("4. Run");
       int engagedAction = scan.nextInt();
       
       if(engagedAction == 1){
	  System.out.println("You attack the " + monster.getName() + ".");
	  monster.takeDamage(player.getAttack());
	  System.out.println("You deal " + player.getAttack() + " damage.");
	  if(monster.hp <= 0){
	     Defeat.enemyDefeat(monster, player);
             return;
          }
	  System.out.println("The " + monster.getName() + " strikes back.");
	  player.modHP(-(monster.getAttack()));
	  System.out.println("You take " + monster.getAttack() + " damage.");
	  System.out.println("Status after combat cycle: ");
	  System.out.println(player.toString());
	  if(player.healthpoints == 0){
	     System.out.println("You've been dealt a fatal blow...");
	     return;
	  }
       }
       else if(engagedAction == 2){
	  System.out.println();
	  System.out.println("Your current inventory:");
	  System.out.println(player.getInventoryList());
	  System.out.println();
	  System.out.println("Will you use an item?");
	  System.out.println("1. Yes");
	  System.out.println("2. No");    
	  int itemOption = scan.nextInt();
	  if(itemOption == 1){
	     int useOption = 1;
	     int i = 0;
	     System.out.println("Which item will you use?");
	     while(player.inventory[i] != null){
	        System.out.println( useOption +". " +player.inventory[i].getItemName());
	        useOption++;
	        i++;
	     }
	     int numberOfItems = useOption;
	     int itemSelection = scan.nextInt();
	     if(itemSelection <= useOption && player.inventory[itemSelection-1] != null){
	        System.out.println("You used " + player.inventory[itemSelection-1].getItemName() + ".");
	        player.modHP(player.inventory[itemSelection-1].getHealthMod());
	        player.inventory[itemSelection-1] = null;

	     }
	  }
	  else if(itemOption == 2){
	     System.out.println();
	  }       
       }
       else if(engagedAction == 3){
	  System.out.println(player.toString());
       }
       else if(engagedAction == 4){
	  System.out.println("You attempt to flee but the " + monster.getName() + " cuts you off!");
	  System.out.println("There's no escaping this fight!");
       } 
       
       
    }//end while (Combat)
   }//end advantageCombat
}//end class
